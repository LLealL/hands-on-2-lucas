package com.eldorado.hhzze.repository;

import com.eldorado.hhzze.model.ImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImcRepository extends MongoRepository<ImcEntity, UUID> {
}
