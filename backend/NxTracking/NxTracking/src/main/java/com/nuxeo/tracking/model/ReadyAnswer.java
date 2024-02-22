package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ready_answer")
public class ReadyAnswer {

	@Id
	@SequenceGenerator(name = "pk_ready_answer_sequence", sequenceName = "ready_answer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_ready_answer_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column (name = "name")
	private String name;
	
	@Column (name = "franchise")
	private Double franchise;
	
	@Column (name = "time")
	private String time;
	
	@Column (name = "speed")
	private Integer speed;
	
	@Column (name = "additional")
	private Double additional;
	
	@Column (name = "km_rotated")
	private Double kmRotated;
	
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