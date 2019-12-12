package ch.bfh.btx8081.w2019.green.alzman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "ImportantPerson")
public class AddPerson {

	@TableGenerator(name = "ImportantPersonIDGenerator", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "ImportantPersonIDGenerator")
	int id;

	String firstname;
	String lastname;
	String adress;
	String adressNr;
	String postcode;
	String city;
	String phonenummber;

	public AddPerson() {

	}

	public AddPerson(int id, String firstname, String lastname, String adress, String adressNr, String postcode,
			String city, String phonenummber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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

}
