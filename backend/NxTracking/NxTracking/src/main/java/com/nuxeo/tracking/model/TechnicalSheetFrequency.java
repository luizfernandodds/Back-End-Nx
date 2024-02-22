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
@Table(name = "technical_sheet_frequency")
public class TechnicalSheetFrequency {

	@Id
	@SequenceGenerator(name = "pk_technical_sheet_frequency_sequence", sequenceName = "technical_sheet_frequency_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_technical_sheet_frequency_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "sunday")
	private Boolean sunday = false;	

	@Column(name = "monday")
	private Boolean monday = false;	

	@Column(name = "tuesday")
	private Boolean tuesday = false;	

	@Column(name = "wednesday")
	private Boolean wednesday = false;	

	@Column(name = "thursday")
	private Boolean thursday = false;	

	@Column(name = "friday")
	private Boolean friday = false;	

	@Column(name = "saturday")
	private Boolean saturday = false;	
	
}