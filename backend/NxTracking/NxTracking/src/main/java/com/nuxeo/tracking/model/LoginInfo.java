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
@Table(name = "login_info")
public class LoginInfo {

	@Id
	@SequenceGenerator(name = "pk_login_info_sequence", sequenceName = "login_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_login_info_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;
	
	@ManyToOne
	@JoinColumn(name = "id_contact_group")
	private ContactGroup contactGroup;
	
	@ManyToOne
	@JoinColumn(name = "id_contact_group_item")
	private ContactGroupItem contactGroupItem;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "celular")
	private String celular;
	
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