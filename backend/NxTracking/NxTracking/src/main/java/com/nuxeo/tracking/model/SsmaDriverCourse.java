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
@Table(name = "ssma_driver_course")
public class SsmaDriverCourse {

	@Id
	@SequenceGenerator(name = "pk_ssma_driver_course_sequence", sequenceName = "ssma_driver_course_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_ssma_driver_course_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_ssma_course")
	private SsmaCourse ssmaCourse;
	
	@Column (name = "cpf")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_driver")
	private Driver driver;
	
	@Column(name = "date_registration")
	private LocalDateTime dateRegistration;
	
	@Column (name = "link_course")
	private String linkCourse;
	
	@Column(name = "date_finished_course")
	private LocalDateTime dateFinishedCourse;
	
	@Column (name = "sdc_driver_blocked")
	private Boolean driverBlocked = false;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "average")
	private Double average;

	@Column (name = "progress")
	private Integer progress;

	@Column (name = "status")
	private String status;
	
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