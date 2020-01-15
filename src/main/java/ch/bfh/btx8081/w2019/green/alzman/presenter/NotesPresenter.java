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
 * @author simon
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

	@Override
	/**
	 * creates clickable buttons to create or delete an entry or to refresh the page
	 */
	public void buttonClick(Button btnClickable) {
		String buttonDescrption = btnClickable.getText();

		switch (buttonDescrption) {
		case "Create New Entry":
			navigateToCreateView();
			break;
		case "Delete Selected entry":
			deleteEntry();
			break;
		case "Refresh":
			fillTableWithNotes();
			reloadPage();
			System.out.println("jo klappt");
			break;
		default:
			// TODO
			;
		}
	}

	/**
	 * deletes an Entry from the respective DB Table
	 */
	public void deleteEntry() {

		Set<NotesModel> notes = view.getSelectedNote();
		NotesModel noteToDelete = notes.stream().findFirst().get();

		DbService.remove(noteToDelete);

		fillTableWithNotes();
	}

	/**
	 * fills the Table from the DB for this Functionality with Entries
	 */
	public void fillTableWithNotes() {

		lstKeyNotesList = DbService.getAllNotes();
		view.fillGridWithEntries(lstKeyNotesList);

	}

	/**
	 * reloads the current page
	 */
	private void reloadPage() {
		UI.getCurrent().getPage().reload();

	}

	/**
	 * navigates back to the previous view
	 */
	private void navigateToCreateView() {
		UI.getCurrent().navigate(NotesAddViewImpl.class);
	}

}
