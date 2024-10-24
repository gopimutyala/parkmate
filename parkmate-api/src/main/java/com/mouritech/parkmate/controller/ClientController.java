package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClients();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable UUID id) {
        ClientDTO clientDTO = clientService.getClient(id);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @PutMapping
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
    }
}
