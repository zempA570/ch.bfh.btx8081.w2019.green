package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment")
public class AppointmentModel {

	@Id
	// @GeneratedValue means the value of this variable will be generated in the
	// database by the "userIDGenerator"
	@GeneratedValue
	int id;

	Date date;
	Time time;
	String author;
	String entry;

	public AppointmentModel(Date date, Time time, String author, String entry) {
		this.date = date;
		this.time = time;
		this.author = author;
		this.entry = entry;

	}

	public AppointmentModel() {

	}

	public void setDate(Date date) {
		this.date = date;

	}

	public Date getDate() {
		return date;
	}

	public void setTime(Time time) {
		this.time = time;

	}

	public Time getTime() {
		return time;
	}

	public String setAuthor(String author) {
		return this.author = author;

	}

	public String getAuthor() {
		return author;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getEntry() {
		return entry;
	}

	public int getId() {
		return id;
	}

}
