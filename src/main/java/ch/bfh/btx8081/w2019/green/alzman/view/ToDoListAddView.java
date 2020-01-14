package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;

/**
 * 
 * @author Jasmitha Devarasa
 *
 */
public interface ToDoListAddView {

	interface ToDoListAddViewListener {
		void buttonClick(Button button);
	}
	
	
	public void addListener(ToDoListAddViewListener listener);

	// get Taskname
	public String getTask();

	// get the Repetition
	public String getRepetition();

	// get the date of the task
	public LocalDate getDate();
	
}
