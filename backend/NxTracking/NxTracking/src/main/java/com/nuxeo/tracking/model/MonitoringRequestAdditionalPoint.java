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
@Table(name = "monitoring_request_additional_point")
public class MonitoringRequestAdditionalPoint {

	@Id
	@SequenceGenerator(name = "pk_monitoring_request_additional_point_sequence", sequenceName = "monitoring_request_additional_point_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_monitoring_request_additional_point_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_monitoring_request")
	private MonitoringRequest monitoringRequest;
	
	@ManyToOne
	@JoinColumn(name = "mra_rot_id")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name = "mra_bpt_id")
	private BreakpointType breakpointType;
	
	@ManyToOne
	@JoinColumn(name = "mra_poi_id")
	private InterestPoint interestPoint;

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