package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * In this class all information about the important addresses is collected
 * 
 * @author gausegan
 *
 */
@Entity
@Table(name = "Address")
public class AddressModel {

	@TableGenerator(name = "ImportantAddressIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "ImportantAddressIDGenerator")
	int id;

	String name;
	String address;
	String houseNo;
	String postcode;
	String city;
	String phonenummber;

	public AddressModel() {

	}

	public AddressModel(String name, String address, String houseNo, String postcode, String city,
			String phonenummber) {
		super();
		this.name = name;
		this.address = address;
		this.houseNo = houseNo;
		this.postcode = postcode;
		this.city = city;
		this.phonenummber = phonenummber;
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

	public String getAdress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public String getAdressNr() {
		return houseNo;
	}

	public void setAdressNr(String houseNo) {
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

	public String getPhonenummber() {
		return phonenummber;
	}

	public void setPhonenummber(String phonenummber) {
		this.phonenummber = phonenummber;
	}

	public String getFullDetailsAdress() {
		return name + " " + address + " " + houseNo + " " + postcode + " " + city + " " + phonenummber;
	}

}
