package com.navid.onlinestoreserver.web;


import com.navid.onlinestoreserver.domain.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public List<Customer> getAllCustomer(){
        return null;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return null;
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@RequestBody Long id){
        return;
    }


}
