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
@Table(name = "login_sentinel")
public class LoginSentinel {

	@Id
	@SequenceGenerator(name = "pk_login_sentinel_sequence", sequenceName = "login_sentinel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_login_sentinel_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_login_event_sentinel")
	private LoginEventSentinel loginEventSentinel;

	@ManyToOne
	@JoinColumn(name = "id_event_sentinel")
	private EventSentinel eventSentinel;
	
}