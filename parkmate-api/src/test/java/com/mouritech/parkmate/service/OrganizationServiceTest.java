package com.mouritech.parkmate.service;

import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.mapper.OrganizationMapper;
import com.mouritech.parkmate.repository.OrganizationRepository;
import com.mouritech.parkmate.service.impl.OrganizationServiceImpl;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getOrganizationEntities;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getOrganizations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceTest {

    @InjectMocks
    OrganizationServiceImpl organizationServiceImpl;

    @Mock
    OrganizationRepository organizationRepository;

    @Spy
    ModelMapper parkmateModelMapper;

    @Spy
    OrganizationMapper organizationMapper;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(organizationMapper,"parkmateModelMapper", parkmateModelMapper);
    }

    @Test
    void getAllOrganizations() {
       when(organizationRepository.findAll()).thenReturn(getOrganizationEntities());
        List<OrganizationDTO> response = organizationServiceImpl.getAllOrganizations();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getOrganizationById() {
        when(organizationRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getOrganizationEntities().get(0)));
        OrganizationDTO response = organizationServiceImpl.getOrganization(UUID.randomUUID());
        assertNotNull(response);
    }

    @Test
    void getAllOrganizationByClientId() {
        when(organizationRepository.findByClientClientId(any())).thenReturn(getOrganizationEntities());
        List<OrganizationDTO> response = organizationServiceImpl.getOrganizationByClientId(UUID.randomUUID());
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void createOrganization() {
        when(organizationRepository.save(any())).thenReturn(getOrganizationEntities().get(0));
        OrganizationDTO response = organizationServiceImpl.createOrganization(getOrganizations().get(0));
        assertNotNull(response);
    }

    @Test
    void updateOrganization() {
        when(organizationRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getOrganizationEntities().get(0)));
        when(organizationRepository.save(any())).thenReturn(getOrganizationEntities().get(0));
        OrganizationDTO response = organizationServiceImpl.updateOrganization(getOrganizations().get(0));
        assertNotNull(response);
    }

    @Test
    void deleteOrganization() {
        doNothing().when(organizationRepository).deleteById(any());
        organizationServiceImpl.deleteOrganization(UUID.randomUUID());
    }

}