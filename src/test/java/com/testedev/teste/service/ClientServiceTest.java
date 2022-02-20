package com.testedev.teste.service;

import com.testedev.teste.model.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ClientServiceTest {
    private ClientService service;
    private ClientRepository repository;
    private final Long CLIENT_ID = 123L;

    @BeforeEach
    public void setup() {
        this.repository = Mockito.mock(ClientRepository.class);
        this.service = new ClientService(repository);
    }

//    @Test
//    void updateClient_WhenSuccessful() {
//        final var clientSaved = service.(CLIENT_ID);
//
//    }
//
//    @Test
//    void getClient_WhenSuccessful() {
//        final var clientSaved = service.(CLIENT_ID);
//
//    }
//    @Test
//    void findAllClient_WhenSuccessful() {
//        final var clientSaved = service.(CLIENT_ID);
//
//    }
//    @Test
//    void createClient_WhenSuccessful() {
//        final var clientSaved = service.(CLIENT_ID);
//
//    }

}