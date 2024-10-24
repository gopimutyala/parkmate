package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ParkerProfileDTO;
import com.mouritech.parkmate.service.ParkerProfileService;
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
@RequestMapping("/api/parkerprofile")
public class ParkerProfileController {

    @Autowired
    private ParkerProfileService parkerProfileService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ParkerProfileDTO>> getAllParkerProfiles() {
        List<ParkerProfileDTO> parkerProfiles = parkerProfileService.getAllParkerProfiles();

        return new ResponseEntity<>(parkerProfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkerProfileDTO> getParkerProfile(@PathVariable UUID id) {
        ParkerProfileDTO parkerProfileDTO = parkerProfileService.getParkerProfile(id);

        return new ResponseEntity<>(parkerProfileDTO, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ParkerProfileDTO>> getParkerProfileByClientId(@PathVariable UUID id) {
        List<ParkerProfileDTO> parkerProfiles = parkerProfileService.getParkerProfileByClientId(id);

        return new ResponseEntity<>(parkerProfiles, HttpStatus.OK);
    }

    @GetMapping("/organization/{id}")
    public ResponseEntity<List<ParkerProfileDTO>> getParkerProfileByOrganizationtId(@PathVariable UUID id) {
        List<ParkerProfileDTO> parkerProfiles = parkerProfileService.getParkerProfileByOrganizationId(id);

        return new ResponseEntity<>(parkerProfiles, HttpStatus.OK);
    }

    @PostMapping
    public ParkerProfileDTO createParkerProfile(@RequestBody ParkerProfileDTO parkerProfileDTO) {
        return parkerProfileService.createParkerProfile(parkerProfileDTO);
    }

    @PutMapping
    public ParkerProfileDTO updateParkerProfile(@RequestBody ParkerProfileDTO parkerProfileDTO) {
        return parkerProfileService.updateParkerProfile(parkerProfileDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteParkerProfile(@PathVariable UUID id) {
        parkerProfileService.deleteParkerProfile(id);
    }
}
