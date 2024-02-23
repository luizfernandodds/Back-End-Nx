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

import com.nuxeo.tracking.dto.CustomerDto;
import com.nuxeo.tracking.model.Customer;
import com.nuxeo.tracking.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins="*") 
public class CustomerResource {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
	
	@Autowired
	private CustomerService customerService;

	List<CustomerDto> listCustomerDto = null;
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> findAll() {
		//listAnchoringDto = mapper.readValue(json.toString(), new TypeReference<List<AnchoringDto>>(){});
		System.out.println("CUSTOMERS dataplus 2");
		logger.info("lista de clientes");
		
		List<Customer> listCustomer = customerService.findAll();
		if(listCustomer!=null && listCustomer.size() > 0) {
			listCustomerDto = new ArrayList<>();
			listCustomerDto = customerService.convertToListDto(listCustomer);
		}
		return new ResponseEntity<List<CustomerDto>>(listCustomerDto,HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id){
		Customer objJson = customerService.findById(id);
		return ResponseEntity.ok().body(objJson);
	}
	
	
	@GetMapping("/search")
		public ResponseEntity<List<Customer>> findByName(@RequestParam(name = "name", required = true) String name){
			List<Customer> list = customerService.findByNameLike(name);
			return ResponseEntity.ok().body(list);
		}
	
	
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer objJson) {
		System.out.println("POST CUSTOMER");
		objJson = customerService.save(objJson);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objJson.getId()).toUri();
		
		return ResponseEntity.created(uri).body(objJson);
	}
	
	@PutMapping
	public ResponseEntity<Customer> update(@RequestBody Customer objJson){
		objJson = customerService.save(objJson);
		return ResponseEntity.ok().body(objJson);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		customerService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll(){
		customerService.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
//	@PostMapping("/companies")
//	public Customer create(@RequestBody Customer objJson) {
//		System.out.println("POST COMPANY");
//		try {
			

//			return customerService.save(objJson);
//		} catch (Exception e) {
			
//			throw new ExceptionGenericServerException("Erro no Servidor [Inserir Banco] - Exceção: " + e.getMessage());
//		}
//	}

//	@PutMapping("/companies")
//	public Response update(@RequestBody Customer objJson) {	
//		System.out.println("tESTE UPDATE");
//		
////		exDto = new ExceptionMessageDto();
////		Customer customer = new Customer();
////		
////		try {			
////			if (objJson!=null && objJson.getObjectId() != null) {
////				customer = customerService.update(objJson);
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
//		//return Response.status(200).entity(customer.toString()).type("application/json").build();
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
