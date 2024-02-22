package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "sentinel")
public class Sentinel {

	@Id
	@SequenceGenerator(name = "pk_sentinel_sequence", sequenceName = "sentinel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sentinel_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "sen_identifier")
	private String identifier;

	@Column(name = "sen_latitude")
	private double latitude;

	@Column(name = "sen_longitude")
	private double longitude;

	//bi-directional many-to-one association to AttendanceSituation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_attendance_situation")
	private AttendanceSituation attendanceSituation;

	//bi-directional many-to-one association to Driver
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_criver")
	private Driver driver;

	//bi-directional many-to-one association to EventFired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_event_fired")
	private EventFired eventFired;

	//bi-directional many-to-one association to Login
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_login")
	private Login login;

	//bi-directional many-to-one association to Target
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_target")
	private Target target;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_ssma_event_fired")
	private SsmaEventFired ssmaEventFired;
	
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