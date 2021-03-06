package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * This class is used to store information about the users/relatives of patients.
 * 
 * @author Adrian
 *
 */
//@Entity means this class should be a table in the database
//@Table(name = ..) sets the name for the table. The table name "User" is not allowed so we have to change it.
//Normally this doesn't have to be set and the class name is used as table name.
@Entity
@Table(name = "Relative")
public class UserModel {

	//@TableGenerator creates a generator with the chosen name, value etc.
	//@Id mean this variable is the primary key in the table
	//@GeneratedValue means the value of this variable will be generated in the database by the "userIDGenerator"
	@TableGenerator(name = "userIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "userIDGenerator")
	int id;
	
	//Other variables
	String lastname;
	String firstname;

	// Constructor to create Users in code
	public UserModel(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	// No-Args constructor is required by JPA
	public UserModel() {
		
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setLastname(String name) {
		this.lastname = name;
	}

	public String getLastname() {
		return lastname;
	}
	
	public String getFullName() {
		return firstname + " " + lastname;
	}

	public int getId() {
		return id;
	}

}
