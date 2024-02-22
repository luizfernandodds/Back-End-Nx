package com.nuxeo.tracking.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "attendance")
public class Attendance {

	@Id
	@SequenceGenerator(name = "pk_attendance_sequence", sequenceName = "attendance_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_attendance_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "local")
	private String local;

	@Lob
	@Column(name = "note", columnDefinition = "TEXT")
	private String note;

	@ManyToOne
	@JoinColumn(name = "id_target")
	private Target target;

	@ManyToOne
	@JoinColumn(name = "id_attendance_flag")
	private AttendanceFlag attendanceFlag;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_driver")
	private Driver driver;

	@ManyToOne
	@JoinColumn(name = "id_attendance_type")
	private AttendanceType type;

	@ManyToOne
	@JoinColumn(name = "id_attendance_status")
	private AttendanceStatus status;

	@OneToMany(mappedBy = "attendance", fetch = FetchType.LAZY)
	private List<AttendanceObs> attendanceObs;

	@Column(name = "treatedby")
	private String treatedby;

	@Column(name = "identifier")
	private String identifier;
	
	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "neighborhood")
	private String neighborhood;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@ManyToOne
	@JoinColumn(name = "id_ready_answer")
	private ReadyAnswer readyAnswer;
	
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