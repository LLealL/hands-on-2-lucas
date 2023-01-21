package com.eldorado.hhzze.controller;

import com.eldorado.hhzze.dto.CustomerImcDto;
import com.eldorado.hhzze.service.CustomerImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-imc")
@Slf4j
@RequiredArgsConstructor
public class CustomerImcController {

    private final CustomerImcService customerImcService;

    @PostMapping
    public ResponseEntity<CustomerImcDto> saveImc(@RequestBody CustomerImcDto clientImcDto) {
        log.info("Received Client IMC {} ", clientImcDto);
        return ResponseEntity.ok(customerImcService.saveImc(clientImcDto));
    }
}
