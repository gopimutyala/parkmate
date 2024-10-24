package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.service.ClientBrandingService;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getClientBrandings;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClientBrandingControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    ClientBrandingController clientBrandingController;

    @Mock
    ClientBrandingService clientBrandingService;

    private final String BASE_INDUSTRY_URL="/api/clientbranding";

    @BeforeEach
    void setup() {
        this.mockMvc= MockMvcBuilders.standaloneSetup(clientBrandingController).build();
    }

    @Test
    void getAllClientBrandings() throws Exception {
        when(clientBrandingService.getAllClientBrandings())
                .thenReturn(getClientBrandings());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/getAll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    void getClientBranding() throws Exception {
        when(clientBrandingService.getClientBranding(any()))
                .thenReturn(getClientBrandings().get(0));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getClientBrandingByClientId() throws Exception {
        when(clientBrandingService.getClientBrandingByClientId(any()))
                .thenReturn(getClientBrandings());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/client/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void createClientBranding() throws Exception {
        when(clientBrandingService.createClientBranding(any(ClientBrandingDTO.class)))
                .thenReturn(getClientBrandings().get(0));

        mockMvc.perform(MockMvcRequestBuilders.post(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getClientBrandings().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateClientBranding() throws Exception {
        when(clientBrandingService.updateClientBranding(any(ClientBrandingDTO.class)))
                .thenReturn(getClientBrandings().get(0));

        mockMvc.perform(MockMvcRequestBuilders.put(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getClientBrandings().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteClientBranding() throws Exception {
        doNothing().when(clientBrandingService).deleteClientBranding(any());

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}