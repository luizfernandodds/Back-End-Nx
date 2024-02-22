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
@Table(name = "technical_sheet")
public class TechnicalSheet {

	@Id
	@SequenceGenerator(name = "pk_technical_sheet_sequence", sequenceName = "technical_sheet_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_technical_sheet_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_post_office_line")
	private PostOfficeLine postOfficeLine;

	@Column(name = "number_line_tec")
	private String numberLineTec;

	@ManyToOne
	@JoinColumn(name = "id_technical_sheet_frequency")
	private TechnicalSheetFrequency technicalSheetFrequency;

	@ManyToOne
	@JoinColumn(name = "id_manager_unit")
	private ManagerUnit managerUnit;

	@Column(name = "origin_destiny")
	private String originDestiny;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "active")
	private Boolean active = true;

	@Column(name = "id_datasheet")
	private String idDatasheet;
	
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