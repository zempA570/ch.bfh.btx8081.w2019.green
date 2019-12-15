package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Time;
import java.time.LocalDate;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.timepicker.TimePicker;

@Entity
public class CalendarModel {
	
	@Id
	//@GeneratedValue means the value of this variable will be generated in the database by the "userIDGenerator"
	@GeneratedValue
	int id;
	
	LocalDate datePick;
	TimePicker appointTime;
	String author;
	String Entry;
	
	public CalendarModel(LocalDate datePick, TimePicker appointTime, String author, String Entry ) {
		this.datePick= datePick;
		this.appointTime=appointTime;
		this.author=author;
		this.Entry = Entry;
		
	}
	public CalendarModel() {
		
	}
	
	public void setDate(LocalDate datePick) {
		this.datePick= datePick;
	
	}
	
	public LocalDate getDate() {
		return datePick;
	}
	public void setTime(TimePicker appointTime) {
		this.appointTime= appointTime;
	
	}
	
	public TimePicker getTime() {
		return appointTime;
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
