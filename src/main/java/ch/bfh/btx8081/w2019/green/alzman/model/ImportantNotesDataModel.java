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
	 * datatypes for this model: string author for the user who makes the entry
	 * entryDate for the date of the newly entered entry entryContent for the actual
	 * entry which is a string
	 */
	String author;
	LocalDate entryDate;
	String entryContent;

	// annotation for the primary key and generating an ID by random
	@Id
	@GeneratedValue
	int entryID;

	public ImportantNotesDataModel(String author, LocalDate entryDate, String entryContent, int entryID) {
		super();
		this.author = author;
		this.entryDate = entryDate;
		this.entryContent = entryContent;
		this.entryID = entryID;
	}

	// must have: an empty constructor
	public ImportantNotesDataModel() {
	};

}
