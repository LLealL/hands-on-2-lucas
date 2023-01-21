package com.eldorado.hhzze.service;

import com.eldorado.hhzze.data.dto.CustomerImcDto;
import com.eldorado.hhzze.data.model.CustomerImcEntity;
import com.eldorado.hhzze.data.model.ImcEntity;
import com.eldorado.hhzze.data.types.ObesityClassification;
import com.eldorado.hhzze.data.repository.CustomerImcRepository;
import com.eldorado.hhzze.data.repository.ImcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerImcService {

    private final CustomerImcRepository customerImcRepository;

    private final ImcRepository imcRepository;

    private final ModelMapper modelMapper;

    public CustomerImcDto saveImc(CustomerImcDto customerImcDto){
        customerImcDto.setId(UUID.randomUUID());

        var clientImcEntity = modelMapper.map(customerImcDto, CustomerImcEntity.class);

        var bodyMass = calculateBodyMass(customerImcDto);

        clientImcEntity.setImcEntity(calculateImc(bodyMass));

        clientImcEntity.setBodyMass(bodyMass);

        clientImcEntity.setDateOfMeasure(
                Optional.of(customerImcDto.getDateOfMeasure()).orElse(LocalDateTime.now()));

        var clientImcEntitySave = customerImcRepository.save(clientImcEntity);

        log.info("IMC SAVED WITH SUCCESS {}", clientImcEntity);

        customerImcDto.setId(clientImcEntitySave.getId());

        return customerImcDto;
    }


    private ImcEntity calculateImc(Double bodyMass){
        var imcs = imcRepository.findAll();

        return imcs.stream().filter(imcs1 -> imcs1.getBodyMass() > bodyMass).findFirst().orElse(ImcEntity.builder().classification(ObesityClassification.NOT_DEFINED).build());

    }
    private Double calculateBodyMass(CustomerImcDto customerImcDto){
        return customerImcDto.getWeight()/ Math.pow(customerImcDto.getHeight(),2d);
    }
}
