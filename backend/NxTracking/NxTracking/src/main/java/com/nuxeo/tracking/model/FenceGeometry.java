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
@Table(name = "fence_geometry")
public class FenceGeometry {

	@Id
	@SequenceGenerator(name = "pk_fence_geometry_sequence", sequenceName = "fence_geometry_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_fence_geometry_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "wkt", columnDefinition = "TEXT")
	private String wkt;

}