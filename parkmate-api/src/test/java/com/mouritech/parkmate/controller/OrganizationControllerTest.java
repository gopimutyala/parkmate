package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.service.OrganizationService;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getOrganizations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OrganizationControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    OrganizationController organizationController;

    @Mock
    OrganizationService organizationService;

    private final String BASE_INDUSTRY_URL="/api/organization";

    @BeforeEach
    void setup() {
        this.mockMvc= MockMvcBuilders.standaloneSetup(organizationController).build();
    }

    @Test
    void getAllOrganizations() throws Exception {
        when(organizationService.getAllOrganizations())
                .thenReturn(getOrganizations());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/getAll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    void getOrganization() throws Exception {
        when(organizationService.getOrganization(any()))
                .thenReturn(getOrganizations().get(0));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getOrganizationByClientId() throws Exception {
        when(organizationService.getOrganizationByClientId(any()))
                .thenReturn(getOrganizations());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/client/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void createOrganization() throws Exception {
        when(organizationService.createOrganization(any(OrganizationDTO.class)))
                .thenReturn(getOrganizations().get(0));

        mockMvc.perform(MockMvcRequestBuilders.post(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getOrganizations().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateOrganization() throws Exception {
        when(organizationService.updateOrganization(any(OrganizationDTO.class)))
                .thenReturn(getOrganizations().get(0));

        mockMvc.perform(MockMvcRequestBuilders.put(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getOrganizations().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteOrganization() throws Exception {
        doNothing().when(organizationService).deleteOrganization(any());

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}