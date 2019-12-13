package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.vaadin.flow.component.datepicker.DatePicker;


@Entity
public class DiaryModel {
	
	@Id
	//@GeneratedValue means the value of this variable will be generated in the database by the "userIDGenerator"
	@GeneratedValue
	int id;
	
	DatePicker date;
	String author;
	String Entry;
	
	public void setId(int id) {
		this.id = id;
	}
		
	
	public DiaryModel() {
		
	}
	
	public DiaryModel(int id, DatePicker date, String author, String entry) {
		this.id = id;
		this.date = date;
		this.author = author;
		Entry = entry;
	}
	
	
	public void setDate(DatePicker date) {
		this.date= date;
	
	}
	
	public DatePicker getDate() {
		return date;
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

	

