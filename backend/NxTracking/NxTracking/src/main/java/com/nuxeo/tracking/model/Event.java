package com.nuxeo.tracking.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "event")
public class Event {

	@Id
	@SequenceGenerator(name = "pk_event_sequence", sequenceName = "event_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_event_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_event_type")
	private EventType type;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "name")
	private String name;

	@Column(name = "parameter", columnDefinition = "TEXT")
	private String parameter;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "central_treatment")
	private Boolean centralTreatment;

	@Column(name = "action", columnDefinition = "TEXT")
	private String action;

	@Column(name = "date_alter")
	private LocalDateTime alterEvent;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "event_target", joinColumns = { @JoinColumn(name = "evt_eve_id") }, inverseJoinColumns = {
			@JoinColumn(name = "evt_trg_id") })
	private Set<Target> listTarget;

	@Column(name = "journey")
	private Boolean eventJourney  = false;

	@Column(name = "journey_end")
	private Boolean eventJourneyEnd  = false;

	@Column(name = "journey_type")
	private Integer eventJourneyType = 0;

	@Column(name = "id_travel_schedule")
	private Long idTravelSchedule;

	@Column(name = "end_post_office")
	private Boolean endPostOffice  = false;

	@Column(name = "id_journey")
	private Long idJourney;

	@Column(name = "no_position")
	private Boolean eventNoPosition  = false;

	@Column(name = "only_one_treatment")
	private Boolean eventOnlyOneTreatment  = false;

	@Column(name = "weight")
	private Integer eventWeight;

	@Column(name = "id_monitoring_request")
	private Long idMonitoringRequest;
	
	@Column(name = "id_control")
	private Integer idControl;

	@Column(name = "id_external")
	private Long idExternal;
	
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