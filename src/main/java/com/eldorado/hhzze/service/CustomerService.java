package com.eldorado.hhzze.service;

import com.eldorado.hhzze.data.dto.CustomImcList;
import com.eldorado.hhzze.data.dto.CustomerDto;
import com.eldorado.hhzze.data.model.CustomerImcEntity;
import com.eldorado.hhzze.data.repository.CustomerImcRepository;
import com.eldorado.hhzze.exceptions.CustomerNotFoundException;
import com.eldorado.hhzze.data.model.Customer;
import com.eldorado.hhzze.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerImcRepository customerImcRepository;


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

    public CustomerDto updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException {


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

    public CustomerDto removeCustomer(CustomerDto customerDto) throws CustomerNotFoundException {
        var customerFound= customerRepository.findById(customerDto.getId());

        if(customerFound.isEmpty()) throw new CustomerNotFoundException();

        customerRepository.deleteById(customerFound.get().getId());

        return modelMapper.map(customerFound, CustomerDto.class);
    }


    public CustomerDto findCustomer(UUID customerId) throws CustomerNotFoundException {
        var customerFound= customerRepository.findById(customerId);

        if(customerFound.isEmpty()) throw new CustomerNotFoundException();

        var customerImcs = customerImcRepository.findByClientId(customerId);

        var customerCustom = modelMapper.map(customerImcs, CustomImcList.class);

        var customerDto = modelMapper.map(customerFound, CustomerDto.class);

        customerDto.setImcList(customerCustom);

        customerDto.setHasChanged(verifyChangeImc(customerImcs));


        return customerDto;
    }


    private boolean verifyChangeImc(List<CustomerImcEntity> clientImcs){
        return clientImcs.stream().collect(Collectors.groupingBy(client -> client.getImcEntity().getClassification())).size()>1;
    }

}
