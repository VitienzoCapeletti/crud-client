package com.testedev.teste.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
