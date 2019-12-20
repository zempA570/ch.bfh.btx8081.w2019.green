package ch.bfh.btx8081.w2019.green.alzman.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.ui.DateField;

@Entity
public class ImportantNotesDataModel {

	/**
	 * datatypes for this model:
	 * string author for the user who makes the entry
	 * entryDate for the date of the newly entered entry
	 * entryContent for the actual entry which is a string
	 */
	String author;
	LocalDate entryDate;
	String entryContent;
	
	
	//annotation for the primary key and generating an ID by random
	@Id
	@GeneratedValue
	int entryID;
	
	
	
	
	
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryContent() {
		return entryContent;
	}

	public void setEntryContent(String entryContent) {
		this.entryContent = entryContent;
	}

	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public ImportantNotesDataModel(String author, LocalDate entryDate, String entryContent, int entryID) {
		super();
		this.author = author;
		this.entryDate = entryDate;
		this.entryContent = entryContent;
		this.entryID = entryID;
	}
	
	//must have: an empty constructor
	public ImportantNotesDataModel() {};
	
	
}
