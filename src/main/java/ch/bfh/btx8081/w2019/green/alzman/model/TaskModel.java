package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is used to store new tasks of patients.
 * 
 * @author Jasmitha Devarasa
 *
 */
@Entity
@Table(name = "Task")
public class TaskModel {

	@Id
	@GeneratedValue
	int id;

	// Other variables
	String task;
	String repetition;
	Date date;
	Boolean isDone = false;

	/**
	 * 
	 * @param task describe the name of the task
	 * @param repetition describe how often it will be repeated, can be chosen between daily, weekly and annually or none
	 * @param date 
	 */
	public TaskModel(String task, String repetition, Date date) {
		this.task = task;
		this.repetition = repetition;
		this.date = date;
	}

	// No-Args constructor is required by JPA
	public TaskModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getRepetition() {
		return repetition;
	}

	public void setRepetition(String choice) {
		this.repetition = choice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public void setDone(boolean status) {
		this.isDone = status;
	}

}