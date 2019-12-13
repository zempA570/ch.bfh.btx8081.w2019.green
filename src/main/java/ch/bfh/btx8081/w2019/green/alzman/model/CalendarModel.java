package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Time;
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
	
	DatePicker date;
	TimePicker time;
	String author;
	String Entry;
	
	public CalendarModel(DatePicker date,TimePicker time, String author, String Entry ) {
		this.date =date;
		this.time=time;
		this.author=author;
		this.Entry = Entry;
		
	}
	public CalendarModel() {
		
	}
	
	public void setDate(DatePicker date) {
		this.date= date;
	
	}
	
	public DatePicker getDate() {
		return date;
	}
	public void setTime(TimePicker time) {
		this.time= time;
	
	}
	
	public TimePicker getTime() {
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
