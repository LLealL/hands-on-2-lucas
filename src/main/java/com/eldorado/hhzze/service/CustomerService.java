package com.eldorado.hhzze.service;

import com.eldorado.hhzze.dto.CustomerDto;
import com.eldorado.hhzze.model.Customer;
import com.eldorado.hhzze.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;
    public CustomerDto saveCustomer(CustomerDto customerDto){

         var customer = modelMapper.map(customerDto, Customer.class);

        log.info("List -> {}", customer);
        customer.setId(UUID.randomUUID());


        var customerSave = customerRepository.save(customer);

        log.info("Customer SAVED WITH SUCCESS {}", customerSave);


        return customerDto;

    }

}
