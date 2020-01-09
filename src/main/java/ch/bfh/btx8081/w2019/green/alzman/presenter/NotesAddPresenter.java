package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.ImportantNotesDataModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesAddView;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesViewImpl;

/**
 * 
 * @author Simon
 *
 */
public class NotesAddPresenter implements NotesAddView.NotesAddListener {

	private NotesAddView view;
	private List<ImportantNotesDataModel> keyNotes;

	// constructor for the presenter
	public NotesAddPresenter(NotesAddView notesAddView) {
		view = notesAddView;
		view.addListener(this);

	}

	private void addNotesDB() {

		String author = view.getAuthor();
		String content = view.getEntry();
		LocalDate localdate = view.getDate();

		Date date = Date.valueOf(localdate);

		ImportantNotesDataModel noteToSave = new ImportantNotesDataModel(author, content, date);

		// method to add a note to the Database
		DbService.persist(noteToSave);

	}
	
	private void navigateToNotesView() {
		UI.getCurrent().navigate(NotesViewImpl.class);
	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add to Key-Notes":
			addNotesDB();
			navigateToNotesView();
			break;
		default:
			// TODO
			;
		}

	}

}
