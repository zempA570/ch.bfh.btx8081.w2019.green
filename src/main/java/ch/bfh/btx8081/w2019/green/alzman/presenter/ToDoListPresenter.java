package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;

import javax.persistence.Query;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListView;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListViewImpl;

public class ToDoListPresenter implements ToDoListView.ToDoListViewListener {

	private ToDoListView view;
	private List<TaskModel> taskslist;

	public ToDoListPresenter(ToDoListView view) {
		this.view = view;
		view.addListener(this);

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


	@Override
	public void buttonClick(Button button) {
		// TODO Auto-generated method stub
		
	}
		

	}


