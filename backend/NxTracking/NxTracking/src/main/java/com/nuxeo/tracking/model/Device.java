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
@Table(name = "device")
public class Device {

	@Id
	@SequenceGenerator(name = "pk_device_sequence", sequenceName = "device_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_device_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "name")
	private String name;

	@Column(name = "serial")
	private Long serial;

	@ManyToOne
	@JoinColumn(name = "id_protocol")
	private Protocol protocol;

	@ManyToOne
	@JoinColumn(name = "id_phone_Line")
	private PhoneLine phoneLine;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_login")
	private Login logCad;

	@Column(name = "firmware")
	private String firmware;

	@Column(name = "model")
	private String model;

	@Column(name = "qtd_input")
	private Integer qtdInput;

	@Column(name = "qtd_output")
	private Integer qtdOutput;

	@Column(name = "id_satelital")
	private String idSatelital;

	@ManyToOne
	@JoinColumn(name = "id_command_type")
	private CommandTypeIntegration commandTypeIntegration;
	
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