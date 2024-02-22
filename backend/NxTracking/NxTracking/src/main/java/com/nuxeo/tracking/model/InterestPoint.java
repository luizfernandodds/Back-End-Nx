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
@Table(name = "interest_point")
public class InterestPoint {

	@Id
	@SequenceGenerator(name = "pk_interest_point_sequence", sequenceName = "interest_point_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_interest_point_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@Column (name = "radius")
	private Integer radius;
	
	@Column(name = "id_external")
	private Long idExternal;
	
	@Column(name = "id_external_route")
	private Long idExternalRoute;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_interest_point_geometry")
	private InterestPointGeometry interestPointGeometry;
	
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