package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * In this class all information about the important addresses is collected
 * 
 * @author Gausegan
 *
 */
@Entity
@Table(name = "Address")
public class AddressModel {

	@Id
	@GeneratedValue
	int id;

	String name;
	String street;
	String houseNo;
	String postcode;
	String city;
	String phonenumber;

	public AddressModel() {

	}

	public AddressModel(String name, String street, String houseNo, String postcode, String city,
			String phonenumber) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setPhonenummber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFullDetailsAdress() {
		return name + " " + street + " " + houseNo + " " + postcode + " " + city + " " + phonenumber;
	}

}
