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
@Table(name = "log_post_office")
public class LogSendInformation {

	@Id
	@SequenceGenerator(name = "pk_log_post_office_sequence", sequenceName = "log_post_office_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_log_post_office_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_log_type")
	private LogType logType;

	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@Column(name = "json_sent", columnDefinition = "TEXT")
	private String jsonSent;
	
	@Column(name = "id_id_monitoring_request")
	private Long idMonitoringRequest;
	
	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "login_create")
	private Long loginCreate;
	
}