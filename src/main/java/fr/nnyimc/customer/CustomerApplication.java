package fr.nnyimc.customer;

import fr.nnyimc.customer.dto.CustomerRequestDTO;
import fr.nnyimc.customer.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService) {
        return args -> {
            customerService.addCustomer(new CustomerRequestDTO("C01", "nnyimc", "test@outlook.com"));
            customerService.addCustomer(new CustomerRequestDTO("C02", "nmncls", "test@gmail.com"));
        };
    }

}
