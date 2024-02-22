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
@Table(name = "contact_group")
public class ContactGroup {

	@Id
	@SequenceGenerator(name = "pk_contact_group_sequence", sequenceName = "contact_group_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_contact_group_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name")
	private String name;

	@Column (name = "send_email")
	private Boolean sendEmail = false;
	
	@Column (name = "send_sms")
	private Boolean sendSms = false;

	@Column(name = "status_sm_email")
	private Boolean statusSmEmail = true;
	
	@Column(name = "status_sm_sms")
	private Boolean statusSmSms = true;
	
	@Column(name = "route_deviation_email")
	private Boolean routeDeviationEmail = true;
	
	@Column(name = "route_deviation_sms")
	private Boolean routeDeviationSms = true;
	
	@Column(name = "start_travel_email")
	private Boolean startTravelEmail = true;
	
	@Column(name = "start_travel_sms")
	private Boolean startTravelSms = true;
	
	@Column(name = "end_travel_email")
	private Boolean endTravelEmail = true;
	
	@Column(name = "end_travel_sms")
	private Boolean endTravelSms = true;
	
	@Column(name = "signal_loss_email")
	private Boolean signalLossEmail = true;
	
	@Column(name = "signal_loss_sms")
	private Boolean signalLossSms = true;
	
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