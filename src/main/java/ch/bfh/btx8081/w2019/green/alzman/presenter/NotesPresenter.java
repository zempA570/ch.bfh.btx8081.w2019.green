package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.model.ImportantNotesDataModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesView;

public class NotesPresenter {

	private NotesView view;
	private List<ImportantNotesDataModel> notes;
	

	public NotesPresenter(NotesView notesView) {
		view = notesView;

		fillTableWithNotes();
		
	}

	public void fillTableWithNotes() {

		if (notes == null) {

			// DB transactions where we get all the notes
			Query query = DbService.em.createNativeQuery("SELECT * FROM importantnotesdatamodel", ImportantNotesDataModel.class);

			// get list of notes out of the query
			notes = query.getResultList();

			view.fillGridWithEntries(notes);

		}
	}


	public void deleteEntry(Set<ImportantNotesDataModel> notesToDelete) {

		ImportantNotesDataModel test = notes.stream().findFirst().get();
		test.getEntryID();

		DbService.em.getTransaction().begin();

		// get the id number of the entry which is at the beginning of the string
		int entryID = test.getEntryID();
		;

		ImportantNotesDataModel noteToDelete = null;

		// for every user we have in our list
		for (ImportantNotesDataModel noteIn : notes) {
			// if the id of that entry is equal to the id we got from the entryID
			if (Objects.equals(noteIn.getEntryID(), entryID)) {
				// this is the user we want to delete
				noteToDelete = noteIn;
			}
		}

		// this is the part where we use the DB
		DbService.em.remove(noteToDelete);
		DbService.em.getTransaction().commit();

		fillTableWithNotes();

		DbService.em.close();

	}

	
}
