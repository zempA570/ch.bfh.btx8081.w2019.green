package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListAddView;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListViewImpl;

public class ToDoListAddPresenter implements ToDoListAddView.ToDoListAddViewListener {

	private ToDoListAddView view;
	private List<TaskModel> taskslist;

	public ToDoListAddPresenter(ToDoListAddView view) {
		this.view = view;
		view.addListener(this);
	}

	public void addTaskToDB() {
		
		String task = view.getTask();
		String repetition = view.getRepetition();
		LocalDate localdate = view.getDate();
		Date date = Date.valueOf(localdate);

		TaskModel newTask = new TaskModel(task, repetition, date);

		DbService.persist(newTask);
	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Save & Add":
			addTaskToDB();
			openToDoListView();
			break;
		default:
			break;
		}

	}

	private void openToDoListView() {
		UI.getCurrent().navigate(ToDoListViewImpl.class);
	}

}
