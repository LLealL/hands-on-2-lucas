package com.eldorado.hhzze.data.repository;

import com.eldorado.hhzze.data.model.CustomerImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerImcRepository extends MongoRepository<CustomerImcEntity, UUID> {

    List<CustomerImcEntity> findByClientId(UUID clientId);

}
