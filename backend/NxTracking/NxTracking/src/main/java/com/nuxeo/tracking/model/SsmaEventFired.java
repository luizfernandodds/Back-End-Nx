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
@Table(name = "ssma_event_fired")
public class SsmaEventFired {

	@Id
	@SequenceGenerator(name = "pk_ssma_event_fired_sequence", sequenceName = "ssma_driver_course_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_ssma_event_fired_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_driver")
	private Driver driver;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "name")
	private String name;

	@Column(name = "total_score")
	private Integer totalScore;

	@Column(name = "date_reception")
	private LocalDateTime dateReception;
	
	@ManyToOne
	@JoinColumn(name = "id_ssma_event")
	private SsmaEvent ssmaEvent;
	
	@ManyToOne
	@JoinColumn(name = "id_ssma_event_fired")
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