package ch.bfh.btx8081.w2019.green.alzman.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Mootaas
 * 
 *         In this class the getter and setter method will be created
 *
 */
@Entity
@Table(name = "Diary")
public class DiaryModel {

	@Id
	@GeneratedValue
	int id;
	LocalDate date;
	String author;
	String entry;

	public DiaryModel() {

	}

	public DiaryModel(LocalDate date, String author, String entry) {
		this.date = date;
		this.author = author;
		this.entry = entry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getFullDiary() {
		return author + " " + date + " " + entry;
	}

}