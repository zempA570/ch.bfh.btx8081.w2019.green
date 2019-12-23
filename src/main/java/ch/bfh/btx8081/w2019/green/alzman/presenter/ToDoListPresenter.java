package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;

import ch.bfh.btx8081.w2019.green.alzman.model.Task;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.TaskEntryView;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListView;

public class ToDoListPresenter {

	private ToDoListView view;
	private List<Task> taskslist;

	public ToDoListPresenter(ToDoListView view) {
		this.view = view;

		fillListwithTasks();
	}


	public void deleteTask(Task task) {

	}

	public void fillListwithTasks() {
		// get the data from DB
		Query query = DbService.em.createNativeQuery("SELECT * FROM task", Task.class);

		// get list of tasks out of the query
		taskslist = query.getResultList();

		// tasknames in the correct list
		for (Task task : taskslist) {
			if (task.getChoice().contentEquals("Weekly")) {
				view.addWeeklyTask(task);
			} else if (task.getChoice().contentEquals("Monthly")) {
				view.addMonthlyTask(task);
			} else if (task.getChoice().contentEquals("Annually")) {
				view.addAnnualTask(task);
			} else 
			{ view.addSpecialTask(task);
			}
		}

	}

}
