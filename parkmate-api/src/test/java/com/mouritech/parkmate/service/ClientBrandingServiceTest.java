package com.mouritech.parkmate.service;

import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.mapper.ClientBrandingMapper;
import com.mouritech.parkmate.repository.ClientBrandingRepository;
import com.mouritech.parkmate.service.impl.ClientBrandingServiceImpl;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientBrandingEntities;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientBrandings;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientBrandingServiceTest {

    @InjectMocks
    ClientBrandingServiceImpl clientBrandingServiceImpl;

    @Mock
    ClientBrandingRepository clientBrandingRepository;

    @Spy
    ModelMapper parkmateModelMapper;

    @Spy
    ClientBrandingMapper clientBrandingMapper;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(clientBrandingMapper,"parkmateModelMapper", parkmateModelMapper);
    }

    @Test
    void getAllClientBrandings() {
       when(clientBrandingRepository.findAll()).thenReturn(getClientBrandingEntities());
        List<ClientBrandingDTO> response = clientBrandingServiceImpl.getAllClientBrandings();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getAllClientBrandingById() {
        when(clientBrandingRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getClientBrandingEntities().get(0)));
        ClientBrandingDTO response = clientBrandingServiceImpl.getClientBranding(UUID.randomUUID());
        assertNotNull(response);
    }

    @Test
    void getAllClientBrandingByClientId() {
        when(clientBrandingRepository.findByClientClientId(any())).thenReturn(getClientBrandingEntities());
        List<ClientBrandingDTO> response = clientBrandingServiceImpl.getClientBrandingByClientId(UUID.randomUUID());
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void createClientBranding() {
        when(clientBrandingRepository.save(any())).thenReturn(getClientBrandingEntities().get(0));
        ClientBrandingDTO response = clientBrandingServiceImpl.createClientBranding(getClientBrandings().get(0));
        assertNotNull(response);
    }

    @Test
    void updateClientBranding() {
        when(clientBrandingRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getClientBrandingEntities().get(0)));
        when(clientBrandingRepository.save(any())).thenReturn(getClientBrandingEntities().get(0));
        ClientBrandingDTO response = clientBrandingServiceImpl.updateClientBranding(getClientBrandings().get(0));
        assertNotNull(response);
    }

    @Test
    void deleteClientBranding() {
        doNothing().when(clientBrandingRepository).deleteById(any());
        clientBrandingServiceImpl.deleteClientBranding(UUID.randomUUID());
    }

}