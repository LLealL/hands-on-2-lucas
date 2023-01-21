package com.eldorado.hhzze.service;


import com.eldorado.hhzze.dto.ImcDto;
import com.eldorado.hhzze.model.ImcEntity;
import com.eldorado.hhzze.repository.ImcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImcService {

    private final ImcRepository imcRepository;

    private final ModelMapper modelMapper;

    public ImcDto imcDto;

    public ImcDto saveImc(ImcDto imcDto){

        var imcEntity = modelMapper.map(imcDto, ImcEntity.class);

        log.info("List -> {}", imcEntity);
        imcEntity.setId(UUID.randomUUID());

        var imcEntitySave = imcRepository.save(imcEntity);

        log.info("IMC SAVED WITH SUCESS {}", imcEntitySave);
        imcDto.setId(imcEntitySave.getId());
        imcDto.setCreatedAt(LocalDateTime.now());

        return imcDto;
    }

}
