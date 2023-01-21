package com.eldorado.hhzze.model;

import com.eldorado.hhzze.model.types.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("customer")
public class Customer {

    @Id
    private UUID id;
    private String name;

    private Genre genre;

    private Date birthday;

    private Integer monthlyFrequency;

    private String phoneNumber;

    private String Address;
}

