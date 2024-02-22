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
@Table(name = "checklist_sensors")
public class CheckListSensors {

	@Id
	@SequenceGenerator(name = "pk_checklist_sensors_sequence", sequenceName = "checklist_sensors_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_checklist_sensors_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_sensor")
	private Sensors sensors;
	
	@ManyToOne
	@JoinColumn(name = "id_check_list")
	private CheckList checklist;
	
	@Column(name = "observation", columnDefinition = "TEXT")
	private String observation;
	
	@Column(name = "installed")
	private Boolean installed = false;
	
	@Column(name = "working")
	private Boolean working = false;
	
	@Column(name = "failure")
	private Boolean failure = false;
	
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