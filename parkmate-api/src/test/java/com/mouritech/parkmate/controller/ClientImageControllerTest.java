package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.service.ClientImageService;
import com.mouritech.parkmate.util.ParkmateTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientImages;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClientImageControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    ClientImageController clientImageController;

    @Mock
    ClientImageService clientImageService;

    private final String BASE_INDUSTRY_URL="/api/clientimage";

    @BeforeEach
    void setup() {
        this.mockMvc= MockMvcBuilders.standaloneSetup(clientImageController).build();
    }

    @Test
    void getAllClientImages() throws Exception {
        when(clientImageService.getAllClientImages())
                .thenReturn(getClientImages());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/getAll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    void getClientImage() throws Exception {
        when(clientImageService.getClientImage(any()))
                .thenReturn(getClientImages().get(0));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getClientImageByClientId() throws Exception {
        when(clientImageService.getClientImageByClientId(any()))
                .thenReturn(getClientImages());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/client/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void createClientImage() throws Exception {
        when(clientImageService.createClientImage(any(ClientImageDTO.class)))
                .thenReturn(getClientImages().get(0));

        mockMvc.perform(MockMvcRequestBuilders.post(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getClientImages().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateClientImage() throws Exception {
        when(clientImageService.updateClientImage(any(ClientImageDTO.class)))
                .thenReturn(getClientImages().get(0));

        mockMvc.perform(MockMvcRequestBuilders.put(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getClientImages().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteClientImage() throws Exception {
        doNothing().when(clientImageService).deleteClientImage(any());

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}