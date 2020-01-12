package ch.bfh.btx8081.w2019.green.alzman.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.vaadin.flow.component.datepicker.DatePicker;

import ch.bfh.btx8081.w2019.green.alzman.services.DbService;

/**
 * This class is used to store new tasks of patients.
 * 
 * @author Jasmitha
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