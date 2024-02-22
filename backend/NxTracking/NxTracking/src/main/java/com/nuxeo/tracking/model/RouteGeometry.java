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
@Table(name = "route_geometry")
public class RouteGeometry {

	@Id
	@SequenceGenerator(name = "pk_route_geometry_sequence", sequenceName = "route_geometry_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_route_geometry_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "wkt", columnDefinition = "TEXT")
	private String wkt;

	@Column(name = "points")
	private String points;

	@Column(name = "address", columnDefinition = "TEXT")
	private String address;
	
	@Column(name = "waypoint", columnDefinition = "TEXT")
	private String waypoint;
	
	@Column(name = "bounds")
	private String bounds;
	
	@Column(name = "radius")
	private Integer radius;

	@Column(name = "wkt_points", columnDefinition = "TEXT")
	private String wktPoints;

	@Column(name = "id_route")
	private Long idRoute;
}