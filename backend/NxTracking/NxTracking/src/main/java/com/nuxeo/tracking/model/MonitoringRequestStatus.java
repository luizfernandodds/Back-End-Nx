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
@Table(name = "monitoring_request_status")
public class MonitoringRequestStatus {

	@Id
	@SequenceGenerator(name = "pk_monitoring_request_status_sequence", sequenceName = "monitoring_request_status_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_monitoring_request_status_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_monitoring_request")
	private MonitoringRequest monitoringRequest;
	
	@ManyToOne
	@JoinColumn(name = "id_status_sm")
	private StatusSm statusSm;

	// Motivo da mudanças de status
	@Column(name = "mrs_note", columnDefinition = "TEXT")
	private String note;
	
	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "login_create")
	private Long loginCreate;
	
}