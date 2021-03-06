package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;

/**
 * 
 * @author Jasmitha
 *
 */
public interface ToDoListView {

	interface ToDoListViewListener {
		void buttonClick(Button button);
	}

	// add different kinds of task
	public void addListener(ToDoListViewListener listener);

	public void deleteAllTasksInGui();

	public void addWeeklyTask(TaskModel task);

	public void addAnnualTask(TaskModel task);

	public void addSpecialTask(TaskModel task);

	public void addComplTask(TaskModel task);

	public void addMonthlyTask(TaskModel task);

}
