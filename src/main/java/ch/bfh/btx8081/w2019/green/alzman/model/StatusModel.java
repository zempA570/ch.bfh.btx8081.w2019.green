package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ch.bfh.btx8081.w2019.green.alzman.services.DbService;

@Entity
@Table(name = "Status")
public class StatusModel {

	// String dependend;
	@Id
	@GeneratedValue
	int id;
	int level;
	String task;

	
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

	public String Gettask() {
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