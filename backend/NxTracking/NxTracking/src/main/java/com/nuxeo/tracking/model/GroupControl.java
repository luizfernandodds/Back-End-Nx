package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

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
@Table(name = "group_control")
public class GroupControl {

	@Id
	@SequenceGenerator(name = "pk_group_control_sequence", sequenceName = "group_control_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_group_control_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private Integer type;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

//	@ManyToMany(cascade = { javax.persistence.CascadeType.ALL }, fetch = FetchType.EAGER)
//	@JoinTable(name = "group_target", joinColumns = { @JoinColumn(name = "grt_gro_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "grt_tag_id") })
//	private Set<Target> targets;

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