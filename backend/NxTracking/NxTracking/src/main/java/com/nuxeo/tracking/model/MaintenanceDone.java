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
@Table(name = "maintenance_done")
public class MaintenanceDone {

	@Id
	@SequenceGenerator(name = "pk_maintenance_done_sequence", sequenceName = "maintenance_done_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_maintenance_done_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "date_maitenance")
	private LocalDateTime dateMaitenance;

	@Column(name = "value_maitenance")
	private Long valueMaitenance;

	@Column(name = "diff")
	private Long diff;

	@Column(name = "diff_time")
	private Integer timeDiff;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@ManyToOne 
	@JoinColumn(name = "id_maintenance")
	private Maintenance maintenance;

	@ManyToOne 
	@JoinColumn(name = "id_target")
	private Target target;
	
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