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

public class StatusModel {
	
	
	public StatusModel(String dependend, String independend, String withHelp, int id) {
		this.dependend = dependend;
		this.independend = independend;
		this.withHelp = withHelp;
		this.id = id;
	}
	public StatusModel() {
		
	}
	
	String dependend;
	String independend;
	String withHelp;
	int id;
	
	@Id
	@GeneratedValue
	
	private String getDependend() {
		return dependend;
	}
	private void setDependend(String dependend) {
		this.dependend = dependend;
	}
	private String getIndependend() {
		return independend;
	}
	private void setIndependend(String independend) {
		this.independend = independend;
	}
	private String getWithHelp() {
		return withHelp;
	}
	private void setWithHelp(String withHelp) {
		this.withHelp = withHelp;
	}
	private int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}

}
