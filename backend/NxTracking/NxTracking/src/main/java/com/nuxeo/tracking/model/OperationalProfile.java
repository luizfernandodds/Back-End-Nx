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
@Table(name = "operational_profile")
public class OperationalProfile {

	@Id
	@SequenceGenerator(name = "pk_operational_profile_sequence", sequenceName = "operational_profile_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_operational_profile_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="description", columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contact_group")
	private ContactGroup contactGroup;
	
	@Column (name = "id_group_control")
	private Long idGroupControl;
	
	@Column(name = "time_to_run_call")
	private Integer timeToRunCall;
	
	@Column(name = "time_to_run_sms")
	private Integer timeToRunSms;
	
	@Column(name = "time_to_run_email")
	private Integer timeToRunEmail;
	
	@Column(name = "time_to_run_whatsapp")
	private Integer timeToRunWhatsapp;
	
	@Column(name = "time_to_run_commands")
	private Integer timeToRunCommands;
	
	@ManyToOne
	@JoinColumn(name = "id_operational_profile_type")
	private OperationalProfileType operationalProfileType;
	
	@Column(name = "send_call")
	private Boolean sendCall = false;
	
	@Column(name = "send_sms")
	private Boolean sendSMS = false;
	
	@Column(name = "send_email")
	private Boolean sendEmail = false;
	
	@Column(name = "send_whatsapp")
	private Boolean sendWhatsapp = false;
	
	@Column(name = "send_commands")
	private Boolean sendCommands = false;
	
	@Column(name="whatsapp_group", columnDefinition = "TEXT")
	private String whatsappGroup;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cell_phone_sms")
	private String cellPhoneSms;
	
	@Column(name = "cell_phone_call")
	private String cellPhoneCall;

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