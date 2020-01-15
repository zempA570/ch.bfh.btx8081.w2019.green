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
 * @author Jasmitha Devarasa
 *
 */
public class ToDoListPresenter implements ToDoListView.ToDoListViewListener {

	private ToDoListView view;
	private List<TaskModel> taskslist;

	public ToDoListPresenter(ToDoListView view) {
		this.view = view;
		view.addListener(this);

		fillGuiWithTasks();
	}

	// delete the task
	public void deleteTask(Optional<String> optional) {

		int id = Integer.parseInt(optional.get());

		TaskModel taskToDelete = null;

		for (TaskModel task : taskslist) {
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
		taskslist = DbService.getAllTasks();

		// tasknames in the correct list
		for (TaskModel task : taskslist) {
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

	
	private void changeStatus(Optional<String> optional) {

		int id = Integer.parseInt(optional.get());

		TaskModel taskToUpdate = null;

		for (TaskModel task : taskslist) {
			if (id == task.getId()) {
				taskToUpdate = task;
			}
		}

		if (taskToUpdate != null) {
			
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
