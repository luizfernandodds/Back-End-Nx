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
@Table(name = "event_fired")
public class EventFired {

	@Id
	@SequenceGenerator(name = "pk_event_fired_sequence", sequenceName = "event_fired_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_event_fired_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "evf_dev_id")
	private Device device;

	@Column(name = "date_beg")
	private LocalDateTime beginDate;

	@Column(name = "date_end")
	private LocalDateTime endDate;

	@Column(name = "id_event")
	private Long event;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "latitude_beg")
	private Double latitudeBegin;

	@Column(name = "logintude_beg")
	private Double longitudeBegin;

	@Column(name = "evf_addr_beg")
	private String addressBegin;

	@Column(name = "country_beg")
	private String countryBegin;

	@Column(name = "city_begin")
	private String cityBegin;

	@Column(name = "state_beg")
	private String stateBegin;

	@Column(name = "latitude_end")
	private Double latitudeEnd;

	@Column(name = "longitude_end")
	private Double longitudeEnd;

	@Column(name = "address_end")
	private String addressEnd;

	@Column(name = "country_end")
	private String countryEnd;

	@Column(name = "city_end")
	private String cityEnd;

	@Column(name = "state_end")
	private String stateEnd;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_driver")
	private Driver driver;

	@ManyToOne
	@JoinColumn(name = "id_event_type")
	private EventType eventType;

	@Column(name = "date_treatment")
	private LocalDateTime dateTreatment;

	@Column(name = "ignition")
	private Boolean ignition;

	@Column(name = "panic")
	private Boolean panic;

	@Column(name = "block")
	private Boolean block;

	@Column(name = "speed")
	private Integer speed;

	@Column(name = "speed_end")
	private Integer speedEnd;

	@Column(name = "treatment_automatic")
	private Boolean treatmentAutomatic  = false;

	@Column(name = "central_treatment")
	private Boolean centralTreatment  = false;

	@Column(name = "antitheft")
	private Integer antitheft;

	@Column(name = "id_travel_schedule")
	private Long idTrip;

	@Column(name = "id_login_treatment")
	private Long idLoginTreatment;
	
	@Column(name = "car_door_sensor")
	private Boolean carDoorSensor;

	@Column(name = "driver_door_sensor")
	private Boolean driverDoorSensor;

	@Column(name = "disengagement_sensor")
	private Boolean disengagementSensor;

	@Column(name = "panel_sensor")
	private Boolean panelSensor;

	@Column(name = "fifth_wheel_lock_sensor")
	private Boolean fifthWheelLockSensor;

	@Column(name = "jammer_sensor")
	private Boolean jammerSensor;

	@Column(name = "trunk_door_sensor")
	private Boolean trunkDoorSensor;

	@Column(name = "panic_sensor")
	private Boolean panicSensor;

	@Column(name = "screen_sensor")
	private Boolean screenSensor;
	
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