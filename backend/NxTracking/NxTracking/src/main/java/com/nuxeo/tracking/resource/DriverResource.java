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

import com.nuxeo.tracking.dto.DriverDto;
import com.nuxeo.tracking.model.Driver;
import com.nuxeo.tracking.service.DriverService;

@RestController
@RequestMapping("/api/v1/drivers")
@CrossOrigin(origins="*") 
public class DriverResource {
	
	private final Logger logger = LoggerFactory.getLogger(DriverResource.class);
	
	@Autowired
	private DriverService driverService;

	List<DriverDto> listDriverDto = null;
	
	@GetMapping
	public ResponseEntity<List<DriverDto>> findAll() {
		//listAnchoringDto = mapper.readValue(json.toString(), new TypeReference<List<AnchoringDto>>(){});
		System.out.println("COMPANIES dataplus 2");
		logger.info("lista de empresas");
		
		List<Driver> listDriver = driverService.findAll();
		if(listDriver!=null && listDriver.size() > 0) {
			listDriverDto = new ArrayList<>();
			listDriverDto = driverService.convertToListDto(listDriver);
		}
		return new ResponseEntity<List<DriverDto>>(listDriverDto,HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Driver> findById(@PathVariable Long id){
		Driver objJson = driverService.findById(id);
		return ResponseEntity.ok().body(objJson);
	}
	
	
	@GetMapping("/search")
		public ResponseEntity<List<Driver>> findByName(@RequestParam(name = "name", required = true) String name){
			List<Driver> list = driverService.findByNameLike(name);
			return ResponseEntity.ok().body(list);
		}
	
	
	
	@PostMapping
	public ResponseEntity<Driver> create(@RequestBody Driver objJson) {
		System.out.println("POST DRIVER");
		objJson = driverService.save(objJson);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objJson.getId()).toUri();
		
		return ResponseEntity.created(uri).body(objJson);
	}
	
	@PutMapping
	public ResponseEntity<Driver> update(@RequestBody Driver objJson){
		objJson = driverService.save(objJson);
		return ResponseEntity.ok().body(objJson);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		driverService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll(){
		driverService.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
//	@PostMapping("/companies")
//	public Driver create(@RequestBody Driver objJson) {
//		System.out.println("POST DRIVER");
//		try {
			

//			return driverService.save(objJson);
//		} catch (Exception e) {
			
//			throw new ExceptionGenericServerException("Erro no Servidor [Inserir Banco] - Exceção: " + e.getMessage());
//		}
//	}

//	@PutMapping("/companies")
//	public Response update(@RequestBody Driver objJson) {	
//		System.out.println("tESTE UPDATE");
//		
////		exDto = new ExceptionMessageDto();
////		Driver driver = new Driver();
////		
////		try {			
////			if (objJson!=null && objJson.getObjectId() != null) {
////				driver = driverService.update(objJson);
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
//		//return Response.status(200).entity(driver.toString()).type("application/json").build();
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
