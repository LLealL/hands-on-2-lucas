package com.eldorado.hhzze.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerImcDto {
    @Id
    private UUID id;
    private UUID clientId;
    private double height;
    private double weight;
    private LocalDateTime dateOfMeasure;

}
