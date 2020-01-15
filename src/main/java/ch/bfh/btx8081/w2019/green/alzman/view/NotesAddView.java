package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;

/**
 * this interface is being used by the NotesAddViewImpl class
 * 
 * @author Simon
 *
 */

public interface NotesAddView {

	interface NotesAddListener {
		void addToKeyNotes(Button btnClick);
	}

	public void addListener(NotesAddListener listener);

	public String getAuthor();

	public LocalDate getDate();

	public String getEntry();

}
