package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;

public interface ToDoListAddView {

	interface ToDoListAddViewListener {
		void buttonClick(Button button);
	}
	
	public void addListener(ToDoListAddViewListener listener);

	public String getTask();

	public String getRepetition();

	public LocalDate getDate();
	
}
