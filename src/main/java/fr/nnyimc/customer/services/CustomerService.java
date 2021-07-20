package fr.nnyimc.customer.services;

import fr.nnyimc.customer.dto.CustomerRequestDTO;
import fr.nnyimc.customer.dto.CustomerResponseDTO;
import java.util.List;

public interface CustomerService {
    CustomerResponseDTO addCustomer(CustomerRequestDTO customer);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO updateCustomer(CustomerRequestDTO customer);
    CustomerResponseDTO deleteCustomer(CustomerRequestDTO customer);
    List<CustomerResponseDTO> listCustomers();
}
