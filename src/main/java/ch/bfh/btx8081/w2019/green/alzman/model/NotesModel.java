package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.ui.DateField;

@Entity
@Table(name = "Notes")
public class NotesModel {

	/**
	 * datatypes for this model: string author for the user who makes the entry
	 * entryDate for the date of the newly entered entry entryContent for the actual
	 * entry which is a string
	 */
	@Id
	@GeneratedValue
	int entryID;

	String author;
	Date date;
	String content;

	public NotesModel(String author, String content, Date date) {
		this.author = author;
		this.content = content;
		this.date = date;

	}

//must have: an empty constructor
	public NotesModel() {

	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public String getFullEntryDetails() {
		return author + " " + date + " " + content;
	}

}
