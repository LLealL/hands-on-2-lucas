package com.eldorado.hhzze.data.dto;

import com.eldorado.hhzze.data.types.ObesityClassification;
import com.eldorado.hhzze.data.types.ObesityLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ImcDto {


    private UUID id;

    private float bodyMass;

    private ObesityClassification classification;

    private ObesityLevel obesityLevel;

    private LocalDateTime createdAt;

}
