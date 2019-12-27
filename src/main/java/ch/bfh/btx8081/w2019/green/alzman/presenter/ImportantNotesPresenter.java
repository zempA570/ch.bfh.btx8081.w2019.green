package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.ImportantNotesDataModel;
import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.AddImportantNotes;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesView;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView;

/**
 * 
 * @author Simon
 *
 */
public class ImportantNotesPresenter {


	private AddImportantNotes keyNotesView;
	private List<ImportantNotesDataModel> keyNotes;

	// constructor for the presenter
	public ImportantNotesPresenter(AddImportantNotes notesToView) {
		this.keyNotesView = notesToView;

	}
	
	public void deleteEntry(String importantEntry){
		
		DbService.em.getTransaction().begin();
		
		//get the ID from the Entry which is at the beginning of the importantEntry String
		int entryID = Integer.parseInt(importantEntry.substring(0, importantEntry.indexOf(" ")));
		
		ImportantNotesDataModel entryToDelete = null;
		
		// for every Entry in the List
		for (ImportantNotesDataModel anEntry : keyNotes ) {
			// checks if the ID of the Entry is equal to the ID from the String
			if (Objects.equals(anEntry.getEntryID(), entryID)) {
				// delete this entry
				entryToDelete = anEntry;
			};
		}
		
		//removing the Entry from the Database
		DbService.em.remove(entryToDelete);
		DbService.em.getTransaction().commit();
		
		// after the entry is deleted we update the list in the combobox
		
	}
	
	private void addEntries(String author, String content, Date date) {
		
		//Create a new entry
		
		ImportantNotesDataModel newEntry = new ImportantNotesDataModel(author, content, date);
		
		//sync with Database
		DbService.em.getTransaction().begin();
		DbService.em.persist(newEntry);
		DbService.em.getTransaction().commit();
		
	};
	
	









}
