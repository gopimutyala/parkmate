package com.mouritech.parkmate.service;

import com.mouritech.parkmate.dto.ParkerProfileDTO;
import com.mouritech.parkmate.dto.ProductDTO;
import com.mouritech.parkmate.mapper.ParkerProfileMapper;
import com.mouritech.parkmate.repository.ParkerProfileRepository;
import com.mouritech.parkmate.service.impl.ParkerProfileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.UUID;

import static com.mouritech.parkmate.util.ParkmateTestUtil.getParkerProfileEntities;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getParkerProfiles;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getProductEntities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkerProfileServiceTest {

    @InjectMocks
    ParkerProfileServiceImpl parkerProfileServiceImpl;

    @Mock
    ParkerProfileRepository parkerProfileRepository;

    @Spy
    ModelMapper parkmateModelMapper;

    @Spy
    ParkerProfileMapper parkerProfileMapper;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(parkerProfileMapper,"parkmateModelMapper", parkmateModelMapper);
    }

    @Test
    void getAllParkerProfiles() {
       when(parkerProfileRepository.findAll()).thenReturn(getParkerProfileEntities());
        List<ParkerProfileDTO> response = parkerProfileServiceImpl.getAllParkerProfiles();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getAllParkerProfileById() {
        when(parkerProfileRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getParkerProfileEntities().get(0)));
        ParkerProfileDTO response = parkerProfileServiceImpl.getParkerProfile(UUID.randomUUID());
        assertNotNull(response);
    }

    @Test
    void createParkerProfile() {
        when(parkerProfileRepository.save(any())).thenReturn(getParkerProfileEntities().get(0));
        ParkerProfileDTO response = parkerProfileServiceImpl.createParkerProfile(getParkerProfiles().get(0));
        assertNotNull(response);
    }

    @Test
    void updateParkerProfile() {
        when(parkerProfileRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getParkerProfileEntities().get(0)));
        when(parkerProfileRepository.save(any())).thenReturn(getParkerProfileEntities().get(0));
        ParkerProfileDTO response = parkerProfileServiceImpl.updateParkerProfile(getParkerProfiles().get(0));
        assertNotNull(response);
    }

    @Test
    void deleteParkerProfile() {
        doNothing().when(parkerProfileRepository).deleteById(any());
        parkerProfileServiceImpl.deleteParkerProfile(UUID.randomUUID());
    }

    @Test
    void getAllProductsByClientId() {
        when(parkerProfileRepository.findByClientClientId(any())).thenReturn(getParkerProfileEntities());
        List<ParkerProfileDTO> response = parkerProfileServiceImpl.getParkerProfileByClientId(UUID.randomUUID());
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getParkerProfileByOrganizationId() {
        when(parkerProfileRepository.findByOrganizationOrganizationId(any())).thenReturn(getParkerProfileEntities());
        List<ParkerProfileDTO> response = parkerProfileServiceImpl.getParkerProfileByOrganizationId(UUID.randomUUID());
        assertNotNull(response);
        assertEquals(1, response.size());
    }

}