package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Patient {
	@TableGenerator(name = "patientIDGenerator", allocationSize = 1, initialValue = 123456)
	@GeneratedValue(generator = "patientIDGenerator")
	@Id
	int id;
	String password;
	String firstname;
	String lastname;

	public Patient(int id, String password, String firstname, String lastname) {
		this.id = id;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Patient() {

	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
