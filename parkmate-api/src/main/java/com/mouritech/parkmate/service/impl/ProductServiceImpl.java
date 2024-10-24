package com.mouritech.parkmate.service.impl;

import com.mouritech.parkmate.dto.ProductDTO;
import com.mouritech.parkmate.entity.Product;
import com.mouritech.parkmate.exception.ResourceNotFoundException;
import com.mouritech.parkmate.mapper.ProductMapper;
import com.mouritech.parkmate.repository.ProductRepository;
import com.mouritech.parkmate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .map(product -> ProductMapper.getDTOFromEntity(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product ID not found: "+id));

        return ProductMapper.getDTOFromEntity(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);

        product = productRepository.save(product);

        productDTO = productMapper.convertToDTO(product);

        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepository.findById(UUID.fromString(productDTO.getProductId()))
                .orElseThrow(() -> new ResourceNotFoundException("Product ID not found: "+productDTO.getProductId()));

        productRepository.save(productMapper.convertToEntity(productDTO));

        return productDTO;
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getProductByClientId(UUID id) {
        List<Product> products = productRepository.findByClientClientId(id);

        return products
                .stream()
                .map(product -> ProductMapper.getDTOFromEntity(product))
                .collect(Collectors.toList());
    }
}

