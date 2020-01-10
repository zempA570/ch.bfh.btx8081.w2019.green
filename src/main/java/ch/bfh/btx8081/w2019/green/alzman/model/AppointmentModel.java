package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Time;
import java.time.LocalDate;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.timepicker.TimePicker;

@Entity
@Table(name = "Appointment")
public class AppointmentModel {
	
	@Id
	//@GeneratedValue means the value of this variable will be generated in the database by the "userIDGenerator"
	@GeneratedValue
	int id;
	
	Date datePick;
	Time time;
	String author;
	String Entry;
	
	public AppointmentModel(Date datePick, Time time, String author, String Entry ) {
		this.datePick= datePick;
		this.time=time;
		this.author=author;
		this.Entry = Entry;
		
	}
	public AppointmentModel() {
		
	}
	
	public void setDate(Date datePick) {
		this.datePick= datePick;
	
	}
	
	public Date getDate() {
		return datePick;
	}
	public void setTime(Time time) {
		this.time= time;
	
	}
	
	public Time getTime() {
		return time;
	}

	public String setAuthor(String author) {
	return this.author= author;
	
	}
	public String getAuthor() {
		return author;
	}
	
	public void setEntry(String Entry) {
		this.Entry =Entry;
	}
	public String getEntry() {
		return Entry;
	}
	
	public int getId() {
		return id;
	}

	

}
