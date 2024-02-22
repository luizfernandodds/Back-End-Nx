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
@Table(name = "event_target")
public class EventTarget {

	@Id
	@SequenceGenerator(name = "pk_event_target_sequence", sequenceName = "event_target_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_event_target_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "id_target")
	private Long idTarget;

	@ManyToOne
	@JoinColumn(name = "id_event")
	private Event event;
	
}