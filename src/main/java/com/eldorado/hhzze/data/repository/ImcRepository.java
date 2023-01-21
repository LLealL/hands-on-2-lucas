package com.eldorado.hhzze.data.repository;

import com.eldorado.hhzze.data.model.ImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImcRepository extends MongoRepository<ImcEntity, UUID> {
}
