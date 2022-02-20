package com.testedev.teste.model.repository;

import com.testedev.teste.model.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
