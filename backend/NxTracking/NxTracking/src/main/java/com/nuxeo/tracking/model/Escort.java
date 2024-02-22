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
@Table(name = "escort")
public class Escort {

	@Id
	@SequenceGenerator(name = "pk_escort_sequence", sequenceName = "escort_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_escort_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_security_company")
	private SecurityCompany securityCompany;

	@ManyToOne
	@JoinColumn(name = "id_monitoring_request")
	private MonitoringRequest monitoringRequest;

	@ManyToOne
	@JoinColumn(name = "id_type_tracker")
	private TypeTracker typeTracker;

	@Column(name = "car")
	private String car; // VIATURA

	@Column(name = "cell")
	private String cell; // CELULAR

	@Column(name = "nextel")
	private String nextel; // NEXTEL

	@Column(name = "vigilant")
	private String vigilant; // VIGILANTE

	@Column(name = "number_tracker")
	private String numberTracker; // Número Rastreador

	@Column(name = "order_service")
	private String orderService; // Ordem de Serviço

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