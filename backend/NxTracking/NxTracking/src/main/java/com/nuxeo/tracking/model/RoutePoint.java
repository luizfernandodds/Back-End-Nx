package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "route")
public class RoutePoint {

	@Id
	@SequenceGenerator(name = "pk_route_sequence", sequenceName = "route_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_route_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_control_point_geometry")
	private RouteGeometry routeGeometry;
	
	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@Column(name = "alternate")
	private Boolean routeAlternate = false;

	@Column(name = "type")
	private Integer routeType;
	
	@Column(name = "date_delete")
	private LocalDateTime dateDelete;
	
}