package com.eldorado.hhzze.controller;

import com.eldorado.hhzze.dto.ImcDto;
import com.eldorado.hhzze.service.ImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<ImcDto>> getImcList() {
        log.info("Requesting Imc List...");
        return ResponseEntity.ok(imcService.getImcList());
    }

    @PutMapping
    public ResponseEntity<ImcDto> updateImc(@RequestBody ImcDto imcDto) {
        log.info("Updating Imc {}",imcDto.getId());
        return ResponseEntity.ok(imcService.updateImc(imcDto));
    }

    @DeleteMapping
    public ResponseEntity<ImcDto> deleteImc(@RequestBody ImcDto imcDto) {
        log.info("Deleting Imc {}",imcDto.getId());
        return ResponseEntity.ok(imcService.removeImc(imcDto));
    }

    @GetMapping("/{imcId}")
    public ResponseEntity<ImcDto> getImc(@PathVariable UUID imcId) {
        log.info("Requesting Imc {}",imcId);
        return ResponseEntity.ok(imcService.findImc(imcId));

    }

}
