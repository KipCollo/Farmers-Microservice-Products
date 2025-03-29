package com.kipcollo.customer.controller;

import com.kipcollo.customer.dto.CustomerRequest;
import com.kipcollo.customer.dto.CustomerResponse;
import com.kipcollo.customer.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    @DisplayName("Getting customer by Id")
    void getCustomerById() throws Exception {

        CustomerResponse customer = new CustomerResponse("1","Collins","Doe","collins@gmail.com","Eldoret");

        when(customerService.getCustomerById("1")).thenReturn(customer);
        mockMvc.perform(get("/api/customer/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value("1"))
                .andExpect(jsonPath("$.firstName").value("Collins"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("collins@gmail.com"))
                .andExpect(jsonPath("$.location").value("Eldoret"));
       // MvcResult mvcResult = mockMvc.perform(get("/api/customer/id"))
    }

    @Test
    void existsById() {
    }

    @Test
    void addCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }
}