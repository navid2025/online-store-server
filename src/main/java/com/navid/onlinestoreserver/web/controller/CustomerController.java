package com.navid.onlinestoreserver.web.controller;


import com.navid.onlinestoreserver.domain.service.CustomerService;
import com.navid.onlinestoreserver.web.model.CustomerDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomer(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable @PositiveOrZero Long id){
        return customerService.findById(id);
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody @Valid CustomerDto customerDto){
        return customerService.save(customerDto);
    }

    @PutMapping
    public CustomerDto updateCustomer(@RequestBody @Valid CustomerDto customerDto){
        return customerService.save(customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteById(id);
    }


}
