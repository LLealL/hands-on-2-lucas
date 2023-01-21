package com.eldorado.hhzze.repository;

import com.eldorado.hhzze.model.CustomerImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerImcRepository extends MongoRepository<CustomerImcEntity, UUID> {

    List<CustomerImcEntity> findByClientId(UUID clientId);

}
