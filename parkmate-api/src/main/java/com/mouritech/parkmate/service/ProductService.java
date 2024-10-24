package com.mouritech.parkmate.service;


import com.mouritech.parkmate.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProduct(UUID id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    void deleteProduct(UUID id);

    List<ProductDTO> getProductByClientId(UUID id);
}

