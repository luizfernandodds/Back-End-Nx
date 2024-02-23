package com.nuxeo.tracking.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.nuxeo.tracking.model.City;
import com.nuxeo.tracking.model.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDto {

		private Long id;
		private Customer customer;
		private String name;
		private Long idQuestor;
		private String email;
		private String phone;
		private String cpf;
		private String rg;
		private String cnh;
		private String categoryCnh;
		private String contact;
		private String phoneContact;
		private LocalDateTime dateCnhExpire;
		private String address;
		private Integer number;
		private Integer zip;
		private String ibutton;
		private String rfid;
		private City city;
		private String typeHiring;
		private String responsibleName;
		private String responsibleEmail;
		private String responsiblePhone;
		private Boolean notifyEmail = false;
		private Boolean notifySms = false;
		private String pass;
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
			DriverDto other = (DriverDto) obj;
			return Objects.equals(id, other.id);
		}
		
		

}
