package com.mouritech.parkmate.service.impl;

import com.mouritech.parkmate.dto.OrganizationDTO;
import com.mouritech.parkmate.entity.Organization;
import com.mouritech.parkmate.exception.ResourceNotFoundException;
import com.mouritech.parkmate.mapper.OrganizationMapper;
import com.mouritech.parkmate.repository.OrganizationRepository;
import com.mouritech.parkmate.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();

        return organizations
                .stream()
                .map(organization -> OrganizationMapper.getDTOFromEntity(organization))
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDTO getOrganization(UUID id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization ID not found: "+id));

        return OrganizationMapper.getDTOFromEntity(organization);
    }

    @Override
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = organizationMapper.convertToEntity(organizationDTO);

        organization = organizationRepository.save(organization);

        organizationDTO = organizationMapper.convertToDTO(organization);

        return organizationDTO;
    }

    @Override
    public OrganizationDTO updateOrganization(OrganizationDTO organizationDTO) {
        organizationRepository.findById(UUID.fromString(organizationDTO.getOrganizationId()))
                .orElseThrow(() -> new ResourceNotFoundException("Organization ID not found: "+organizationDTO.getOrganizationId()));

        organizationRepository.save(organizationMapper.convertToEntity(organizationDTO));

        return organizationDTO;
    }

    @Override
    public void deleteOrganization(UUID id) {
        organizationRepository.deleteById(id);
    }

    @Override
    public List<OrganizationDTO> getOrganizationByClientId(UUID id) {
        List<Organization> organizations = organizationRepository.findByClientClientId(id);

        return organizations
                .stream()
                .map(organization -> OrganizationMapper.getDTOFromEntity(organization))
                .collect(Collectors.toList());
    }
}

