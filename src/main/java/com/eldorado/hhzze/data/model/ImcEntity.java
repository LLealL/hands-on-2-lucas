package com.eldorado.hhzze.data.model;

import com.eldorado.hhzze.data.types.ObesityClassification;
import com.eldorado.hhzze.data.types.ObesityLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("imc-calculator")
public class ImcEntity {

    @Id
    private UUID id;

    private float bodyMass;

    private ObesityClassification classification;

    private ObesityLevel obesityLevel;


}
