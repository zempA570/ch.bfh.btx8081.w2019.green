package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.time.LocalDate;

import ch.bfh.btx8081.w2019.green.alzman.model.Task;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.TaskEntryView;

public class ToDoListPresenter {
	
	private TaskEntryView view;
	
	public ToDoListPresenter(TaskEntryView view) {
		this.view = view;
	}
	
	public void addTaskToDB(String task, String choice, LocalDate date) {
		
		Task newTask = new Task(task, choice, date);
		
		DbService.em.getTransaction().begin();
		DbService.em.persist(newTask);
		DbService.em.getTransaction().commit();
		
	}
	
}
