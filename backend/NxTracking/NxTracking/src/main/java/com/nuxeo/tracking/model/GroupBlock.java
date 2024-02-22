package com.nuxeo.tracking.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name = "group_block")
public class GroupBlock {

	@Id
	@SequenceGenerator(name = "pk_group_block_sequence", sequenceName = "group_block_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_group_block_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_type_block_target")
	private TypeBlockTarget typeBlockTarget;
	
	@Column(name = "name")
	private String name;

	@Column(name = "hour_block")
	private LocalTime hourBlock; //hora para bloqueio

	@Column(name = "hour_unblock")
	private LocalTime hourUnblock; //hora para desbloqueio

	@Column(name = "interval_day")
	private Integer intervalDay; //Intervalo dias entre bloqueio e desbloqueio

	@Column(name = "block_monday")
	private Boolean blockMonday;
	
	@Column(name = "block_tuesday")
	private Boolean blockTuesday;
	
	@Column(name = "block_wednesday")
	private Boolean blockWednesday;
	
	@Column(name = "block_thursday")
	private Boolean blockThursday;
	
	@Column(name = "block_friday")
	private Boolean blockFriday;
	
	@Column(name = "block_saturday")
	private Boolean blockSaturday;
	
	@Column(name = "block_sunday")
	private Boolean blockSunday;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column (name = "id_event_first")
	private Long idEventFirst;
	
	@Column (name = "id_event_second")
	private Long idEventSecond;
	
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