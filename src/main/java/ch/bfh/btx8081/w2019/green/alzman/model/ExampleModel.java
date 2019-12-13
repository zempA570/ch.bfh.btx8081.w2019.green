package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExampleModel {

	
	String name;
	String nachname;
	int alter;
	
	//annotation for the primary key
	@Id
	@GeneratedValue
	int id;
	
	//generate an id by random
	
	
	
	
	public ExampleModel(String name, String nachname, int alter, int id) {
		super();
		this.name = name;
		this.nachname = nachname;
		this.alter = alter;
		this.id = id;
	}
	
	//must have: an empty constructor
	public ExampleModel() {};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
