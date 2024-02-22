package com.nuxeo.tracking.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "login_event_sentinel")
public class LoginEventSentinel {

	@Id
	@SequenceGenerator(name = "pk_login_event_sentinel_sequence", sequenceName = "login_event_sentinel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_login_event_sentinel_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "login_sentinel", joinColumns = { @JoinColumn(name = "los_les_id") }, inverseJoinColumns = {
			@JoinColumn(name = "los_evs_id") })
	private Set<EventSentinel> listEventSentinel;
	
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