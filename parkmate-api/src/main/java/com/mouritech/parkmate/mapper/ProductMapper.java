package com.mouritech.parkmate.mapper;

import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.dto.ProductDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    ModelMapper parkmateModelMapper;

    public Product convertToEntity(ProductDTO productDTO) {
        return parkmateModelMapper.map(productDTO, Product.class);
    }

    public ProductDTO convertToDTO(Product product) {
        return parkmateModelMapper.map(product, ProductDTO.class);
    }

    public static ProductDTO getDTOFromEntity(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId().toString());
        productDTO.setBillingFrequency(product.getBillingFrequency());
        productDTO.setCost(product.getCost());
        productDTO.setOnlinePurchase(product.getOnlinePurchase());
        productDTO.setActive(product.getActive());

        ClientDTO clientDTO = new ClientDTO();
        Client client = product.getClient();
        clientDTO.setClientId(product.getClient().getClientId().toString());
        clientDTO.setActive(client.getActive());
        clientDTO.setVersion(client.getVersion());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setPortalurl(client.getPortalurl());
        productDTO.setClient(clientDTO);

        return productDTO;
    }
}
