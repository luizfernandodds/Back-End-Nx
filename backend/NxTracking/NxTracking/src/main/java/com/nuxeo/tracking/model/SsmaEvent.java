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
@Table(name = "gris")
public class SsmaEvent {

	@Id
	@SequenceGenerator(name = "pk_gris_sequence", sequenceName = "gris_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_gris_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_event_type")
	private EventType eventType;

	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@ManyToOne
	@JoinColumn(name = "id_event_control")
	private EventControl eventControl;

	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private Boolean active = true;
	
	@Column(name = "central_treatment")
	private Boolean centralTreatment = false;
	
	@Column(name = "action", columnDefinition = "TEXT")
	private String action;
	
	@Column(name = "no_position")
	private Boolean noPosition = false;
	
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