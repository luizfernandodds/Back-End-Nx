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
@Table(name = "sms")
public class Sms {

	@Id
	@SequenceGenerator(name = "pk_sms_sequence", sequenceName = "sms_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sms_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@Column(name = "modem")
	private String modem;

	@Column(name = "provider")
	private Integer provider;

	@Column(name = "phone")
	private String phone;

	@Column(name = "data")
	private String data;

	@Column(name = "type")
	private Integer type;

	@Column(name = "status")
	private Integer status;

	@Column(name = "response")
	private String response;

	@Column(name = "sent")
	private LocalDateTime sent;

	@Column(name = "date")
	private LocalDateTime date;
	
}
