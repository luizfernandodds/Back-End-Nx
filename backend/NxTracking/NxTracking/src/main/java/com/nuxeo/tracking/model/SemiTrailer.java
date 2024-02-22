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
@Table(name = "semi_trailer")
public class SemiTrailer {

	@Id
	@SequenceGenerator(name = "pk_semi_trailer_sequence", sequenceName = "semi_trailer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_semi_trailer_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "identifier")
	private String identifier;

	@ManyToOne
	@JoinColumn(name = "id_semi_trailer")
	private CategorySemiTrailer category;
	
	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;

	@Column(name = "year")
	private Integer year;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "color")
	private String color;

	@Column(name = "color_tarp")
	private String colorTarp;

	@Column(name = "chassi")
	private String chassi;

	@Column(name = "renavam")
	private String renavam;

	@Column(name = "owner_name")
	private String ownerName;
	
	@Column(name = "owner_number")
	private String ownerNumber;
	
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