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
@Table(name = "interest_point_geometry")
public class InterestPointGeometry {

	@Id
	@SequenceGenerator(name = "pk_interest_point_geometry_sequence", sequenceName = "interest_point_geometry_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_interest_point_geometry_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column (name = "latitude")
	private Double latitude;
	
	@Column (name = "longitude")
	private Double longitude;

	
	@Column(name = "radius")
	private Integer radius;

	@Column(name = "wkt", columnDefinition = "TEXT")
	private String wkt;

	@Column(name = "address", columnDefinition = "TEXT")
	private String address;
}