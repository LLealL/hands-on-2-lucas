package com.eldorado.hhzze.repository;

import com.eldorado.hhzze.model.ImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ImcRepository extends MongoRepository<ImcEntity, UUID> {
}
