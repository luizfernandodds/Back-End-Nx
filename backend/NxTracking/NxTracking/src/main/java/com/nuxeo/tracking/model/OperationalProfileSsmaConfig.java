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
@Table(name = "operational_profile_ssma_config")
public class OperationalProfileSsmaConfig {

	@Id
	@SequenceGenerator(name = "pk_operational_profile_ssma_config_sequence", sequenceName = "operational_profile_ssma_config_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_operational_profile_ssma_config_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_operational_profile")
	private OperationalProfile operationalProfile;
	
	@ManyToOne
	@JoinColumn(name = "id_ssma_event")
	private SsmaEvent ssmaEvent;
	
	@Column (name = "init_speed")
	private Integer initSpeed;
	
	@Column (name = "end_speed")
	private Integer endSpeed;
	
	@Column (name = "surplus_minutes")
	private Integer surplusMinutes;
	
	@Column (name = "max_time_allowed")
	private String maxTimeAllowed;
	
	@Column (name = "score")
	private Integer score;
	
	@Column(name = "send_call")
	private Boolean sendTtsCall = false;
	
	@Column(name = "send_sms")
	private Boolean sendSMS = false;
	
	@Column(name = "send_email")
	private Boolean sendEmail = false;
	
	@Column(name = "send_whatsapp")
	private Boolean sendWhatsapp = false;
	
	@Column(name = "send_commands")
	private Boolean sendCommands = false;
	
	@Column(name = "send_alert")
	private Boolean sendAlert = false;
	
	@Column(name = "send_buzzer")
	private Boolean sendBuzzer = false;
	
	@Column(name = "send_keyboard")
	private Boolean sendKeyboard = false;
	
	@Column(name="msg_call", columnDefinition = "TEXT")
	private String msgCall;
	
	@Column(name="msg_sms", columnDefinition = "TEXT")
	private String msgSms;
	
	@Column(name="msg_email", columnDefinition = "TEXT")
	private String msgEmail;
	
	@Column(name="msg_whatsapp", columnDefinition = "TEXT")
	private String msgWhatsapp;
	
	@Column(name="msg_keyboard", columnDefinition = "TEXT")
	private String msgKeyboard;
	
	@Column(name = "center_attendance")
	private Boolean centerAttendance = false;
	
	@Column(name = "send_siren")
	private Boolean sendSiren = false;
	
	@Column(name = "send_block")
	private Boolean sendBlock = false;

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