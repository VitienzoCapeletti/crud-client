package com.testedev.teste.resource;

import com.testedev.teste.dto.ClientDTO;
import com.testedev.teste.dto.ClientRequestDTO;
import com.testedev.teste.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients")
@RestController
public class ClientResource {

    @Autowired
    private ClientService service;

    @PostMapping()
    public ClientDTO create(@RequestBody ClientRequestDTO clientRequestDTO) {
        return service.create(clientRequestDTO);
    }

    @GetMapping()
    public List<ClientDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
