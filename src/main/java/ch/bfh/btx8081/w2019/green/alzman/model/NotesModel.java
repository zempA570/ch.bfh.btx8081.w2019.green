package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class models the data which is being used in the Key-Notes Function It
 * features some variables and their respective getters and setters
 * 
 * @author simon
 *
 */
@Entity
@Table(name = "Notes")
public class NotesModel {

	@Id
	@GeneratedValue
	int entryID;
	String author;
	String content;
	Date date;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
