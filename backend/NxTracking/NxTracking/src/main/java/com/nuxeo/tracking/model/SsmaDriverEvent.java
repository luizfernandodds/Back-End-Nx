package com.nuxeo.tracking.model;

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
@Table(name = "ssma_driver_event")
public class SsmaDriverEvent {

	@Id
	@SequenceGenerator(name = "pk_ssma_driver_course_sequence", sequenceName = "ssma_driver_course_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_ssma_driver_course_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name")
	private String name;

	@Column(name = "login")
	private String login;

	@Column(name = "cpf")
	private String cpf = null;
	
	@Column(name = "name_customer")
	private String nameCustomer;

	@Column(name = "id_driver_external")
	private String idDriverExternal;

	@Column(name = "code_driver_external")
	private String codeDriverExternal;

	@Column(name = "driver_tag")
	private String driverTag;

	@Column(name = "document_driver")
	private String documentDriver;
	
}