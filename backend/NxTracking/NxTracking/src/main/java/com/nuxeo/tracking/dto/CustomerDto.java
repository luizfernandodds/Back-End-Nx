package com.nuxeo.tracking.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.nuxeo.tracking.model.City;
import com.nuxeo.tracking.model.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerDto {
	
	private Long id;
	private Company company;
	private LocalDateTime dateActive;
	private LocalDateTime dateDesactive;
	private String document;
	private String loginClient;
	private String name;
	private String docName;
	private String docTag;
	private String phone;
	private String email;
	private String address;
	private Integer number;
	private Integer zip;
	private Integer typeMap;
	private City city;
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
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(id, other.id);
	}
}
