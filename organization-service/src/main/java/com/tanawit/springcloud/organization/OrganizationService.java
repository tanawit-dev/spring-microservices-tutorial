package com.tanawit.springcloud.organization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	public List<Organization> findAllOrganization() {
		return organizationRepository.findAll();
	}
	
	public Organization findOraganizationById(String id) {
		return organizationRepository.findById(id).orElse(null);
	}
	
	public Organization createOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}
	
	public Organization updateOrganization(String id, Organization organization) {
		organizationRepository.findById(id).ifPresent(o -> organization.setId(o.getId()));
		return organizationRepository.save(organization);
	}
	
	public void deleteOrganization(String id) {
		organizationRepository.deleteById(id);
	}
}
