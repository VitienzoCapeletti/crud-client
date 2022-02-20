package com.testedev.teste.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Client")
public class Client {
    @Id
    private String id;
    private String name;
    private int age;
    private String address;
    private String city;
    private String state;
    private String cpf;

}
