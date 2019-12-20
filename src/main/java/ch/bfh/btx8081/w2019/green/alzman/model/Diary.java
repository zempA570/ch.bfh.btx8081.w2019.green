package ch.bfh.btx8081.w2019.green.alzman.model;


import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.vaadin.flow.component.datepicker.DatePicker;


@Entity
public class Diary {
	
	@Id
	//@GeneratedValue means the value of this variable will be generated in the database by the "userIDGenerator"
	@GeneratedValue
	int id; 
	
	
	LocalDate date;
	String author;
	String Entry;
	

	
	public void setId(int id) {
		this.id = id;
	}
		
	
	public Diary() {
		
	}
	
	public Diary(LocalDate date, String author, String entry) {
		this.date= date ;
		this.author = author;
		this.Entry = entry;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getEntry() {
		return Entry;
	}


	public void setEntry(String entry) {
		Entry = entry;
	}

	public String getFullDiary() {
		return author + " " + date + " " + Entry;
	}

	public int getId() {
		return id;
	}
	
	

}

	

