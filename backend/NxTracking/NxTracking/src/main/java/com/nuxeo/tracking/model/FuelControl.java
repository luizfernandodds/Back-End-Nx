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
@Table(name = "fuel_control")
public class FuelControl {

	@Id
	@SequenceGenerator(name = "pk_fuel_control_sequence", sequenceName = "fuel_control_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_fuel_control_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_fuel_type")
	private FuelType fuelType;

	@Column(name = "km_start")
	private double kmStart;

	@Column(name = "km_end")
	private double kmEnd;

	@Column(name = "liters")
	private double liters;

	@Column(name = "date_supply")
	private LocalDateTime dateSupply; //data de abastecimento

	@Column(name = "fue_value")
	private double value;

	@ManyToOne
	@JoinColumn(name = "id_target")
	private Target target;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

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