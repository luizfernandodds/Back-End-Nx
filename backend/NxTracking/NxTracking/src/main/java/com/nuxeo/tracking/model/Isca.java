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
@Table(name = "isca")
public class Isca {

	@Id
	@SequenceGenerator(name = "pk_isca_sequence", sequenceName = "isca_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_isca_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_monitoring_request")
	private MonitoringRequest monitoringRequest;
	
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column (name = "isc_number")
	private String number; //número da isca
	
	@Column (name = "isc_provider")
	private String provider; //fornecedor

	@Column (name = "isc_client")
	private String client; //cliente
	
	@Column (name = "isc_login")
	private String login; //cliente
	
	@Column (name = "isc_password")
	private String password; //senha
	
	@Column (name = "isc_installation_locale")
	private String installationLocale; //Local de instação
	
	@Column (name = "isc_website")
	private String website;
	
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