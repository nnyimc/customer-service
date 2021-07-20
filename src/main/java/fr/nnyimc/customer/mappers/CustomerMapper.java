package fr.nnyimc.customer.mappers;

import fr.nnyimc.customer.dto.CustomerRequestDTO;
import fr.nnyimc.customer.dto.CustomerResponseDTO;
import fr.nnyimc.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
