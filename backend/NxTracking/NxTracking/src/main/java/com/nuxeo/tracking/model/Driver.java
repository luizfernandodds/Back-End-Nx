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
@Table(name = "driver")
public class Driver {

	@Id
	@SequenceGenerator(name = "pk_driver_sequence", sequenceName = "driver_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_driver_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "name_driver")
	private String name;

	@Column(name = "id_questor")
	private Long idQuestor;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "cnh")
	private String cnh;

	@Column(name = "category_cnh")
	private String categoryCnh;

	@Column(name = "contact")
	private String contact;

	@Column(name = "contact_phone")
	private String phoneContact;

	@Column(name = "date_vcnh")
	private LocalDateTime dateCnhExpire;

	@Column(name = "address")
	private String address;

	@Column(name = "number")
	private Integer number;

	@Column(name = "zip")
	private Integer zip;

	@Column(name = "ibutton")
	private String ibutton;

	@Column(name = "rfid")
	private String rfid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_city")
	private City city;

	@Column(name = "type_hiring")
	private String typeHiring;
	
	@Column(name = "responsible_name")
	private String responsibleName;

	@Column(name = "responsible_email")
	private String responsibleEmail;
	
	@Column(name = "responsible_phone")
	private String responsiblePhone;
	
	@Column(name = "notify_email")
	private Boolean notifyEmail = false;
	
	@Column(name = "notify_sms")
	private Boolean notifySms = false;

	@Column(name = "password")
	private String pass;
	
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