package com.eldorado.hhzze.controller;

import com.eldorado.hhzze.dto.CustomerDto;
import com.eldorado.hhzze.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        log.info("Customer Base {}",customerDto);
        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }

    @GetMapping
    public void getCustomerList(){

    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable UUID customerId){

    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable UUID customerId){

    }

    @GetMapping("/{customerId}")
    public void getCustomer(@PathVariable UUID customerId){

    }
}
