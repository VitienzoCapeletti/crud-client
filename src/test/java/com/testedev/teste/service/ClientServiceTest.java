package com.testedev.teste.service;

import com.testedev.teste.dto.ClientDTO;
import com.testedev.teste.dto.ClientRequestDTO;
import com.testedev.teste.model.entity.Client;
import com.testedev.teste.model.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class ClientServiceTest {
    private ClientService service;
    private ClientRepository repository;
    private final String CLIENT_ID = "123";

    @BeforeEach
    public void setup() {
        this.repository = Mockito.mock(ClientRepository.class);
        this.service = new ClientService(repository);
    }

    @Test
    void createClient_WhenSuccessful() {
        var requestDTO = new ClientRequestDTO();
        final var entity = Client.builder().name("name1").id(CLIENT_ID).build();
        Mockito.when(repository.save(Mockito.any(Client.class))).thenReturn(entity);
        final var responseClientId = service.create(requestDTO).getId();
        assertEquals(CLIENT_ID, responseClientId);
    }

    @Test
    void updateClient_WhenSuccessful() {
        final var dto = ClientDTO.builder().name("name1").id(CLIENT_ID).build();
        final var entity = Client.builder().name("name1").id(CLIENT_ID).build();
        Mockito.when(repository.save(Mockito.any(Client.class))).thenReturn(entity);
        Mockito.when(repository.findById(CLIENT_ID)).thenReturn(Optional.of(entity));
        final var responseClientId = service.update(dto).getId();
        assertEquals(CLIENT_ID, responseClientId);
    }

    @Test
    void findAllClient_WhenSuccessful() {
        final var listDTO = List.of(ClientDTO.builder().name("name1").build(), ClientDTO.builder().name("name2").build());
        final var listEntity = List.of(Client.builder().name("name1").build(), Client.builder().name("name2").build());
        Mockito.when(repository.findAll()).thenReturn(listEntity);
        var response = service.findAll();
        assertEquals(listDTO, response);

    }

    @Test
    void findById_WhenSuccessful() {
        final var dto = ClientDTO.builder().name("name1").id(CLIENT_ID).build();
        final var entity = Client.builder().name("name1").id(CLIENT_ID).build();
        Mockito.when(repository.findById(CLIENT_ID)).thenReturn(Optional.of(entity));
        var response = service.findById(CLIENT_ID);
        assertEquals(dto, response);
    }

    @Test
    void delete_WhenSuccessful() {
        final var entity = Client.builder().name("name1").id(CLIENT_ID).build();
        Mockito.when(repository.findById(CLIENT_ID)).thenReturn(Optional.of(entity));
        service.delete(CLIENT_ID);
    }
}