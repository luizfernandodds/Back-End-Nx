package com.nuxeo.tracking.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.nuxeo.tracking.model.Customer;
import com.nuxeo.tracking.model.PeripheralType;
import com.nuxeo.tracking.model.Provider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeripheralDto {
	
	private Long id;
	private Customer customer;
	private PeripheralType peripheralType;
	private String name;
	private String serial;
	private String description;
	private Provider provider;
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
		PeripheralDto other = (PeripheralDto) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
