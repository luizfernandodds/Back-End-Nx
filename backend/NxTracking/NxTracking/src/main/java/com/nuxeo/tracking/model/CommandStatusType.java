package com.nuxeo.tracking.model;

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
@Table(name = "command_status_type")
public class CommandStatusType {

	@Id
	@SequenceGenerator(name = "pk_command_status_type_sequence", sequenceName = "command_status_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_command_status_type_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	public static final long COMMAND_STATUS_TYPE_SEND = 1;

	/** Command has sent to device: 2 */
	public static final long COMMAND_STATUS_TYPE_SENDING = 2;

	/** Command was accept by the device: 3 */
	public static final long COMMAND_STATUS_TYPE_SENT = 3;

	/** Command was canceled by user: 4 */
	public static final long COMMAND_STATUS_TYPE_CANCEL = 4;

	/** Time to send the command was expired: 5 */
	public static final long COMMAND_STATUS_TYPE_EXPIRED = 5;

	/** Number of attempts to send the command was reached: 6 */
	public static final long COMMAND_STATUS_TYPE_ATTEMPTS_REACHED = 6;

	/** The server send timeout because the device didn't answer: 7 */
	public static final long COMMAND_STATUS_TYPE_TIMEOUT = 7;

	/** The device send a not acknowledgment for the command: 8 */
	public static final long COMMAND_STATUS_TYPE_NACK = 8;

	@Column(name = "i18n")
	private String i18n;

	@Column(name = "name")
	private String name;

	public CommandStatusType() {
	}
}