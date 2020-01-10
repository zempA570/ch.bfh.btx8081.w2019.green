package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;

public interface NotesAddView {

	interface NotesAddListener {
		void buttonClick(Button btnClick);
	}

	public void addListener(NotesAddListener listener);

	public LocalDate getDate();

	public String getAuthor();

	public String getEntry();

}
