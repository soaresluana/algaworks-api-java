package com.javacrmapi.controller;

import com.javacrmapi.model.Cliente;
import com.javacrmapi.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClientRepository clientRepository;

    public ClienteController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping()
    public List<Cliente>listar() {
        return clientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clientRepository.save(cliente);
    }
}
