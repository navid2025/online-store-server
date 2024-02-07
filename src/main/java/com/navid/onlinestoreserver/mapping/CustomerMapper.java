package com.navid.onlinestoreserver.mapping;

import com.navid.onlinestoreserver.domain.model.Customer;
import com.navid.onlinestoreserver.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
