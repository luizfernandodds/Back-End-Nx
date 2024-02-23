package com.nuxeo.tracking.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.nuxeo.tracking.model.CommandTypeIntegration;
import com.nuxeo.tracking.model.Customer;
import com.nuxeo.tracking.model.Login;
import com.nuxeo.tracking.model.PhoneLine;
import com.nuxeo.tracking.model.Protocol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDto {
	
	private Long id;
	private Customer customer;
	private String name;
	private Long serial;
	private Protocol protocol;
	private PhoneLine phoneLine;
	private Login logCad;
	private String firmware;
	private String model;
	private Integer qtdInput;
	private Integer qtdOutput;
	private String idSatelital;
	private CommandTypeIntegration commandTypeIntegration;
	private LocalDateTime dateCreate;
	private LocalDateTime dateUpdate;
	private LocalDateTime dateDelete;
	private Long loginCreate;
	private Long loginUpdate;
	private Long loginDelete;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceDto other = (DeviceDto) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
