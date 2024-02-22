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
@Table(name = "monitoring_request_nf")
public class MonitoringRequestNf {

	@Id
	@SequenceGenerator(name = "pk_monitoring_request_nf_sequence", sequenceName = "monitoring_request_nf_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_monitoring_request_nf_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_monitoring_request")
	private MonitoringRequest monitoringRequest;
	
	@Column(name = "nf_number")
	private Integer nfNumber;

	@Column(name = "nf_series")
	private String nfSeries;

	@Column(name = "cte_number")
	private Integer cteNumber;

	@Column(name = "date_cte_emission")
	private LocalDateTime dateCteEmission;

	@Column(name = "date_nf_emission")
	private LocalDateTime dateNfEmission;

	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "login_create")
	private Long loginCreate;
	
	@Column(name = "date_delete")
	private LocalDateTime dateDelete;
	
	@Column(name = "login_delete")
	private Long loginDelete;
}