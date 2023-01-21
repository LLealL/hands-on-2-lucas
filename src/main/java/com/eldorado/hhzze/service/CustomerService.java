package com.eldorado.hhzze.service;

import com.eldorado.hhzze.dto.CustomerDto;
import com.eldorado.hhzze.exceptions.CustomerNotFoundException;
import com.eldorado.hhzze.model.Customer;
import com.eldorado.hhzze.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<CustomerDto> getCustomerList() {

        var customerDtoList = new ArrayList<CustomerDto>();
        var customerList = customerRepository.findAll();

        customerList.forEach(customer ->
            customerDtoList.add(modelMapper.map(customer, CustomerDto.class))
        );

        return customerDtoList;
    }
    @SneakyThrows
    public CustomerDto updateCustomer(CustomerDto customerDto) {


        var customerFound= customerRepository.findById(customerDto.getId());

        if(customerFound.isEmpty()) throw new CustomerNotFoundException();


        customerFound.get().setName(customerDto.getName());
        customerFound.get().setBirthday(customerDto.getBirthday());
        customerFound.get().setAddress(customerDto.getAddress());
        customerFound.get().setPhoneNumber(customerDto.getPhoneNumber());
        customerFound.get().setGenre(customerDto.getGenre());
        customerFound.get().setMonthlyFrequency(customerDto.getMonthlyFrequency());


        var customerSave = customerRepository.save(customerFound.get());

        var customer = modelMapper.map(customerSave, CustomerDto.class);
        log.info("Customer SAVED WITH SUCCESS {}", customer);

        return customer;

    }
    @SneakyThrows
    public CustomerDto removeCustomer(CustomerDto customerDto){
        var customerFound= customerRepository.findById(customerDto.getId());

        if(customerFound.isEmpty()) throw new CustomerNotFoundException();

        customerRepository.deleteById(customerFound.get().getId());

        return modelMapper.map(customerFound, CustomerDto.class);
    }

    @SneakyThrows
    public CustomerDto findCustomer(UUID customerId) {
        var customerFound= customerRepository.findById(customerId);

        if(customerFound.isEmpty()) throw new CustomerNotFoundException();

        return modelMapper.map(customerFound, CustomerDto.class);
    }
}
