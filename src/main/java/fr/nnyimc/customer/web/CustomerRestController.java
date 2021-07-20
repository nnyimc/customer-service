package fr.nnyimc.customer.web;

import fr.nnyimc.customer.dto.CustomerRequestDTO;
import fr.nnyimc.customer.dto.CustomerResponseDTO;
import fr.nnyimc.customer.services.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping(path="/api")
public class CustomerRestController {
    private final CustomerService customerService;

    public CustomerRestController( CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponseDTO> allCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO get(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.addCustomer(customerRequestDTO);
    }

    @PutMapping("/customers")
    public CustomerResponseDTO update(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.updateCustomer(customerRequestDTO);
    }

    @DeleteMapping("/customers")
    public CustomerResponseDTO delete(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.deleteCustomer(customerRequestDTO);
    }
}
