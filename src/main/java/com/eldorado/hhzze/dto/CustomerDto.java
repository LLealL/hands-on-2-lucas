package com.eldorado.hhzze.dto;

import com.eldorado.hhzze.model.types.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {

    private UUID id;

    private String name;

    private Genre genre;

    private Date birthday;

    private Integer monthlyFrequency;

    private String phoneNumber;

    private String Address;
}
