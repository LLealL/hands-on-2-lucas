package com.eldorado.hhzze.controller;

import com.eldorado.hhzze.dto.ImcDto;
import com.eldorado.hhzze.service.ImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/imc-calculator")
@Slf4j
@RequiredArgsConstructor
public class imcController {


    private final ImcService imcService;

    @PostMapping
    public ResponseEntity<ImcDto> saveImc(@RequestBody ImcDto imcDto) {
        log.info("IMC Base {} ", imcDto);
        return ResponseEntity.ok(imcService.saveImc(imcDto));
    }

    @GetMapping
    public void getImcList() {
        log.warn("GET IMC Not IMPLEMENTED");
    }

    @PutMapping("/{imcId}")
    public void updateImc(@PathVariable UUID imcId) {
        log.warn("PUT IMC Not IMPLEMENTED {}", imcId);
    }

    @DeleteMapping("/{imcId}")
    public void deleteImc(@PathVariable UUID imcId) {
        log.warn("DELETE IMC Not IMPLEMENTED {}", imcId);
    }

    @GetMapping("/{imcId}")
    public void getImc(@PathVariable UUID imcId) {
        log.warn("GET IMC BY ID Not IMPLEMENTED {}", imcId);
    }

}
