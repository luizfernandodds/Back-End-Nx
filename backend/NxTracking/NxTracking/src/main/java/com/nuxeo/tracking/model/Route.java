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
public class Route {

	@Id
	@SequenceGenerator(name = "pk_route_sequence", sequenceName = "route_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_route_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "name_route")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_control_point_geometry")
	private RouteGeometry routeGeometry;
	
	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "alternate")
	private Boolean routeAlternate = false;

	@Column(name = "id_external")
	private Integer idExternalRoute;

	@Column(name = "type")
	private Integer routeType;
	
	@Column(name = "address_start", columnDefinition = "TEXT")
	private String addressStart;

	@Column(name = "address_end", columnDefinition = "TEXT")
	private String addressEnd;
	
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