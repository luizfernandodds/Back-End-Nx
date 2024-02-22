package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

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
@Table(name = "service_schedule")
public class ServiceSchedule {

	@Id
	@SequenceGenerator(name = "pk_service_schedule_sequence", sequenceName = "service_schedule_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_service_schedule_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "no_position_active")
	private Boolean noPositionActive;

	@Column(name = "date_alter")
	private LocalDateTime alterService;

	@Column(name = "block_schedule_active")
	private Boolean blockScheduleActive;

	@Column(name = "add_hour_report")
	private Integer addHourReport;

	@Column(name = "add_millisecond_report_date_gps")
	private Integer addMillisecondDateGps;

	@Column(name = "add_hour_report_date_gps_export")
	private Integer addMillisecondDateGpsExport;
	
	@Column(name = "analysis_m2")
	private Boolean analysisM2Active;
	
	@Column(name = "woli_sincronize")
	private Boolean woliSynchronize;
	
	@Column(name = "woli_matriculate")
	private Boolean woliMatriculate;

	@Column(name = "add_millisecond_group_block")
	private Integer addMillisecondGroupBlock;

	@Column(name = "add_hour_report_journey")
	private Integer addHourReportJourney;
	
	@Column(name = "date_delete")
	private LocalDateTime dateDelete;
}