package com.latencia.latencia.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.latencia.latencia.models.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente,String> {
    
}
