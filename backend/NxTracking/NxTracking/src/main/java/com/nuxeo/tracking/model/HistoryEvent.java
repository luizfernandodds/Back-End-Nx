package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "history_event")
public class HistoryEvent {

	@Id
	@SequenceGenerator(name = "pk_history_event_sequence", sequenceName = "history_event_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_history_event_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "answerable")
	private String answerable;

	@Column(name = "date_gps")
	private LocalDateTime gps;

	@Column(name = "date_without_marks", insertable = false)
	private LocalDateTime withoutMarks;

	@Column(name = "equipament_model")
	private String equipamentModel;

	@Column(name = "last_position_lat")
	private double lastPositionLat;

	@Column(name = "last_position_lng")
	private double lastPositionLng;

	@Column(name = "local")
	private String local;

	@Column(name = "situation")
	private String situation;

	@Column(name = "speed")
	private Integer speed;

	@Column(name = "treatedby")
	private String treatedby;

	@Column(name = "id_device")
	private Long idDevice;

	@Column(name = "id_driver")
	private Long idDriver;

	@Column(name = "id_event_fired")
	private Long idEventFired;

	@Column(name = "id_login")
	private Long id_login;

	@Column(name = "id_target")
	private Long idTarget;

	@Lob
	@Column(name = "observation", columnDefinition = "TEXT")
	private String observation;

	@ManyToOne
	@JoinColumn(name = "id_attendance_situation")
	private AttendanceSituation attendanceSituation;

	@Column(name = "justification", columnDefinition = "TEXT")
	private String justification;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "id_event_fired_ssma")
	private Long eventFiredSsmaId;

	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "login_create")
	private Long loginCreate;
	
}