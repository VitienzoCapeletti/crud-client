package com.testedev.teste.util.mapper;

import com.testedev.teste.dto.ClientDTO;
import com.testedev.teste.dto.ClientRequestDTO;
import com.testedev.teste.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper()
public interface ClientMapper {
    Client buildClientEntity(ClientRequestDTO client);

    Client buildClientEntity(ClientDTO client);

    ClientDTO buildClientDTO(Client client);
}
