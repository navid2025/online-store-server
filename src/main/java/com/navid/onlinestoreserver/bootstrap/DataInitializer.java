package com.navid.onlinestoreserver.bootstrap;

import com.navid.onlinestoreserver.domain.model.Customer;
import com.navid.onlinestoreserver.domain.repository.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    public DataInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        this.initialize();
    }

    private void initialize() {

        Customer customer1 = Customer
                .builder()
                .name("navid")
                .country("United States")
                .gender("male")
                .age(35)
                .address("tehran")
                .email("navid.zare20225@gmail.com")
                .createdAt("20241002")
                .build();

        Customer customer2 = Customer
                .builder()
                    .name("saeed")
                    .country("Iran")
                    .gender("male")
                    .age(25)
                    .address("tehran")
                    .email("saeed.zare20225@gmail.com")
                    .createdAt("202310202")
                .build();
        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

}
