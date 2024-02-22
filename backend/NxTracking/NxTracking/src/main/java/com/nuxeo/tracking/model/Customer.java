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
@Table(name = "customer")
public class Customer {

	@Id
	@SequenceGenerator(name = "pk_customer_sequence", sequenceName = "customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_customer_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;

	@Column(name = "date_active")
	private LocalDateTime dateActive;

	@Column(name = "date_desactive")
	private LocalDateTime dateDesactive;

	@Column(name = "document")
	private String document;

	@Column(name = "login")
	private String loginClient;

	@Column(name = "name")
	private String name;

	@Column(name = "doc_name")
	private String docName;

	@Column(name = "doc_tag")
	private String docTag;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "number")
	private Integer number;

	@Column(name = "zip")
	private Integer zip;

	@Column(name = "type_map")
	private Integer typeMap;

	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;

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