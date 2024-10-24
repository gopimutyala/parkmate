package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.service.ClientImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientimage")
public class ClientImageController {

    @Autowired
    private ClientImageService clientImageService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientImageDTO>> getAllClientImages() {
        List<ClientImageDTO> clientImages = clientImageService.getAllClientImages();

        return new ResponseEntity<>(clientImages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientImageDTO> getClientImage(@PathVariable UUID id) {
        ClientImageDTO clientImageDTO = clientImageService.getClientImage(id);

        return new ResponseEntity<>(clientImageDTO, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ClientImageDTO>> getClientImageByClientId(@PathVariable UUID id) {
        List<ClientImageDTO> clientImages = clientImageService.getClientImageByClientId(id);

        return new ResponseEntity<>(clientImages, HttpStatus.OK);
    }

    @PostMapping
    public ClientImageDTO createClientImage(@RequestBody ClientImageDTO clientImageDTO) {
        return clientImageService.createClientImage(clientImageDTO);
    }

    @PutMapping
    public ClientImageDTO updateClientImage(@RequestBody ClientImageDTO clientImageDTO) {
        return clientImageService.updateClientImage(clientImageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClientImage(@PathVariable UUID id) {
        clientImageService.deleteClientImage(id);
    }
}
