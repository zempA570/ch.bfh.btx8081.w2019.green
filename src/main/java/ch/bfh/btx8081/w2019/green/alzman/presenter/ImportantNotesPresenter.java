package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	private NotesView view;
	private AddImportantNotes keyNotesView;
	private List<ImportantNotesDataModel> keyNotes;

	// constructor for the presenter
	public ImportantNotesPresenter(NotesView notesToView) {
		this.view = notesToView;

		fillComboboxWithNotes();

	}

	


	private void fillComboboxWithNotes() {

		// DB stuff where we get all the users
		Query queryNotes = DbService.em.createNativeQuery("SELECT * FROM importantnotesdatamodel", ImportantNotesDataModel.class);

		// get list of users out of the query
		keyNotes = queryNotes.getResultList();

		List<String> entryNotes = new ArrayList<String>();
		
		// for every user in our list
		for (ImportantNotesDataModel note : keyNotes) {
			// we add the id and fullname of that user to our List<String>
			entryNotes.add(note.getEntryID() + " " + note.getAuthor() + " " + note.getContent() +  " " + note.getDate());
		}

		// then we tell the view to fill the combobox with the List<String>
		// view.fillComboboxWithNotes(entryNotes);

//		TODO message to user that was deleted?

	}

}
