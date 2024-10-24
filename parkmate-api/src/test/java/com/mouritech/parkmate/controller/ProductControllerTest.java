package com.mouritech.parkmate.controller;

import com.mouritech.parkmate.dto.ProductDTO;
import com.mouritech.parkmate.service.ProductService;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getProducts;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    private final String BASE_INDUSTRY_URL="/api/product";

    @BeforeEach
    void setup() {
        this.mockMvc= MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void getAllProducts() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(getProducts());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/getAll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    void getProduct() throws Exception {
        when(productService.getProduct(any()))
                .thenReturn(getProducts().get(0));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getProductByClientId() throws Exception {
        when(productService.getProductByClientId(any()))
                .thenReturn(getProducts());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_INDUSTRY_URL+"/client/0828a7ec-de89-432b-84ba-b4d8f1464616")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {
        when(productService.createProduct(any(ProductDTO.class)))
                .thenReturn(getProducts().get(0));

        mockMvc.perform(MockMvcRequestBuilders.post(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getProducts().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateProduct() throws Exception {
        when(productService.updateProduct(any(ProductDTO.class)))
                .thenReturn(getProducts().get(0));

        mockMvc.perform(MockMvcRequestBuilders.put(BASE_INDUSTRY_URL).content(ParkmateTestUtil.getStringFromObject().apply(getProducts().get(0)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProduct() throws Exception {
        doNothing().when(productService).deleteProduct(any());

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_INDUSTRY_URL+"/0828a7ec-de89-432b-84ba-b4d8f1464616")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}