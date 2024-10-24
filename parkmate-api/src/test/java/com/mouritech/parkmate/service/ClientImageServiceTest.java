package com.mouritech.parkmate.service;

import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.mapper.ClientImageMapper;
import com.mouritech.parkmate.repository.ClientImageRepository;
import com.mouritech.parkmate.service.impl.ClientImageServiceImpl;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientImageEntities;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientImages;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientImageServiceTest {

    @InjectMocks
    ClientImageServiceImpl clientImageServiceImpl;

    @Mock
    ClientImageRepository clientImageRepository;

    @Spy
    ModelMapper parkmateModelMapper;

    @Spy
    ClientImageMapper clientImageMapper;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(clientImageMapper,"parkmateModelMapper", parkmateModelMapper);
    }

    @Test
    void getAllClientImages() {
       when(clientImageRepository.findAll()).thenReturn(getClientImageEntities());
        List<ClientImageDTO> response = clientImageServiceImpl.getAllClientImages();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getAllClientImageById() {
        when(clientImageRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getClientImageEntities().get(0)));
        ClientImageDTO response = clientImageServiceImpl.getClientImage(UUID.randomUUID());
        assertNotNull(response);
    }

    @Test
    void getAllClientImageByClientId() {
        when(clientImageRepository.findByClientClientId(any())).thenReturn(getClientImageEntities());
        List<ClientImageDTO> response = clientImageServiceImpl.getClientImageByClientId(UUID.randomUUID());
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void createClientImage() {
        when(clientImageRepository.save(any())).thenReturn(getClientImageEntities().get(0));
        ClientImageDTO response = clientImageServiceImpl.createClientImage(getClientImages().get(0));
        assertNotNull(response);
    }

    @Test
    void updateClientImage() {
        when(clientImageRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getClientImageEntities().get(0)));
        when(clientImageRepository.save(any())).thenReturn(getClientImageEntities().get(0));
        ClientImageDTO response = clientImageServiceImpl.updateClientImage(getClientImages().get(0));
        assertNotNull(response);
    }

    @Test
    void deleteClientImage() {
        doNothing().when(clientImageRepository).deleteById(any());
        clientImageServiceImpl.deleteClientImage(UUID.randomUUID());
    }

}