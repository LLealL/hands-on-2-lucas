package com.eldorado.hhzze.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ImcDto {

    private UUID id;

    private float bodyMass;

    private  String classification;

    private String obesityLevel;

    private LocalDateTime createdAt;

}
