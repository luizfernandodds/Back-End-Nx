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
@Table(name = "group_block_exception")
public class GroupBlockException {

	@Id
	@SequenceGenerator(name = "pk_group_block_exception_sequence", sequenceName = "group_block_exception_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_group_block_exception_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "valid_for")
	private Integer validFor; //valido por x dias (default 1 caso não tenha sysadmin_super_client)
	
	@Column(name = "valid_until")
	private LocalDateTime validUntil; //valido até
	
	@Column(name = "destiny")
	private String destiny;
	
	@Column(name = "reason_exception", columnDefinition = "TEXT")
	private String reasonException;
	
	@Column(name = "wkt", columnDefinition = "TEXT")
	private String wkt;
	
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