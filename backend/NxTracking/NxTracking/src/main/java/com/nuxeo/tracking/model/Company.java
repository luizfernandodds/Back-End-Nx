package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.nuxeo.tracking.dto.CompanyDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

	@Autowired
	CompanyDto companyDto;
	
	@Id
	@SequenceGenerator(name = "pk_company_sequence", sequenceName = "company_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_company_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "fantasy_name")
	private String fantasyName;

	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "state_registration")
	private String stateRegistration;

	@Column(name = "municipal_registration")
	private String municipalRegistration;

	@Column(name = "email")
	private String email;

	@Column(name = "comercial_phone")
	private String comercialPhone;

	@Column(name = "cell_phone")
	private String cellPhone;

	@Column(name = "fax")
	private String fax;
	
	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "date_update")
	private LocalDateTime dateUpdate;

	@Column(name = "date_delete")
	private LocalDateTime dateDelete;


}