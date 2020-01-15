package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the model of the status function.
 * 
 * @author Emily Estée
 *
 */

@Entity
@Table(name = "Status")
public class StatusModel {

	@Id
	@GeneratedValue
	int id;
	int level;
	String task;

	/**
	 * 
	 * @param level 1 = "Independent"; 2 = "With help"; 3 = "Dependent"
	 * @param task  The user's entry, e.g. "Wash Hair"
	 * @param id    The Identification Number
	 */
	public StatusModel(int level, String task, int id) {
		this.level = level;
		this.task = task;
		this.id = id;
	}

	public StatusModel(int level, String task) {
		this.level = level;
		this.task = task;
	}

	public StatusModel() {

	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}