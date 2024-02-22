package com.nuxeo.tracking.model;

import java.time.LocalDate;
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
@Table(name = "travel_schedule")
public class TravelSchedule {

	@Id
	@SequenceGenerator(name = "pk_travel_schedule_sequence", sequenceName = "travel_schedule_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_travel_schedule_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_technical_sheet")
	private TechnicalSheet technicalSheet;

	@ManyToOne
	@JoinColumn(name = "id_target")
	private Target target;

	@Column(name = "date_scheduling")
	private LocalDate dateScheduling;

	@Column(name = "send_sms")
	private Boolean sendSms = false;

	@Column(name = "send_email")
	private Boolean sendEmail = false;

	@Column(name = "risk_management")
	private Boolean riskManagement = false;

	@Column(name = "integrated")
	private Boolean integrated = false;

	@Column(name = "anticipate_travel")
	private Boolean anticipateTravel = false;

	@Column(name = "anticipate_date_start")
	private LocalDateTime dateAnticipateStart;

	@Column(name = "anticipate_date_end")
	private LocalDateTime dateAnticipateEnd;

	@Column(name = "anticipate_obs", columnDefinition = "TEXT")
	private String anticipateObs;

	@Column(name = "deleted_automatic")
	private Boolean deletedAutomatic = false;

	@Column(name = "id_travel_external")
	private Integer idTravelExternal;

	@Column(name = "init_send_position")
	private Boolean initSendPosition = false;

	@Column(name = "end_send_position")
	private Boolean endSendPosition = false;

	@Column(name = "date_init_send_position")
	private LocalDateTime dateStartSendPosition;

	@Column(name = "date_end_travel")
	private LocalDateTime dateEndTravel;

	@Column(name = "resend_trip_tms")
	private Boolean resendTripTms = false;

	@Column(name = "accident")
	private Boolean accident = false;
	
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