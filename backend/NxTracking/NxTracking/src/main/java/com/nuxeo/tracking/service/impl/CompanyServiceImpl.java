package com.nuxeo.tracking.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuxeo.tracking.dto.CompanyDto;
import com.nuxeo.tracking.model.Company;
import com.nuxeo.tracking.repository.CompanyRepository;
import com.nuxeo.tracking.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository repository;
 
    private ModelMapper modelMapper;

	@Override
	public Company findById(Long id) {
		return repository.findById(id).orElse(new Company());
	}
	
	@Override
	public List<Company> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Company> findByNameLike(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}
	

	@Override
	public Company findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public boolean isExist(Company company) {
		return findByName(company.getName())!=null;
	}
	
	@Override
	public Company save(Company company) {
		return repository.save(company);
	}

	@Override
	public Company update(Company company) {
		return repository.save(company);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public CompanyDto convertToDto(Company company) {
		modelMapper = new ModelMapper();
		CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
	    return companyDto;
	}
	
	@Override
	public Company convertToEntity(CompanyDto companyDto) {
		modelMapper = new ModelMapper();
		Company company = modelMapper.map(companyDto, Company.class);
	    return company;
	}
	
	@Override
	public List<CompanyDto> convertToListDto(List<Company> listCompany) {
		modelMapper = new ModelMapper();
		List<CompanyDto> listCompanyDto = Arrays.asList(modelMapper.map(listCompany,  CompanyDto[].class));
	    return listCompanyDto;
	}
	
	@Override
	public List<Company> convertToListEntity(List<CompanyDto> listCompanyDto) {
		modelMapper = new ModelMapper();
		List<Company> listCompany = Arrays.asList(modelMapper.map(listCompanyDto, Company[].class));
	    return listCompany;
	}
	
}
