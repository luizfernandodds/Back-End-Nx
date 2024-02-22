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
@Table(name = "operational_profile_ssma_performance")
public class OperationalProfileSsmaPerformance {

	@Id
	@SequenceGenerator(name = "pk_operational_profile_ssma_performance_sequence", sequenceName = "operational_profile_ssma_performance_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_operational_profile_ssma_performance_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_operational_profile")
	private OperationalProfile operationalProfile;
	
	@Column (name = "good_starting_score")
	private Integer goodStartingScore;
	
	@Column (name = "good_final_score")
	private Integer goodFinalScore;
	
	@Column (name = "regular_starting_score")
	private Integer regularStartingScore;
	
	@Column (name = "regular_final_score")
	private Integer regularFinalScore;
	
	@Column (name = "move_away_starting_score")
	private Integer moveAwayStartingScore;
	
	@Column (name = "move_away_final_score")
	private Integer moveAwayFinalScore;
	
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