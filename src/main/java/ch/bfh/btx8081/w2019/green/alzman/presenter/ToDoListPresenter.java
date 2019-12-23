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

public class ToDoListPresenter {

	private TaskEntryView view;

	private List<Task> taskslist;
	private List<Task> tasks; 

	public ToDoListPresenter(TaskEntryView view) {
		this.view = view;

	}

	public void addTaskToDB(String taskname, String choice, LocalDate LocalDate) {

		Date date = Date.valueOf(LocalDate);

		Task newTask = new Task(taskname, choice, date);

		DbService.em.getTransaction().begin();
		DbService.em.persist(newTask);
		DbService.em.getTransaction().commit();
	}

	public void deleteTask(String tasks) {

	}

	public void fillListwithTasks() {
		// get the data from DB
		Query query = DbService.em.createNativeQuery("SELECT * FROM task", Task.class);

		// get list of tasks out of the query
		taskslist = query.getResultList();

		// System.out.println(tasks.get(0).getTask());
		List<String> week = new ArrayList<String>();
		List<String> month = new ArrayList<String>();
		List<String> annually = new ArrayList<String>();
		List<String> special = new ArrayList<String>(); 

		
		//formateToChBox
		for(Task task : tasks) {
			Checkbox checkbox = new Checkbox();
			checkbox.setLabel(task.getTask());
		}
		
		// tasknames in the correct list
		for (Task task : taskslist) {
			if (task.getChoice().contentEquals("weekly")) {
				week.add(task.getTask());
			} else if (task.getChoice().contentEquals("monthly")) {
				month.add(task.getTask());
			} else if( task.getChoice().contentEquals("annually")){
				annually.add(task.getTask());
			}else {
				special.add(task.getTask()); 
			
			}
		}


//	Checkbox check = new Checkbox();
//	check.setLabel(task.getTask());	
//	tasknames.add(task.getTask());

	}


	// }

//	void addtoList(Task task) {
//		
//	}
	public void getInCheckbox(Task task) {
		Checkbox checkbox = new Checkbox();
		checkbox.setLabel(task.getTask());
//		
	}

}
