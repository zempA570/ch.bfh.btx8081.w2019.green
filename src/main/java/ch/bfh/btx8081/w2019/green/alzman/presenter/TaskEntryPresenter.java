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

public class TaskEntryPresenter {

	private TaskEntryView view;

	private List<TaskModel> taskslist;
	private List<TaskModel> tasks; 

	public TaskEntryPresenter(TaskEntryView view) {
		this.view = view;

	}

	public void addTaskToDB(String taskname, String choice, LocalDate LocalDate) {

		Date date = Date.valueOf(LocalDate);

		TaskModel newTask = new TaskModel(taskname, choice, date);

		DbService.em.getTransaction().begin();
		DbService.em.persist(newTask);
		DbService.em.getTransaction().commit();
	}

	public void deleteTask(String tasks) {

	}

//	public void fillListwithTasks() {
//		// get the data from DB
//		Query query = DbService.em.createNativeQuery("SELECT * FROM task", Task.class);
//
//		// get list of tasks out of the query
//		taskslist = query.getResultList();
//
//		// System.out.println(tasks.get(0).getTask());
//		List<String> week = new ArrayList<String>();
//		List<String> month = new ArrayList<String>();
//		List<String> annually = new ArrayList<String>();
//		List<String> special = new ArrayList<String>(); 

			

		}

	


