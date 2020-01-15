package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * In this class all information about the important persons is collected
 * 
 * @author Gausegan
 *
 */
@Entity
@Table(name = "Person")
public class PersonModel {

	@TableGenerator(name = "ImportantPersonIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "ImportantPersonIDGenerator")
	int id;

	String gender;
	String firstname;
	String lastname;
	String street;
	String houseNo;
	String postcode;
	String city;
	String phonenumber;

	public PersonModel() {

	}

	public PersonModel(String gender, String firstname, String lastname, String street, String houseNo,
			String postcode, String city, String phonenumber) {
		super();
		this.gender = gender;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.houseNo = houseNo;
		this.postcode = postcode;
		this.city = city;
		this.phonenumber = phonenumber;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFullDetailsPerson() {
		return gender + " " + firstname + " " + lastname + " " + street + " " + houseNo + " " + postcode + " " + city
				+ " " + phonenumber;
	}

}
