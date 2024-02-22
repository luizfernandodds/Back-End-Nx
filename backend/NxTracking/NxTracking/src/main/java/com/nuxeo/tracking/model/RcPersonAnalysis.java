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
public class RcPersonAnalysis {
 
	@Id
	@SequenceGenerator(name = "pk_rc_person_analysis_sequence", sequenceName = "rc_person_analysis_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_rc_person_analysis_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "id_person")
	private String idPerson;

	@Column(name = "name")
	private String name;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "birth_date")
	private LocalDateTime birthDate;

	@Column(name = "analysis_type")
	private String analysisType;

	@Column(name = "status")
	private String status;

	@Column(name = "expire_at_cnh")
	private LocalDateTime expireAtCnh;

	@Column(name = "category_cnh")
	private String categoryCnh;

	@Column(name = "cnh")
	private String cnh;

	@Column(name = "security_number_cnh")
	private String securityNumberCnh;

	@Column(name = "id_user")
	private String idUser;

	@Column(name = "state_rg")
	private String stateRg;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "rg")
	private String rg;

	@Column(name = "request_id")
	private String requestId;

	@Column(name = "person_analysis_type")
	private String personAnalysisType;

	@Column(name = "region_type")
	private String regionType;

	@Column(name = "region")
	private String region;

	@Column(name = "naturalness")
	private String naturalness;

	@Column(name = "combo_number")
	private Integer comboNumber;

	@Column(name = "document")
	private String document;

	@Column(name = "analysis_info", columnDefinition = "TEXT")
	private String analysisInfo;

	@Column(name = "analysis_result")
	private String analysisResult;

	@Column(name = "date_finished")
	private LocalDateTime dateFinished;

	@Column(name = "date_return_analysis")
	private LocalDateTime dateReturnAnalysis;

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