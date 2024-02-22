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
@Table(name = "synoptic")
public class Synoptic {

	@Id
	@SequenceGenerator(name = "pk_gris_sequence", sequenceName = "gris_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_gris_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "risk_management_program")
	private String riskManagementProgram;
	
	@Column(name = "operation")
	private String operation;
	
	@Column(name = "policy_limit")
	private Double policyLimit;
	
	@Column(name = "date_exp")
	private LocalDateTime dateExp;
	
	@ManyToOne
	@JoinColumn (name = "id_product")
	private Product product;
	
	@Column(name = "battery_percentage")
	private Integer batteryPercentage;
	
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