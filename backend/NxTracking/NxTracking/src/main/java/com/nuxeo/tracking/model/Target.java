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
@Table(name = "target")
public class Target {

	@Id
	@SequenceGenerator(name = "pk_target_sequence", sequenceName = "target_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_target_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Column(name = "name")
	private String name;


	@Column(name = "tag_icon")
	private Integer icon;

	@Column(name = "tag_identifier")
	private String identifier;

	@ManyToOne
	@JoinColumn(name = "id_device")
	private Device device;

	@ManyToOne
	@JoinColumn(name = "id_target_type")
	private TargetType targetType;

	@ManyToOne
	@JoinColumn(name = "id_target_model")
	private TargetModel targetModel;

	@ManyToOne
	@JoinColumn(name = "id_driver")
	private Driver driver;
	
	@Column(name = "chassi")
	private String chassi;

	@Column(name = "answerable")
	private String answerable;

	@Column(name = "email_answerable")
	private String emailAnswerable;

	@Column(name = "phone_answerable")
	private String phoneAnswerable;

	@Column(name = "renavam")
	private String renavam;

	@Column(name = "operation")
	private String operation;

	@ManyToOne
	@JoinColumn(name = "id_semi_trailer")
	private SemiTrailer semiTrailer;
	
	@Column(name = "weight")
	private Integer weight;

	@Column(name = "accident")
	private Boolean accident=false;

	@Column(name = "telemonitoring")
	private Boolean telemonitoring=false;
	
	@Column(name = "active")
	private Boolean active;

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