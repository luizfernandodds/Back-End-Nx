package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "address")
public class Address {

	@Id
	@SequenceGenerator(name = "pk_address_sequence", sequenceName = "address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_address_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "company")
	private String company;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "phone2")
	private String phone2;

	@Column(name = "phone3")
	private String phone3;

	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;

	@Column(name = "street")
	private String street;

	@Column(name = "complement")
	private String complement;

	@Column(name = "number")
	private Integer number;

	@Column(name = "zip")
	private Integer zip;

	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "date_update")
	private LocalDateTime dateUpdate;

	@Column(name = "date_delete")
	private LocalDateTime dateDelete;
	
	@Column(name = "login_create")
	private Long loginCreate;
	
	@Column(name = "login_update")
	private Long loginUpdate;

	@Column(name = "login_delete")
	private Long loginDelete;
	
}