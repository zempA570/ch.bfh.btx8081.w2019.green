//package ch.bfh.btx8081.w2019.green.alzman.trash;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.TableGenerator;
//
///**
// * This class represents the patient, it is also used to store the password 
// * 
// * @author Adrian
// *
// */
//@Entity
//@Table(name = "Patient")
//public class PatientModel {
//	@TableGenerator(name = "patientIDGenerator", allocationSize = 1, initialValue = 123456)
//	@GeneratedValue(generator = "patientIDGenerator")
//	@Id
//	int id;
//	String password;
//	String firstname;
//	String lastname;
//
//	public PatientModel(String password, String firstname, String lastname) {
//		this.password = password;
//		this.firstname = firstname;
//		this.lastname = lastname;
//	}
//
//	public PatientModel() {
//
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//}
