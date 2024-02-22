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
@Table(name = "attendance_flag")
public class AttendanceFlag {

	@Id
	@SequenceGenerator(name = "pk_attendance_flag_sequence", sequenceName = "attendance_flag_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_attendance_flag_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "recovered")
	private Boolean recovered = false;

	@Column(name = "recovered_trailer")
	private Boolean recoveredTrailer = false;

	@Column(name = "recovered_truck")
	private Boolean recoveredTruck = false;

	@Column(name = "recovered_prf")
	private Boolean recoveredPrf = false;

	@Column(name = "recovered_r")
	private Boolean recoveredR = false;

	@Column(name = "armed_robbery")
	private Boolean armedRobbery = false;

	@Column(name = "rend_state_gas")
	private Boolean surrenderedStateGas = false;

	@Column(name = "rend_road")
	private Boolean surrenderedRoad = false;

	@Column(name = "hostage_driver")
	private Boolean hostageDriver = false;

	@Column(name = "previously_deviation")
	private Boolean previouslyDeviation = false;

	@Column(name = "contact_driver")
	private Boolean contactDriver = false;

	@Column(name = "informed_responsible")
	private Boolean informedResponsible = false;

	@Column(name = "police_powered")
	private Boolean policePowered = false;

	@Column(name = "ready_answer")
	private Boolean readyAnswer = false;

	@Column(name = "part_vehicle_route")
	private Boolean partVehicleRoute = false;

	@Column(name = "triggered_lock")
	private Boolean triggeredLock = false;

	@Column(name = "place_loading")
	private Boolean placeLoadingUnloading = false;

	@Column(name = "fuel_station")
	private Boolean fuelStation = false;

	@Column(name = "normalized_voltage")
	private Boolean normalizedVoltage = false;

	@Column(name = "respected_warning")
	private Boolean respectedWarning = false;

	@Column(name = "allowed_responsible")
	private Boolean allowedResponsible = false;

	@Column(name = "vehicle_route")
	private Boolean vehicleRoute = false;

	@Column(name = "block")
	private Boolean block = false;

	@Column(name = "siren")
	private Boolean siren = false;

	@Column(name = "signal_request")
	private Boolean signalRequest = false;

	@Column(name = "permitted_location")
	private Boolean permittedLocation = false;
	
	@Column(name = "boarding_macro_change")
	private Boolean boardingMacroChange = false;

	@Column(name = "sounding_siren")
	private Boolean soundingSiren = false;

	@Column(name = "flashing_on")
	private Boolean flashingOn = false;

	@Column(name = "macro_received")
	private Boolean macroReceived = false;

	@Column(name = "macro_sent")
	private Boolean macroSent = false;

	@Column(name = "block_sent")
	private Boolean blockSent = false;

	@Column(name = "reset_sent")
	private Boolean resetSent = false;

	@Column(name = "cargo_tipping")
	private Boolean cargoTipping = false;

	@Column(name = "spout_opening")
	private Boolean spoutOpening = false;

	@Column(name = "total_pressure_drop")
	private Boolean totalPressureDrop = false;

	@Column(name = "partial_pressure_drop")
	private Boolean partialPressureDrop = false;

	@Column(name = "injured_driver")
	private Boolean injuredDriver = false;

	@Column(name = "flammable_charge")
	private Boolean flammableCharge = false;

	@Column(name = "toxic_load")
	private Boolean toxicLoad = false;

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