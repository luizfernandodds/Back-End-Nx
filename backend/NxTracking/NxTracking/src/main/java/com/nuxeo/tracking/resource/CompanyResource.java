package com.nuxeo.tracking.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nuxeo.tracking.dto.CompanyDto;
import com.nuxeo.tracking.model.Company;
import com.nuxeo.tracking.service.CompanyService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*") 
public class CompanyResource {
	
	private final Logger logger = LoggerFactory.getLogger(CompanyResource.class);
	
	@Autowired
	private CompanyService companyService;

	List<CompanyDto> listCompanyDto = null;
	
	@GetMapping("/companies")
	public ResponseEntity<List<CompanyDto>> findAll() {
		//listAnchoringDto = mapper.readValue(json.toString(), new TypeReference<List<AnchoringDto>>(){});
		System.out.println("COMPANIES dataplus 2");
		logger.info("lista de empresas");
		
		List<Company> listCompany = companyService.findAll();
		if(listCompany!=null && listCompany.size() > 0) {
			listCompanyDto = new ArrayList<>();
			listCompanyDto = companyService.convertToListDto(listCompany);
		}
		return new ResponseEntity<List<CompanyDto>>(listCompanyDto,HttpStatus.OK);
	}
	
	@GetMapping(value="/companies/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id){
		Company objJson = companyService.findById(id);
		return ResponseEntity.ok().body(objJson);
	}
	
	
	@GetMapping("/companies/search")
		public ResponseEntity<List<Company>> findByName(@RequestParam(name = "name", required = true) String name){
			List<Company> list = companyService.findByNameLike(name);
			return ResponseEntity.ok().body(list);
		}
	
	
	
	@PostMapping("/companies")
	public ResponseEntity<Company> create(@RequestBody Company objJson) {
		System.out.println("POST COMPANY");
		objJson = companyService.save(objJson);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objJson.getId()).toUri();
		
		return ResponseEntity.created(uri).body(objJson);
	}
	
	@PutMapping("/companies")
	public ResponseEntity<Company> update(@RequestBody Company objJson){
		objJson = companyService.save(objJson);
		return ResponseEntity.ok().body(objJson);
	}
	
	@DeleteMapping("/companies/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		companyService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/companies")
	public ResponseEntity<Void> deleteAll(){
		companyService.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
//	@PostMapping("/companies")
//	public Company create(@RequestBody Company objJson) {
//		System.out.println("POST COMPANY");
//		try {
			

//			return companyService.save(objJson);
//		} catch (Exception e) {
			
//			throw new ExceptionGenericServerException("Erro no Servidor [Inserir Banco] - Exceção: " + e.getMessage());
//		}
//	}

//	@PutMapping("/companies")
//	public Response update(@RequestBody Company objJson) {	
//		System.out.println("tESTE UPDATE");
//		
////		exDto = new ExceptionMessageDto();
////		Company company = new Company();
////		
////		try {			
////			if (objJson!=null && objJson.getObjectId() != null) {
////				company = companyService.update(objJson);
////			}else {
////				exDto.setPath("/api/v1/companies");
////				exDto.setError("Objeto com ID inválido [Alterar Empresa]");
////				
////				String ret = new Gson().toJson(exDto);
////				return Response.status(401).entity(ret).type("application/json").build();	
////			}
////		} catch (Exception e) {
////			exDto.setStatus(200);
////			exDto.setPath("/api/v1/companies");
////			exDto.setError("ERRO ao alterar Alterar Empresa");
////			String ret = new Gson().toJson(exDto);
////			return Response.status(500).entity(ret).type("application/json").build();	
////		}
//
//		//return Response.status(200).entity(company.toString()).type("application/json").build();
//		
//	//	exDto.setPath("/api/v1/companies");
//	//	exDto.setError("Objeto com ID inválido [Alterar Empresa]");
//		
//		String ret = new Gson().toJson(exDto);
//		
//		System.out.println("ret: "+ret.toString());
//		return Response.status(401).entity(ret).type("application/json").build();	
//
//		//return null;
//	}
}
