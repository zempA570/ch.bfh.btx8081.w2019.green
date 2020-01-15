package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesAddViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesView;

/**
 * This class acts as Presenter for the (Key-)Notes Functionality
 * 
 * @author Simon
 *
 */

public class NotesPresenter implements NotesView.NotesListener {

	private NotesView view;
	private List<NotesModel> lstKeyNotesList;

	public NotesPresenter(NotesView notesView) {
		view = notesView;
		view.addListener(this);

		fillTableWithNotes();
	}

	/**
	 * this method is called when a button is clicked
	 */
	@Override
	public void buttonClick(Button btnClickable) {
		String buttonDescrption = btnClickable.getText();

		switch (buttonDescrption) {
		case "Create New Entry":
			navigateToCreateView();
			break;
		case "Delete Selected Entry":
			deleteEntry();
			break;
		default:
			// TODO
			;
		}
	}

	/**
	 * deletes an Entry from the DB Table
	 */
	public void deleteEntry() {
		Set<NotesModel> notes = view.getSelectedNote();
		NotesModel noteToDelete = notes.stream().findFirst().get();

		DbService.remove(noteToDelete);

		fillTableWithNotes();
	}

	/**
	 * fills the Table for this Functionality with Entries from the DB 
	 */
	public void fillTableWithNotes() {

		lstKeyNotesList = DbService.getAllNotes();
		view.fillGridWithEntries(lstKeyNotesList);

	}

	/**
	 * navigates to the view where you can add new notes
	 */
	private void navigateToCreateView() {
		UI.getCurrent().navigate(NotesAddViewImpl.class);
	}

}
