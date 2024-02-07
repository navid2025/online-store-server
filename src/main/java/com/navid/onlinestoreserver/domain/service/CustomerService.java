package com.navid.onlinestoreserver.domain.service;

import com.navid.onlinestoreserver.domain.model.Customer;
import com.navid.onlinestoreserver.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }
}
