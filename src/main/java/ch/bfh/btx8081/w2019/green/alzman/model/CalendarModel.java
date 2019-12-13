package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Time;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CalendarModel {
	
	@Id
	//@GeneratedValue means the value of this variable will be generated in the database by the "userIDGenerator"
	@GeneratedValue
	int id;
	
	Date date;
	Time time;
	String Entry;
	
	public CalendarModel(Date date,Time time, String Entry ) {
		this.date =date;
		this.time = time;
		this.Entry = Entry;
		
	}
	public CalendarModel() {
		
	}
	
	public void setDate(Date date) {
		this.date= date;
	
	}
	
	public Date getDate() {
		return date;
	}

	public Time setTime(Time time) {
		return this.time = time;
	
	}
	public Time getTime() {
		return time;
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
