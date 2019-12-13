package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Person")
public class Person {
	
	@TableGenerator(name = "ImportantPersonIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "ImportantPersonIDGenerator")
	int id;

	String gender;
	String firstname;
	
	
	public Person(int id, String gender, String firstname) {
		super();
		this.id = id;
		this.gender = gender;
		this.firstname = firstname;
	}
	public Person() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	
	

}
