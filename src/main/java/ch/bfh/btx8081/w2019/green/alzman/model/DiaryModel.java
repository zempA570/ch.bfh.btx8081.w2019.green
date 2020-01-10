package ch.bfh.btx8081.w2019.green.alzman.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vaadin.flow.component.datepicker.DatePicker;

@Entity
@Table(name = "Diary")
public class DiaryModel {

	@Id
	// @GeneratedValue means the value of this variable will be generated in the
	// database by the "userIDGenerator"
	@GeneratedValue
	int id;

	LocalDate lcld;
	String author;
	String Entry;

	public void setId(int id) {
		this.id = id;
	}

	public DiaryModel() {

	}

	public DiaryModel(LocalDate date, String author, String entry) {
		this.lcld = date;
		this.author = author;
		this.Entry = entry;
	}

	public LocalDate getDate() {
		return lcld;
	}

	public void setDate(LocalDate date) {
		this.lcld = date;
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
		return author + " " + lcld + " " + Entry;
	}

	public int getId() {
		return id;
	}

}