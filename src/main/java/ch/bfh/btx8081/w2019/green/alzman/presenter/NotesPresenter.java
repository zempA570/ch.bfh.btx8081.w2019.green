package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesAddViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesView;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesViewImpl;

public class NotesPresenter implements NotesView.NotesListener {

	private NotesView view;
	private List<NotesModel> notes;

	public NotesPresenter(NotesView notesView) {
		view = notesView;
		view.addListener(this);

		fillTableWithNotes();

	}

	public void fillTableWithNotes() {

		// DB transactions where we get all the notes
		Query query = DbService.em.createNativeQuery("SELECT * FROM importantnotesdatamodel",
				NotesModel.class);

		// get list of notes out of the query
		notes = query.getResultList();

		view.fillGridWithEntries(notes);

	}

	public void deleteEntry() {
		
		Set<NotesModel> notes = view.getSelectedNote();
		NotesModel noteToDelete = notes.stream().findFirst().get();

		DbService.em.getTransaction().begin();

//		// get the id number of the entry which is at the beginning of the string
//		int entryID = notetoDelete.getEntryID();
//
//		ImportantNotesDataModel noteToDelete = null;
//
//		// for every user we have in our list
//		for (ImportantNotesDataModel noteIn : notes) {
//			// if the id of that entry is equal to the id we got from the entryID
//			if (Objects.equals(noteIn.getEntryID(), entryID)) {
//				// this is the user we want to delete
//				noteToDelete = noteIn;
//			}
//		}

		// this is the part where we use the DB
		DbService.em.remove(noteToDelete);
		DbService.em.getTransaction().commit();

		fillTableWithNotes();

		DbService.em.close();

	}

	@Override
	public void buttonClick(Button button) {
		String buttonText = button.getText();

		switch (buttonText) {
		case "Create New entry":
			navigateToCreateView();
			break;
		case "Delete Selected entry":
			deleteEntry();
			break;
		case "Refresh":
			fillTableWithNotes();
			System.out.println("jo klappt");
			break;
		default:
			// TODO
			;
		}
	}

	private void navigateToCreateView() {
		UI.getCurrent().navigate(NotesAddViewImpl.class);
	}

}
