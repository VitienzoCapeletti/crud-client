package com.testedev.teste.service;

import com.testedev.teste.dto.ClientDTO;
import com.testedev.teste.dto.ClientRequestDTO;
import com.testedev.teste.model.entity.Client;
import com.testedev.teste.model.repository.ClientRepository;
import com.testedev.teste.util.mapper.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(ClientMapper.class);
    }

    public ClientDTO create(final ClientRequestDTO requestDTO) {
        final var client = mapper.buildClientEntity(requestDTO);
        return saveClient(client);
    }

    public ClientDTO update(ClientDTO clientDTO) {
        final var client = findEntityById(clientDTO.getId());
        return saveClient(client);
    }

    public List<ClientDTO> findAll() {
        return repository.findAll().stream()
                .map(s -> mapper.buildClientDTO(s))
                .collect(Collectors.toList());
    }

    public ClientDTO findById(final String clientId) {
        return repository.findById(clientId)
                .map(s -> mapper.buildClientDTO(s))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Client not found"));
    }

    public void delete(final String clientId) {
        final var client = findEntityById(clientId);
        repository.delete(client);
    }

    private Client findEntityById(final String clientId) {
        return repository.findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Client not found"));
    }

    private ClientDTO saveClient(Client client) {
        final var savedClient = repository.save(client);
        return mapper.buildClientDTO(savedClient);
    }
}
