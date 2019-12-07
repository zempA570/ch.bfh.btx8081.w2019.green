package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Relative {

	/* Liste der Parameter */
	@TableGenerator(name = "userIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "userIDGenerator")
	int id;
	String lastname;
	String firstname;

	public Relative(String lastname, String firstname) {
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public Relative() {

	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String name) {
		this.lastname = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}

}
