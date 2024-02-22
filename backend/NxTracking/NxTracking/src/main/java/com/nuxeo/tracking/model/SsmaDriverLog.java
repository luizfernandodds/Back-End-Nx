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
@Table(name = "ssma_driver_log")
public class SsmaDriverLog {

	@Id
	@SequenceGenerator(name = "pk_ssma_driver_log_sequence", sequenceName = "ssma_driver_log_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_ssma_driver_log_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_ssma_driver_course")
	private SsmaDriverCourse ssmaDriverCourse;
	
	@Column (name = "type")
	private Integer type;
	
	@Column (name = "json", columnDefinition = "TEXT")
	private String jsonSend;
	
	@Column (name = "json_response", columnDefinition = "TEXT")
	private String jsonResponse;
	
	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
}