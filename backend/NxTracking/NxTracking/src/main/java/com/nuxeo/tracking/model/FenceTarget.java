package com.nuxeo.tracking.model;

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
@Table(name = "fence_target")
public class FenceTarget {

	@Id
	@SequenceGenerator(name = "pk_fence_target_sequence", sequenceName = "fence_target_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_fence_target_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "id_target")
	private Long idTarget;

	@ManyToOne
	@JoinColumn(name = "id_fence")
	private Fence fence;
	
}