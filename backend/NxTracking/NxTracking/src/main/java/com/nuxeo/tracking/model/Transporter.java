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
@Table(name = "transporter")
public class Transporter {

	@Id
	@SequenceGenerator(name = "pk_transporter_sequence", sequenceName = "transporter_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_transporter_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name")
	private String name;

	@Column(name = "require_route")
	private Boolean routeRequired = false;
	
	@Column(name = "sm_open_status")
	private Boolean smOpenStatus = false;
	
	@Column(name = "sm_sentinel")
	private Boolean notCentralTreatment = false;
	
	@Column(name = "group_whatsapp_id")
	private String groupWhatsappId;
	
	@Column(name = "send_message_whatsapp")
	private Boolean sendMessageWhatsapp = false;
	
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