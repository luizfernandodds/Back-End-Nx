package com.nuxeo.tracking.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "maintenance")
public class Maintenance {

	@Id
	@SequenceGenerator(name = "pk_gris_sequence", sequenceName = "gris_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_gris_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "name")
	private String name;

	@Column(name = "mai_analysis", columnDefinition = "BIT", length = 4, nullable = false)
	private int analysis;

	@Column(name = "mai_value", nullable = false)
	private Long value;

	@Column(name = "mai_time")
	private Integer time;

	@Column(name = "mai_description", columnDefinition = "TEXT")
	private String description;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "maintenance_target", joinColumns = { @JoinColumn(name = "mat_mai_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "mat_tag_id") })
//	private Set<Target> targets;

	@OneToMany(mappedBy = "maintenance")
	private Set<MaintenanceDone> dones;

	@ManyToOne
	@JoinColumn(name = "id_maintenance_type")
	private MaintenanceType maintenanceType;
	
	@Column(name = "monetary_value")
	private Double monetaryValue;
	
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
	
	
	public static enum Analysis {
		ANALYSIS_ODOMETER(1, "maintenance_admin_unit_odometer", "Kms"), ANALYSIS_HOURMETER(2,
				"maintenance_admin_unit_hourmeter", "Hs"), ANALYSIS_MONTHS(3, "maintenance_admin_unit_month", "Ms");
		private int value;
		private String i18n;
		private String unit;

		Analysis(int value, String i18n, String unit) {
			this.value = value;
			this.i18n = i18n;
			this.unit = unit;
		}

		public int getCode() {
			return this.value;
		}

		public String getI18n() {
			return this.i18n;
		}

		public String getUnit() {
			return this.unit;
		}

		public static Analysis getByCode(int value) {
			for (Analysis analysis : Analysis.values()) {
				if (analysis.getCode() == value)
					return analysis;
			}
			return null;
		}
	}
}