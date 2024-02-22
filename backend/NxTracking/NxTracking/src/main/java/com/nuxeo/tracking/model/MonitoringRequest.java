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
@Table(name = "monitoring_request")
public class MonitoringRequest {

	@Id
	@SequenceGenerator(name = "pk_monitoring_request_sequence", sequenceName = "monitoring_request_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_monitoring_request_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_driver")
	private Driver driver;

	@ManyToOne 
	@JoinColumn(name = "id_target_control")
	private Target targetControl;

	@ManyToOne 
	@JoinColumn(name = "id_target_reference")
	private Target targetReference;

	@ManyToOne
	@JoinColumn(name = "id_gris")
	private Gris gris;

	@ManyToOne
	@JoinColumn(name = "id_cost_center")
	private CostCenter costCenter;

	@ManyToOne
	@JoinColumn(name = "id_transporter")
	private Transporter transporter;

	@ManyToOne
	@JoinColumn(name = "id_logistic_operator")
	private LogisticalOperation logisticalOperation;

	@ManyToOne
	@JoinColumn(name = "id_semiTrailer1")
	private SemiTrailer semiTrailer1;

	@ManyToOne
	@JoinColumn(name = "id_semiTrailer2")
	private SemiTrailer semiTrailer2;

	@ManyToOne
	@JoinColumn(name = "id_semiTrailer3")
	private SemiTrailer semiTrailer3;

	@ManyToOne
	@JoinColumn(name = "id_synoptic")
	private Synoptic synoptic;

	@Column(name = "number_romaneio")
	private String numberRomaneio;

	@Column(name = "name_client")
	private String nameCustomer;

	@Column(name = "identifier_control")
	private String identifierControl;

	@Column(name = "identifier_reference")
	private String identifierReference;

	@Column(name = "date_start")
	private LocalDateTime dateStart;

	@Column(name = "date_intended")
	private LocalDateTime dateIntended;

	@Column(name = "date_finish")
	private LocalDateTime dateFinish;

	@Column(name = "date_charge_start")
	private LocalDateTime dateChargeStart;

	@Column(name = "date_charge_finish")
	private LocalDateTime dateChargeFinish;

	@Column(name = "date_discharge_start")
	private LocalDateTime dateDischargeStart;

	@Column(name = "date_discharge_finish")
	private LocalDateTime dateDischargeFinish;

	@Column(name = "date_forecast_loaded")
	private LocalDateTime dateForecastLoaded;

	@Column(name = "date_forecast_discharge")
	private LocalDateTime dateForecastDischarge;

	@Column(name = "date_forecast_empty")
	private LocalDateTime dateForecastEmpty;

	@Column(name = "loading_description")
	private String loadingDescription;

	@Column(name = "destiny")
	private String destiny;

	@Column(name = "route_id")
	private Integer idRoute;

	@Column(name = "load_weight")
	private Double loadWeight;

	@Column(name = "nature")
	private String nature;

	@Column(name = "specie")
	private String specie;

	@Column(name = "total_value")
	private Double totalValue;

	@Column(name = "empty_loaded")
	private Boolean emptyLoaded;

	@Column(name = "mirrored")
	private Boolean mirrored;

	@Column(name = "name_gr")
	private String nameGr;

	@Column(name = "dt_finished")
	private LocalDateTime dateFinishedClient;

	@Column(name = "reason", columnDefinition = "TEXT")
	private String reason;

	@Column(name = "mor_origin")
	private Integer origin;

	@Column(name = "nr_mobile")
	private String mobileTrackerNumber;

	@ManyToOne
	@JoinColumn(name = "ssm_id")
	private StatusSm statusSm;

	@Column(name = "serial")
	private String serial;

	@Column(name = "equipment_name")
	private String equipmentName;

	@Column(name = "telemonitoring")
	private Boolean telemonitoring = false;

	@Column(name = "checkpoint")
	private Integer checkpoint;

	@Column(name = "send_email")
	private Boolean sendEmail = false;

	@Column(name = "send_sms")
	private Boolean sendSms = false;

	@Column(name = "get_integration")
	private Integer integrationType;

	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	@Column(name = "route_existing")
	private Boolean routeExisting = false;

	@Column(name = "route_new")
	private Boolean routeNew = false;

	@Column(name = "no_login_id")
	private String idNoLogin;

	@Column(name = "driver_accepted")
	private Boolean accepted = false;
	
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