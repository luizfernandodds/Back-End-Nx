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

import com.nuxeo.tracking.dto.PeripheralDto;
import com.nuxeo.tracking.model.Peripheral;
import com.nuxeo.tracking.service.PeripheralService;

@RestController
@RequestMapping("/api/v1/peripherals")
@CrossOrigin(origins="*") 
public class PeripheralResource {
	
	private final Logger logger = LoggerFactory.getLogger(PeripheralResource.class);
	
	@Autowired
	private PeripheralService peripheralService;

	List<PeripheralDto> listPeripheralDto = null;
	
	@GetMapping
	public ResponseEntity<List<PeripheralDto>> findAll() {
		//listAnchoringDto = mapper.readValue(json.toString(), new TypeReference<List<AnchoringDto>>(){});
		System.out.println("COMPANIES dataplus 2");
		logger.info("lista de empresas");
		
		List<Peripheral> listPeripheral = peripheralService.findAll();
		if(listPeripheral!=null && listPeripheral.size() > 0) {
			listPeripheralDto = new ArrayList<>();
			listPeripheralDto = peripheralService.convertToListDto(listPeripheral);
		}
		return new ResponseEntity<List<PeripheralDto>>(listPeripheralDto,HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Peripheral> findById(@PathVariable Long id){
		Peripheral objJson = peripheralService.findById(id);
		return ResponseEntity.ok().body(objJson);
	}
	
	
//	@GetMapping("/search")
//		public ResponseEntity<List<Peripheral>> findByCompany(@RequestParam(name = "name", required = true) String name){
//			List<Peripheral> list = peripheralService.findByNameLike(name);
//			return ResponseEntity.ok().body(list);
//		}
	
	@GetMapping("/search")
	public ResponseEntity<List<Peripheral>> findBySerial(@RequestParam(name = "serial", required = true) String serial){
		List<Peripheral> list = peripheralService.findBySerial(serial);
		return ResponseEntity.ok().body(list);
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<Peripheral> create(@RequestBody Peripheral objJson) {
		System.out.println("POST PERIPHERAL");
		objJson = peripheralService.save(objJson);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objJson.getId()).toUri();
		
		return ResponseEntity.created(uri).body(objJson);
	}
	
	@PutMapping
	public ResponseEntity<Peripheral> update(@RequestBody Peripheral objJson){
		objJson = peripheralService.save(objJson);
		return ResponseEntity.ok().body(objJson);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		peripheralService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll(){
		peripheralService.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
//	@PostMapping("/companies")
//	public Peripheral create(@RequestBody Peripheral objJson) {
//		System.out.println("POST COMPANY");
//		try {
			

//			return peripheralService.save(objJson);
//		} catch (Exception e) {
			
//			throw new ExceptionGenericServerException("Erro no Servidor [Inserir Banco] - Exceção: " + e.getMessage());
//		}
//	}

//	@PutMapping("/companies")
//	public Response update(@RequestBody Peripheral objJson) {	
//		System.out.println("tESTE UPDATE");
//		
////		exDto = new ExceptionMessageDto();
////		Peripheral peripheral = new Peripheral();
////		
////		try {			
////			if (objJson!=null && objJson.getObjectId() != null) {
////				peripheral = peripheralService.update(objJson);
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
//		//return Response.status(200).entity(peripheral.toString()).type("application/json").build();
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
