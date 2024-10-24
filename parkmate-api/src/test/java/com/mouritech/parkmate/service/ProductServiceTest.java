package com.mouritech.parkmate.service;

import com.mouritech.parkmate.dto.ProductDTO;
import com.mouritech.parkmate.mapper.ProductMapper;
import com.mouritech.parkmate.repository.ProductRepository;
import com.mouritech.parkmate.service.impl.ProductServiceImpl;
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

import static com.mouritech.parkmate.util.ParkmateTestUtil.getProductEntities;
import static com.mouritech.parkmate.util.ParkmateTestUtil.getProducts;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Mock
    ProductRepository productRepository;

    @Spy
    ModelMapper parkmateModelMapper;

    @Spy
    ProductMapper productMapper;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(productMapper,"parkmateModelMapper", parkmateModelMapper);
    }

    @Test
    void getAllProducts() {
       when(productRepository.findAll()).thenReturn(getProductEntities());
        List<ProductDTO> response = productServiceImpl.getAllProducts();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void getAllProductById() {
        when(productRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getProductEntities().get(0)));
        ProductDTO response = productServiceImpl.getProduct(UUID.randomUUID());
        assertNotNull(response);
    }

    @Test
    void createProduct() {
        when(productRepository.save(any())).thenReturn(getProductEntities().get(0));
        ProductDTO response = productServiceImpl.createProduct(getProducts().get(0));
        assertNotNull(response);
    }

    @Test
    void updateProduct() {
        when(productRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(getProductEntities().get(0)));
        when(productRepository.save(any())).thenReturn(getProductEntities().get(0));
        ProductDTO response = productServiceImpl.updateProduct(getProducts().get(0));
        assertNotNull(response);
    }

    @Test
    void deleteProduct() {
        doNothing().when(productRepository).deleteById(any());
        productServiceImpl.deleteProduct(UUID.randomUUID());
    }

    @Test
    void getAllProductsByClientId() {
        when(productRepository.findByClientClientId(any())).thenReturn(getProductEntities());
        List<ProductDTO> response = productServiceImpl.getProductByClientId(UUID.randomUUID());
        assertNotNull(response);
        assertEquals(1, response.size());
    }
}