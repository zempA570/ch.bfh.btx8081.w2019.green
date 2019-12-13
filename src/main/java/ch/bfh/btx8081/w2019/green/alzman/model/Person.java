package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Person")
public class Person {
	
	@TableGenerator(name = "PersonID", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "PersonID")
	int id;
	
	String name;
	String adress;
	
	
	public Person(String name, String adress) {
		super();
		this.name = name;
		this.adress = adress;
	}
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
