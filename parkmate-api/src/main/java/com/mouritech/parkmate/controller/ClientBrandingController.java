package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.service.ClientBrandingService;
import com.mouritech.parkmate.service.ClientService;
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
@RequestMapping("/api/clientbranding")
public class ClientBrandingController {

    @Autowired
    private ClientBrandingService clientBrandingService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientBrandingDTO>> getAllClientBrandings() {
        List<ClientBrandingDTO> clientBrandings = clientBrandingService.getAllClientBrandings();

        return new ResponseEntity<>(clientBrandings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientBrandingDTO> getClientBranding(@PathVariable UUID id) {
        ClientBrandingDTO clientBrandingDTO = clientBrandingService.getClientBranding(id);

        return new ResponseEntity<>(clientBrandingDTO, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ClientBrandingDTO>> getClientBrandingByClientId(@PathVariable UUID id) {
        List<ClientBrandingDTO> clientBrandings = clientBrandingService.getClientBrandingByClientId(id);

        return new ResponseEntity<>(clientBrandings, HttpStatus.OK);
    }

    @PostMapping
    public ClientBrandingDTO createClientBranding(@RequestBody ClientBrandingDTO clientBrandingDTO) {
        return clientBrandingService.createClientBranding(clientBrandingDTO);
    }

    @PutMapping
    public ClientBrandingDTO updateClientBranding(@RequestBody ClientBrandingDTO clientBrandingDTO) {
        return clientBrandingService.updateClientBranding(clientBrandingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClientBranding(@PathVariable UUID id) {
        clientBrandingService.deleteClientBranding(id);
    }
}
