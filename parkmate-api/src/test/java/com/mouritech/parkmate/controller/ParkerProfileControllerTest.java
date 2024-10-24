package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ParkerProfileDTO;
import com.mouritech.parkmate.service.ParkerProfileService;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getParkerProfiles;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ParkerProfileControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    ParkerProfileController parkerProfileController;

    @Mock
    ParkerProfileService parkerProfileService;

    private final String BASE_INDUSTRY_URL="/api/parkerprofile";

    @BeforeEach
    void setup() {
        this.mockMvc= MockMvcBuilders.standaloneSetup(parkerProfileController).build();
    }

    @Test
    void getAllParkerProfiles() throws Exception {
        when(parkerProfileService.getAllParkerProfiles())
                .thenReturn(getParkerProfiles());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/getAll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    void getParkerProfile() throws Exception {
        when(parkerProfileService.getParkerProfile(any()))
                .thenReturn(getParkerProfiles().get(0));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getParkerProfileByClientId() throws Exception {
        when(parkerProfileService.getParkerProfileByClientId(any()))
                .thenReturn(getParkerProfiles());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/client/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getParkerProfileByOrganizationId() throws Exception {
        when(parkerProfileService.getParkerProfileByOrganizationId(any()))
                .thenReturn(getParkerProfiles());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/organization/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void createParkerProfile() throws Exception {
        when(parkerProfileService.createParkerProfile(any(ParkerProfileDTO.class)))
                .thenReturn(getParkerProfiles().get(0));

        mockMvc.perform(MockMvcRequestBuilders.post(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getParkerProfiles().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateParkerProfile() throws Exception {
        when(parkerProfileService.updateParkerProfile(any(ParkerProfileDTO.class)))
                .thenReturn(getParkerProfiles().get(0));

        mockMvc.perform(MockMvcRequestBuilders.put(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getParkerProfiles().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteParkerProfile() throws Exception {
        doNothing().when(parkerProfileService).deleteParkerProfile(any());

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}