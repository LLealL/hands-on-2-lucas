package com.eldorado.hhzze.controller;

import com.eldorado.hhzze.dto.CustomerDto;
import com.eldorado.hhzze.exceptions.CustomerNotFoundException;
import com.eldorado.hhzze.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<CustomerDto>> getCustomerList(){
        log.info("Requesting Customer List...");
        return ResponseEntity.ok(customerService.getCustomerList());
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){
        log.info("Updating Customer {}",customerDto.getId());
        return ResponseEntity.ok(customerService.updateCustomer(customerDto));
    }

    @DeleteMapping
    public ResponseEntity<CustomerDto> deleteCustomer(@RequestBody CustomerDto customerDto){
        log.info("Deleting Customer {}", customerDto);
        return ResponseEntity.ok(customerService.removeCustomer(customerDto));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        log.info("Requesting Customer {}", customerId);
        return ResponseEntity.ok(customerService.findCustomer(customerId));
    }
}
