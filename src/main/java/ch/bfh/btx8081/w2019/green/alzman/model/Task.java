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
 * This class is used to store new tasks of
 * patients.
 * 
 * @author Jasmitha
 *
 */
//@Entity means this class should be a table in the database
//@Table(name = ..) sets the name for the table. The table name "User" is not allowed so we have to change it.
//normally this doesn't have to be set, the class name will be used as table name.
@Entity
public class Task {

	// @TableGenerator creates a generator with the chosen name, value etc.
	// @Id mean this variable is the primary key in the table
	// @GeneratedValue means the value of this variable will be generated in the
	// database by the "userIDGenerator"
	@Id
	@GeneratedValue
	int id;

	// Other variables
	String taskname;
	String choice;
	Date date; 


	// Constructor to create Users in code


	// No-Args constructor is required by JPA
	
		
	public Task(String taskname, String choice, Date date) {
		this.taskname = taskname;
		this.choice = choice;
		this.date = date;
	}
	

	public Task() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return taskname;
	}

	public void setTask(String taskname) {
		this.taskname = taskname;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}