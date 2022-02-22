package com.testedev.teste.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private String id;
    private String name;
    private int age;
    private String address;
    private String city;
    private String state;
    private String cpf;
}
