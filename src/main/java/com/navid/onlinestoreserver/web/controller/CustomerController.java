package com.navid.onlinestoreserver.web.controller;


import com.navid.onlinestoreserver.web.model.CustomerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public List<CustomerDto> getAllCustomer(){
        return null;
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        return null;
    }

    @PutMapping
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@RequestBody Long id){
        return;
    }


}
