package com.mouritech.parkmate.service;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.mapper.ClientBrandingMapper;
import com.mouritech.parkmate.mapper.ClientImageMapper;
import com.mouritech.parkmate.mapper.ClientMapper;
import com.mouritech.parkmate.repository.ClientRepository;
import com.mouritech.parkmate.service.impl.ClientServiceImpl;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientEntities;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getClients;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @Mock
    ClientRepository clientRepository;

    @Spy
    ModelMapper parkmateModelMapper;

    @Spy
    ClientMapper clientMapper;

    @Spy
    ClientBrandingMapper clientBrandingMapper;

    @Spy
    ClientImageMapper clientImageMapper;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(clientMapper,"parkmateModelMapper", parkmateModelMapper);
        ReflectionTestUtils.setField(clientBrandingMapper,"parkmateModelMapper", parkmateModelMapper);
        ReflectionTestUtils.setField(clientImageMapper,"parkmateModelMapper", parkmateModelMapper);
    }

    @Test
    void getAllClients() {
       when(clientRepository.findAll()).thenReturn(getClientEntities());
        List<ClientDTO> response = clientServiceImpl.getAllClients();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getAllClientById() {
        when(clientRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getClientEntities().get(0)));
        ClientDTO response = clientServiceImpl.getClient(UUID.randomUUID());
        assertNotNull(response);
    }

    @Test
    void createClient() {
        when(clientRepository.save(any())).thenReturn(getClientEntities().get(0));
        ClientDTO response = clientServiceImpl.createClient(getClients().get(0));
        assertNotNull(response);
    }

    @Test
    void updateClient() {
        when(clientRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getClientEntities().get(0)));
        when(clientRepository.save(any())).thenReturn(getClientEntities().get(0));
        ClientDTO response = clientServiceImpl.updateClient(getClients().get(0));
        assertNotNull(response);
    }

    @Test
    void deleteClient() {
        doNothing().when(clientRepository).deleteById(any());
        clientServiceImpl.deleteClient(UUID.randomUUID());
    }

}