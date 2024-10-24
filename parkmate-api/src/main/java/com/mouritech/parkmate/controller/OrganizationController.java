package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.service.OrganizationService;
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
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/getAll")
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<OrganizationDTO> organizations = organizationService.getAllOrganizations();

        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable UUID id) {
        OrganizationDTO organizationDTO = organizationService.getOrganization(id);

        return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<OrganizationDTO>> getOrganizationByClientId(@PathVariable UUID id) {
        List<OrganizationDTO> organizations = organizationService.getOrganizationByClientId(id);

        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @PostMapping
    public OrganizationDTO createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return organizationService.createOrganization(organizationDTO);
    }

    @PutMapping
    public OrganizationDTO updateOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return organizationService.updateOrganization(organizationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable UUID id) {
        organizationService.deleteOrganization(id);
    }
}
