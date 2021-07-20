package fr.nnyimc.customer.services;

import fr.nnyimc.customer.dto.*;
import fr.nnyimc.customer.entities.Customer;
import fr.nnyimc.customer.mappers.CustomerMapper;
import fr.nnyimc.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImplementation(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {
        /*
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setName(customerRequestDTO.getName());
        */

        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);

        /*
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(savedCustomer.getId());
        customerResponseDTO.setName(savedCustomer.getName());
        customerResponseDTO.setEmail(savedCustomer.getEmail());
        */

        return customerMapper.customerToCustomerResponseDTO(savedCustomer);

    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.getById(id);
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public CustomerResponseDTO deleteCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer deletedCustomer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        customerRepository.delete(deletedCustomer);

        return customerMapper.customerToCustomerResponseDTO(deletedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOs = new ArrayList<>();
        for (Customer c: customers) {
            customerResponseDTOs.add(customerMapper.customerToCustomerResponseDTO(c));
        }
        return customerResponseDTOs;
    }
}
