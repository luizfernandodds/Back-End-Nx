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
@Table(name = "rc_person_analysis")
public class RcVehicleAnalysis {
 
	@Id
	@SequenceGenerator(name = "pk_rc_person_analysis_sequence", sequenceName = "rc_person_analysis_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_rc_person_analysis_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "message")
	private String message;

	@Column(name = "vehicle_id")
	private String vehicleId;

	@Column(name = "request_id")
	private String requestId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "analysis_type")
	private String analysisType;

	@Column(name = "plate")
	private String plate;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "renavam")
	private String renavam;

	@Column(name = "chassis")
	private String chassis;

	@Column(name = "status")
	private String status;

	@Column(name = "vehicle_type")
	private String vehicleType;

	@Column(name = "plate_state")
	private String plateState;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "combo_number")
	private Integer comboNumber;

	@Column(name = "owner_document")
	private String ownerDocument;

	@Column(name = "date_return_analysis")
	private LocalDateTime dateReturnAnalysis;

	@Column(name = "date_finished")
	private LocalDateTime dateFinished;

	@Column(name = "analysis_info", columnDefinition = "TEXT")
	private String analysisInfo;

	@Column(name = "analysis_result")
	private String analysisResult;

	@Column(name = "create_time_millisecond")
	private Long createTimeMillisecond;
	
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