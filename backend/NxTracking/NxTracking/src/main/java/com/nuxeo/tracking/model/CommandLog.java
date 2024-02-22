package com.nuxeo.tracking.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "command_log")
public class CommandLog {

	@Id
	@SequenceGenerator(name = "pk_command_log_sequence", sequenceName = "command_log_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_command_log_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_command")
	private Command command;

	@ManyToOne
	@JoinColumn(name = "id_device")
	private Device device;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "parameter", columnDefinition = "TEXT")
	private String parameter;

	@Column(name = "str_command")
	private String strCommand;

	@Column(name = "pending")
	private Boolean pending = true;

	@OneToMany(mappedBy = "commandLog", fetch = FetchType.EAGER)
	private Set<CommandStatus> commandStatuses;
	
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