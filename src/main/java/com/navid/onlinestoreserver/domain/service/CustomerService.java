package com.navid.onlinestoreserver.domain.service;

import com.navid.onlinestoreserver.domain.repository.CustomerRepository;
import com.navid.onlinestoreserver.mapping.CustomerMapper;
import com.navid.onlinestoreserver.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto save(CustomerDto customerDto) {

        return customerMapper.customerToCustomerDto(
                customerRepository.save(customerMapper.customerDtoToCustomer(customerDto))
        );
    }

    public List<CustomerDto> findAllCustomers(){
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        customerRepository.findAll().forEach(customer -> customerDtos.add(customerMapper.customerToCustomerDto(customer)));
        return customerDtos;
    }

    public CustomerDto findById(Long id){
        return customerMapper.customerToCustomerDto(
                customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find customer'")));
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }
}
