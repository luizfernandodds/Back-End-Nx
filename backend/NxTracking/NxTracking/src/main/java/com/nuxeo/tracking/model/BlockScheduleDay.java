package com.nuxeo.tracking.model;

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
@Table(name = "block_schedule_day")
public class BlockScheduleDay {

	@Id
	@SequenceGenerator(name = "pk_block_schedule_day_sequence", sequenceName = "block_schedule_day_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_block_schedule_day_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "bld_sunday")
	private Boolean sunday = false;	

	@Column(name = "bld_monday")
	private Boolean monday = false;	

	@Column(name = "bld_tuesday")
	private Boolean tuesday = false;	

	@Column(name = "bld_wednesday")
	private Boolean wednesday = false;	

	@Column(name = "bld_thursday")
	private Boolean thursday = false;	

	@Column(name = "bld_friday")
	private Boolean friday = false;	

	@Column(name = "bld_saturday")
	private Boolean saturday = false;
	
}