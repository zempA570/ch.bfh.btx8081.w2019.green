package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;

import java.util.Set;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;

/**
 * This interface is being used by the NotesView class
 * @author simon
 *
 */

public interface NotesView {

	interface NotesListener {
		void buttonClick(Button btnClick);
	}

	public void addListener(NotesListener listener);

	public void fillGridWithEntries(List<NotesModel> lstNotesList);
	
	public Set<NotesModel> getSelectedNote();
	
}
