package com.nuxeo.tracking.model;

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
@Table(name = "event_control")
public class EventControl {

	@Id
	@SequenceGenerator(name = "pk_event_control_sequence", sequenceName = "event_control_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_event_control_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "message", columnDefinition = "TEXT")
	private String message;

	@Column(name = "open_sm")
	private Boolean openSm  = false;

	@Column(name = "open_post_office")
	private Boolean openPostOffice  = false;

	@Column(name = "tts_call")
	private Boolean ttsCall  = false;

	@Column(name = "passive_call")
	private Boolean passiveCall  = false;

	@Column(name = "sms")
	private Boolean sendSms  = false;

	@Column(name = "email")
	private Boolean sendEmail  = false;

	@Column(name = "keyboard_msg")
	private Boolean sendMessageKeyboard  = false;

	@Column(name = "treat_automatic")
	private Boolean treatAutomatic  = false;
	
	@Column(name = "use_contact_group")
	private Boolean useContactGroup  = false;

	@Column(name = "command_block")
	private Boolean sendCommandBlock  = false;

	@Column(name = "command_block_sighra")
	private Boolean sendCommandBlockSighra  = false;

	@Column(name = "command_block_onix")
	private Boolean sendCommandBlockOnix  = false;

	@Column(name = "command_block_movement")
	private Boolean sendCommandBlockMovement  = false;

	@Column(name = "command_buzzer_sighra")
	private Boolean sendBuzzerSighra  = false;

	@Column(name = "send_whatsapp")
	private Boolean sendWhatsapp  = false;
	
	@Column(name = "message_whatsapp", columnDefinition = "TEXT")
	private String messageWhatsapp;

	@Column(name = "command_buzzer_onix")
	private Boolean sendBuzzerOnix  = false;

	@Column(name = "command_block_sighra_fence")
	private Boolean sendCommandBlockFenceSighra = false;

	@Column(name = "command_buzzer_positron")
	private Boolean sendBuzzerPositron  = false;

	@Column(name = "command_block_positron")
	private Boolean sendCommandBlockPositron  = false;

	@Column(name = "command_siren_positron")
	private Boolean sendCommandSirenPositron  = false;

	@Column(name = "command_flash_alert_positron")
	private Boolean sendCommandFlashAlertPositron  = false;

	@Column(name = "command_buzzer_sascar")
	private Boolean sendBuzzerSascar  = false;

	@Column(name = "command_block_sascar")
	private Boolean sendCommandBlockSascar  = false;

	@Column(name = "command_siren_sascar")
	private Boolean sendCommandSirenSascar  = false;

	@Column(name = "command_flash_alert_sascar")
	private Boolean sendCommandFlashAlertSascar  = false;
	
}