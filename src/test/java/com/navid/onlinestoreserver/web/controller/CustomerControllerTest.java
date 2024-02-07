package com.navid.onlinestoreserver.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navid.onlinestoreserver.domain.service.CustomerService;
import com.navid.onlinestoreserver.web.model.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    List<CustomerDto> customerDtos = new ArrayList<>();

    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();
    CustomerDto customerDto2;


    @BeforeEach
    public void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        CustomerDto customerDto1  = CustomerDto
                .builder()
                    .name("navid")
                    .email("navid@gmail.com")
                    .address("123 Main St")
                    .age(35)
                    .gender("male")
                    .country("United States")
                .build();

        customerDto2  = CustomerDto
                .builder()
                    .name("sally")
                    .email("sally@gmail.com")
                    .address("546 Main St")
                    .age(30)
                    .gender("male")
                    .country("Britain")
                .build();

        customerDtos.addAll(List.of(customerDto1, customerDto2));
    }

    @Test
    void getAllCustomer() throws Exception {

        //given
        when(customerService.findAllCustomers()).thenReturn(customerDtos);

        //when
       var result  = mockMvc.perform(get("/customers"));

        //then
        result.andExpect(MockMvcResultMatchers.status().is(200));
        result.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(customerDtos)));
        result.andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        verify(customerService, times(1)).findAllCustomers();
        verify(customerService, times(0)).deleteById(anyLong());
        verifyNoMoreInteractions(customerService);
    }

    @Test
    void getCustomerById() throws Exception {

        //given
        when(customerService.findById(anyLong())).thenReturn(customerDto2);
        //when
        var result  = mockMvc.perform(get("/customers/1"));

        //then
        result.andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        result.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(customerDto2)));
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createCustomer() throws Exception {
        //given
        when(customerService.save(any())).thenReturn(customerDto2);
        //when
        var result = mockMvc.perform(post("/customers")
                .content(mapper.writeValueAsString(customerDto2)).contentType("application/json"));

        //then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        verify(customerService).save(any());
    }

    @Test
    void updateCustomer() throws Exception {
        //given
        when(customerService.save(any())).thenReturn(customerDto2);
        //when
        var result = mockMvc.perform(put("/customers")
                .content(mapper.writeValueAsString(customerDto2)).contentType("application/json"));
        //then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        verify(customerService).save(any());
        result.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(customerDto2)));
    }

    @Test
    void deleteCustomer() throws Exception {
        //given

        //when
        var result = mockMvc.perform(delete("/customers/1"));

        //then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}