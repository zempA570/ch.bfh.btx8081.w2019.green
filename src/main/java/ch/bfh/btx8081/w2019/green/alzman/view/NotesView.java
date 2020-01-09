package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.ImportantNotesDataModel;

public interface NotesView {

	interface NotesListener {
		void buttonClick(Button button);
	}

	public void addListener(NotesListener listener);

	public void fillGridWithEntries(List<ImportantNotesDataModel> notes);
	
	public Set<ImportantNotesDataModel> getSelectedNote();
	
}
