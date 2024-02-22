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
@Table(name = "black_list")
public class BlackList {

	@Id
	@SequenceGenerator(name = "pk_black_list_sequence", sequenceName = "black_list_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_black_list_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name="name", insertable=false)
	private String name;

	@Column(name = "cnh")
	private String cnh;
	
	@Column(name = "categ_cnh")
	private String categoryCnh;
	
	@Column(name = "date_cnh_expire")
	private LocalDateTime date_cnh_expire;
	
	@Column(name = "cpf")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_driver")
	private Driver driver;
	
	@Column(name = "obs")
	private String observation;
	
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