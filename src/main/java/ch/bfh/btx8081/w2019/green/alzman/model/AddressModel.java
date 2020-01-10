package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "Address")
public class AddressModel {

	@TableGenerator(name = "ImportantAdressIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "ImportantAdressIDGenerator")
	int id;

	String name;
	String adress;
	String adressNr;
	String postcode;
	String city;
	String phonenummber;

	public AddressModel() {

	}

	public AddressModel(String name, String adress, String adressNr, String postcode, String city,
			String phonenummber) {
		super();
		this.name = name;
		this.adress = adress;
		this.adressNr = adressNr;
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
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getAdressNr() {
		return adressNr;
	}

	public void setAdressNr(String adressNr) {
		this.adressNr = adressNr;
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
		return name + " " + adress + " " + adressNr + " " + postcode + " " + city + " " + phonenummber;
	}

}
