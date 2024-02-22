package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "group_block_sent")
public class GroupBlockSent {

	@Id
	@SequenceGenerator(name = "pk_group_block_sent_sequence", sequenceName = "group_block_sent_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_group_block_sent_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "id_group_block")
	private GroupBlock groupBlock;
	
	@ManyToOne
	@JoinColumn(name = "id_login")
	private Login login;

	@ManyToOne
	@JoinColumn(name = "id_device")
	private Device device;

	@Column(name = "date_init_millis")
	private Long dateMillis;
	
	@Column(name = "date_send")
	private LocalDateTime dateSend;
	
	@Column(name = "sent")
	private Boolean sent = false;

	@Column(name = "id_command")
	private Long idCommand;

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