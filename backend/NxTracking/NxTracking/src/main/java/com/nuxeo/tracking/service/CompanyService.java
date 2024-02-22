package com.nuxeo.tracking.service;

import java.util.List;

import com.nuxeo.tracking.dto.CompanyDto;
import com.nuxeo.tracking.model.Company;

public interface CompanyService {

	public Company findById(Long id);
	public List<Company> findAll();
	public Company findByName(String name);
	public List<Company> findByNameLike(String name);
	public boolean isExist(Company company);	
	public Company save(Company company);
	public void deleteById(Long id);
	public void deleteAll();
	public Company update(Company company);
	public CompanyDto convertToDto(Company company);
	public Company convertToEntity(CompanyDto companyDto);
	public List<CompanyDto> convertToListDto(List<Company> listCompany);
	public List<Company> convertToListEntity(List<CompanyDto> listCompanyDto);

}
