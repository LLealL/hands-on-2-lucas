package com.eldorado.hhzze.service;



import com.eldorado.hhzze.data.dto.ImcDto;

import com.eldorado.hhzze.exceptions.IMCNotFoundException;
import com.eldorado.hhzze.data.model.ImcEntity;
import com.eldorado.hhzze.data.repository.ImcRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImcService {

    private final ImcRepository imcRepository;

    private final ModelMapper modelMapper;


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

    public List<ImcDto> getImcList() {

        var imcDtoList = new ArrayList<ImcDto>();
        var imcList = imcRepository.findAll();

        imcList.forEach(imc ->
                imcDtoList.add(modelMapper.map(imc, ImcDto.class))
        );

        return imcDtoList;
    }


    public ImcDto updateImc(ImcDto imcDto) throws IMCNotFoundException {
        var imcFound= imcRepository.findById(imcDto.getId());

        if(imcFound.isEmpty()) throw new IMCNotFoundException();


        var imcSave = imcRepository.save(imcFound.get());


        var imc = modelMapper.map(imcSave, ImcDto.class);
        log.info("IMC SAVED WITH SUCCESS {}", imc);

        return imc;

    }



    public ImcDto removeImc(ImcDto imcDto) throws IMCNotFoundException {
        var imcFound= imcRepository.findById(imcDto.getId());

        if(imcFound.isEmpty()) throw new IMCNotFoundException();

        imcRepository.deleteById(imcFound.get().getId());

        return modelMapper.map(imcFound, ImcDto.class);

    }



    public ImcDto findImc(UUID imcId) throws IMCNotFoundException {
        var imcFound= imcRepository.findById(imcId);

        if(imcFound.isEmpty()) throw new IMCNotFoundException();

        return modelMapper.map(imcFound, ImcDto.class);
    }
}
