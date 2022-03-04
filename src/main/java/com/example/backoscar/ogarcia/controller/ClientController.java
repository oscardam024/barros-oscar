package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Client;
import com.example.backoscar.ogarcia.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController()
public class ClientController {
    @Autowired
    private ClientService clientService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/clientes")
    public ResponseEntity<List<Client>> listaClientes() {
        logger.info("inicio listaClientes");
        List<Client> clientes = null;

        clientes = clientService.findAll();
        logger.info("fin listaClientes");
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @PostMapping(path="/clientes")
    public ResponseEntity<Client> addCliente(@RequestBody Client client) {
        Client clienteanadido = clientService.save(client);
        return new ResponseEntity<>(clienteanadido, HttpStatus.OK);
    }
}
