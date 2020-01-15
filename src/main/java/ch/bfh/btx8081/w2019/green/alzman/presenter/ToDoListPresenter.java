package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListAddViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListView;

/**
 * 
 * @author Jasmitha
 *
 */
public class ToDoListPresenter implements ToDoListView.ToDoListViewListener {

	private ToDoListView view;
	private List<TaskModel> lstTasks;

	public ToDoListPresenter(ToDoListView view) {
		this.view = view;
		view.addListener(this);

		fillGuiWithTasks();
	}

	// delete the task
	public void deleteTask(Optional<String> optional) {

		int id = Integer.parseInt(optional.get());

		TaskModel taskToDelete = null;

		for (TaskModel task : lstTasks) {
			if (id == task.getId()) {
				taskToDelete = task;
			}
		}

		if (taskToDelete != null) {
			DbService.remove(taskToDelete);
		}

	}

	public void fillGuiWithTasks() {

		// clean the gui before adding tasks
		view.deleteAllTasksInGui();

		// get the data from DB
		lstTasks = DbService.getAllTasks();

		// tasknames in the correct list
		for (TaskModel task : lstTasks) {
			if (task.isDone()) {
				view.addComplTask(task);
			} else if (task.getRepetition().contentEquals("Weekly")) {
				view.addWeeklyTask(task);
			} else if (task.getRepetition().contentEquals("Monthly")) {
				view.addMonthlyTask(task);
			} else if (task.getRepetition().contentEquals("Annually")) {
				view.addAnnualTask(task);
			} else if (task.getRepetition().contentEquals("None")) {
				view.addSpecialTask(task);
			}
		}
	}

	//
	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add new Task":
			openTodoListAddView();
			break;
		// if the button has no text a delete button was pressed
		case "":
			deleteTask(button.getId());
			view.deleteAllTasksInGui();
			fillGuiWithTasks();
			break;
		case "Checkbox Clicked":
			changeStatus(button.getId());
			view.deleteAllTasksInGui();
			fillGuiWithTasks();
			break;
		default:
			// TODO
		}

	}

	/**
	 * 
	 * @param optional contains the ID of the task where the checkbox was clicked
	 */
	private void changeStatus(Optional<String> optional) {
		int id = Integer.parseInt(optional.get());
		TaskModel taskToUpdate = null;

		// get the corresponding task to the ID
		for (TaskModel task : lstTasks) {
			if (id == task.getId()) {
				taskToUpdate = task;
			}
		}

		if (taskToUpdate != null) {
			// change the status of the task to the opposite of what it was
			taskToUpdate.setDone(!taskToUpdate.isDone());
			DbService.update(taskToUpdate);
			view.deleteAllTasksInGui();
			fillGuiWithTasks();
		}
	}

	private void openTodoListAddView() {
		UI.getCurrent().navigate(ToDoListAddViewImpl.class);
	}

}
