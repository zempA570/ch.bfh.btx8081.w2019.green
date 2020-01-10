package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.TaskEntryView;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListView;

public class ToDoListPresenter {

	private ToDoListView view;
	private List<TaskModel> taskslist;

	public ToDoListPresenter(ToDoListView view) {
		this.view = view;

		fillListwithTasks();
	}


	public void deleteTask(TaskModel task) {
		DbService.em.getTransaction().begin();
		DbService.em.remove(task);
		DbService.em.getTransaction().commit();
		
		view.deleteAllTaskinGui(); 
		fillListwithTasks(); 
		
	}

	public void fillListwithTasks() {
		// get the data from DB
		Query query = DbService.em.createNativeQuery("SELECT * FROM task", TaskModel.class);

		// get list of tasks out of the query
		taskslist = query.getResultList();

		// tasknames in the correct list
		for (TaskModel task : taskslist) {
			if (task.getChoice().contentEquals("Weekly")) {
				view.addWeeklyTask(task);
			} else if (task.getChoice().contentEquals("Monthly")) {
				view.addMonthlyTask(task);
			} else if (task.getChoice().contentEquals("Annually")) {
				view.addAnnualTask(task);
			} else if (task.getChoice().contentEquals("None")){
			 view.addSpecialTask(task);}
			else {
				view.addComplTask(task);
			}
			}
			}
		

	}


