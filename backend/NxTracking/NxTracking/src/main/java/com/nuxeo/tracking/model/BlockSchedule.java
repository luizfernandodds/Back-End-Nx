package com.nuxeo.tracking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
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
@Table(name = "block_schedule")
public class BlockSchedule {

	@Id
	@SequenceGenerator(name = "pk_block_schedule_sequence", sequenceName = "block_schedule_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_block_schedule_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_block_schedule_type")
	private BlockScheduleType blockScheduleType;

	@Column(name = "date_init")
	private LocalDateTime dateInit;
	
	@Column(name = "date_end")
	private LocalDateTime dateEnd;
	
	@Column(name = "bls_time_init")
	private String timeInit;
	
	@Column(name = "bls_time_end")
	private String timeEnd;
	
	@Column(name = "date_only_init")
	private LocalDate dateOnlyInit;
	
	@Column(name = "date_only_end")
	private LocalDate dateOnlyEnd;
	
	@Column(name = "date_init_millis")
	private Long dateInitMillis;
	
	@Column(name = "date_end_millis")
	private Long dateEndMillis;
	
	@Column(name = "repeat_every")
	private Integer repeatEvery;
	
	@Column(name = "enabled")
	private Boolean enabled = true;

	@Column(name = "offset_locale")
	private String offsetLocale;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "id_block_schedule_day")
	private BlockScheduleDay blockScheduleDay;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "block_schedule_target", joinColumns = { @JoinColumn(name = "bst_bls_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "bst_tag_id") })
//	private Set<Target> targets;
	
	@Column(name = "all_day")
	private Boolean allDay = false;

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