package com.event_app.data_services.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long event_id;
	private Long customer_id;
	private Date registration_date;
	private String notes;
	
	public Registration(Long id, Long event_id, Long customer_id, Date registration_date, String notes) {
		this.id = id;
		this.event_id = event_id;
		this.customer_id = customer_id;
		this.registration_date = registration_date;
		this.notes = notes;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the event_id
	 */
	public Long getEvent_id() {
		return event_id;
	}
	/**
	 * @param event_id the event_id to set
	 */
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	/**
	 * @return the customer_id
	 */
	public Long getCustomer_id() {
		return customer_id;
	}
	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	/**
	 * @return the registration_date
	 */
	public Date getRegistration_date() {
		return registration_date;
	}
	/**
	 * @param registration_date the registration_date to set
	 */
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Registration{" +
				"id=" + id +
				", event_id=" + event_id +
				", customer_id=" + customer_id +
				", registration_date=" + registration_date +
				", notes='" + notes + '\'' +
				'}';
	}
}
