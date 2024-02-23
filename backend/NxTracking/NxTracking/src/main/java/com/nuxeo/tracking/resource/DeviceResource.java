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

import com.nuxeo.tracking.dto.DeviceDto;
import com.nuxeo.tracking.model.Device;
import com.nuxeo.tracking.service.DeviceService;

@RestController
@RequestMapping("/api/v1/devices")
@CrossOrigin(origins="*") 
public class DeviceResource {
	
	private final Logger logger = LoggerFactory.getLogger(DeviceResource.class);
	
	@Autowired
	private DeviceService deviceService;

	List<DeviceDto> listDeviceDto = null;
	
	@GetMapping
	public ResponseEntity<List<DeviceDto>> findAll() {
		//listAnchoringDto = mapper.readValue(json.toString(), new TypeReference<List<AnchoringDto>>(){});
		System.out.println("COMPANIES dataplus 2");
		logger.info("lista de empresas");
		
		List<Device> listDevice = deviceService.findAll();
		if(listDevice!=null && listDevice.size() > 0) {
			listDeviceDto = new ArrayList<>();
			listDeviceDto = deviceService.convertToListDto(listDevice);
		}
		return new ResponseEntity<List<DeviceDto>>(listDeviceDto,HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Device> findById(@PathVariable Long id){
		Device objJson = deviceService.findById(id);
		return ResponseEntity.ok().body(objJson);
	}
	
	
	@GetMapping("/search")
		public ResponseEntity<List<Device>> findByName(@RequestParam(name = "name", required = true) String name){
			List<Device> list = deviceService.findByNameLike(name);
			return ResponseEntity.ok().body(list);
		}
	
	
	
	@PostMapping
	public ResponseEntity<Device> create(@RequestBody Device objJson) {
		System.out.println("POST DRIVER");
		objJson = deviceService.save(objJson);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objJson.getId()).toUri();
		
		return ResponseEntity.created(uri).body(objJson);
	}
	
	@PutMapping
	public ResponseEntity<Device> update(@RequestBody Device objJson){
		objJson = deviceService.save(objJson);
		return ResponseEntity.ok().body(objJson);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		deviceService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll(){
		deviceService.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
//	@PostMapping("/companies")
//	public Device create(@RequestBody Device objJson) {
//		System.out.println("POST DRIVER");
//		try {
			

//			return deviceService.save(objJson);
//		} catch (Exception e) {
			
//			throw new ExceptionGenericServerException("Erro no Servidor [Inserir Banco] - Exceção: " + e.getMessage());
//		}
//	}

//	@PutMapping("/companies")
//	public Response update(@RequestBody Device objJson) {	
//		System.out.println("tESTE UPDATE");
//		
////		exDto = new ExceptionMessageDto();
////		Device device = new Device();
////		
////		try {			
////			if (objJson!=null && objJson.getObjectId() != null) {
////				device = deviceService.update(objJson);
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
//		//return Response.status(200).entity(device.toString()).type("application/json").build();
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
