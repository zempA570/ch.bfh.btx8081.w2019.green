package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.time.LocalDate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesAddView;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesViewImpl;

/**
 * This class acts as a presenter for the Add-Notes-Functionality
 * 
 * @author Simon
 *
 */
public class NotesAddPresenter implements NotesAddView.NotesAddListener {

	private NotesAddView view;

	public NotesAddPresenter(NotesAddView notesAddView) {
		view = notesAddView;
		view.addListener(this);
	}

	/**
	 * this method is called when a button is clicked
	 */
	@Override
	public void addToKeyNotes(Button btnAddTo) {

		String buttonDescription = btnAddTo.getText();

		switch (buttonDescription) {
		case "Add to Key-Notes":
			addNotesDB();
			navigateToNotesView();
			break;
		default:
			// TODO
			;
		}

	}

	/**
	 * adds notes to the DB Table
	 */
	private void addNotesDB() {
		String author = view.getAuthor();
		String content = view.getEntry();
		LocalDate lcldDateOfEntry = view.getDate();

		Date date = Date.valueOf(lcldDateOfEntry);

		NotesModel noteToSave = new NotesModel(author, content, date);
		DbService.persist(noteToSave);
	}

	/**
	 * navigates back to the overview of all notes
	 */
	private void navigateToNotesView() {
		UI.getCurrent().navigate(NotesViewImpl.class);
	}

}
