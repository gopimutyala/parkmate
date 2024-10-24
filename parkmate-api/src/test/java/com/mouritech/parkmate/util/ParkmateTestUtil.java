package com.mouritech.parkmate.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mouritech.parkmate.dto.ClientBrandingDTO;
import com.mouritech.parkmate.dto.ClientDTO;
import com.mouritech.parkmate.dto.ClientImageDTO;
import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.dto.ParkerProfileDTO;
import com.mouritech.parkmate.dto.ProductDTO;
import com.mouritech.parkmate.entity.Client;
import com.mouritech.parkmate.entity.ClientBranding;
import com.mouritech.parkmate.entity.ClientImage;
import com.mouritech.parkmate.entity.Organization;
import com.mouritech.parkmate.entity.ParkerProfile;
import com.mouritech.parkmate.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class ParkmateTestUtil {

    public static List<ClientDTO> getClients() {
        List<ClientDTO> dtos = new ArrayList<ClientDTO>();
        ClientDTO dto = new ClientDTO();
        dto.setClientId("0828a7ec-de89-432b-84ba-b4d8f1464616");
        dtos.add(dto);

        dto.setClientBrandings(getClientBrandings());
        dto.setClientImages(getClientImages());

        return dtos;
    }

    public static List<ClientBrandingDTO> getClientBrandings() {
        List<ClientBrandingDTO> dtos = new ArrayList<ClientBrandingDTO>();
        ClientBrandingDTO dto = new ClientBrandingDTO();
        dto.setClientBrandingId("0828a7ec-de89-432b-84ba-b4d8f1464616");
        dtos.add(dto);

        return dtos;
    }

    public static List<ClientImageDTO> getClientImages() {
        List<ClientImageDTO> dtos = new ArrayList<ClientImageDTO>();
        ClientImageDTO dto = new ClientImageDTO();
        dto.setClientImageId("0828a7ec-de89-432b-84ba-b4d8f1464616");
        dtos.add(dto);

        return dtos;
    }

    public static List<OrganizationDTO> getOrganizations() {
        List<OrganizationDTO> dtos = new ArrayList<OrganizationDTO>();
        OrganizationDTO dto = new OrganizationDTO();
        dto.setOrganizationId("0828a7ec-de89-432b-84ba-b4d8f1464616");
        dtos.add(dto);

        return dtos;
    }

    public static List<ProductDTO> getProducts() {
        List<ProductDTO> dtos = new ArrayList<ProductDTO>();
        ProductDTO dto = new ProductDTO();
        dto.setProductId("0828a7ec-de89-432b-84ba-b4d8f1464616");
        dtos.add(dto);

        return dtos;
    }

    public static List<ParkerProfileDTO> getParkerProfiles() {
        List<ParkerProfileDTO> dtos = new ArrayList<ParkerProfileDTO>();
        ParkerProfileDTO dto = new ParkerProfileDTO();
        dto.setParkerProfileId("0828a7ec-de89-432b-84ba-b4d8f1464616");
        dtos.add(dto);

        return dtos;
    }

    public static Function<Object, String> getStringFromObject() {
        return object -> {
            try {
                return new ObjectMapper().writeValueAsString(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        };
    }

    public static List<Client> getClientEntities() {
        List<Client> entities = new ArrayList<Client>();
        Client dto = new Client();
        dto.setClientId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        entities.add(dto);

        return entities;
    }

    public static List<ClientBranding> getClientBrandingEntities() {
        List<ClientBranding> entities = new ArrayList<ClientBranding>();
        ClientBranding dto = new ClientBranding();
        dto.setClientBrandingId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));

        Client clientdto = new Client();
        clientdto.setClientId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        dto.setClient(clientdto);

        entities.add(dto);

        return entities;
    }

    public static List<ClientImage> getClientImageEntities() {
        List<ClientImage> entities = new ArrayList<ClientImage>();
        ClientImage dto = new ClientImage();
        dto.setClientImageId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));

        Client clientdto = new Client();
        clientdto.setClientId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        dto.setClient(clientdto);

        entities.add(dto);

        return entities;
    }

    public static List<Organization> getOrganizationEntities() {
        List<Organization> entities = new ArrayList<Organization>();
        Organization dto = new Organization();
        dto.setOrganizationId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));

        Client clientdto = new Client();
        clientdto.setClientId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        dto.setClient(clientdto);

        entities.add(dto);

        return entities;
    }

    public static List<Product> getProductEntities() {
        List<Product> entities = new ArrayList<Product>();
        Product dto = new Product();
        dto.setProductId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));

        Client clientdto = new Client();
        clientdto.setClientId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        dto.setClient(clientdto);

        entities.add(dto);

        return entities;
    }

    public static List<ParkerProfile> getParkerProfileEntities() {
        List<ParkerProfile> entities = new ArrayList<ParkerProfile>();
        ParkerProfile dto = new ParkerProfile();
        dto.setParkerProfileId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));

        Client clientdto = new Client();
        clientdto.setClientId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        dto.setClient(clientdto);

        Organization orgDto = new Organization();
        orgDto.setOrganizationId(UUID.fromString("0828a7ec-de89-432b-84ba-b4d8f1464616"));
        dto.setOrganization(orgDto);

        entities.add(dto);

        return entities;
    }

}
