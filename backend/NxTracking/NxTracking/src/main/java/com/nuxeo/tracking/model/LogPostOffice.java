package com.nuxeo.tracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "log_post_office")
public class LogPostOffice {

	@Id
	@SequenceGenerator(name = "pk_log_post_office_sequence", sequenceName = "log_post_office_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_log_post_office_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "fkid_viagem")
	private Integer fkidViagem;

	@Column(name = "sent_post", columnDefinition = "TEXT")
	private String sentPost;

	@Column(name = "return_post", columnDefinition = "TEXT")
	private String returnPost;
	
	@Column(name = "date_create")
	private LocalDateTime dateCreate;
	
	@Column(name = "login_create")
	private Long loginCreate;
	
}