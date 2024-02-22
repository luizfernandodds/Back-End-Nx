package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "integration_post_office")
public class IntegrationPostOffice {

	@Id
	@SequenceGenerator(name = "pk_integration_post_office_sequence", sequenceName = "integration_post_office_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_integration_post_office_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_travel_schedule")
	private TravelSchedule travelSchedule;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status_integration")
	private StatusIntegration statusIntegration;

	@Column(name = "date_send")
	private LocalDateTime dateSend;

	
}