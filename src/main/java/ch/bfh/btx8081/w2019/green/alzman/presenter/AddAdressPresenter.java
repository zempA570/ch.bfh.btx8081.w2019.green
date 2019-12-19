package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.AddAdressInfoboxView;
import ch.bfh.btx8081.w2019.green.alzman.view.AddPersonInfoboxView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView;

public class AddAdressPresenter {

	private AddAdressInfoboxView view;

	private List<AddAdress> adresses;

	public AddAdressPresenter() {

	}

	// constructor for the presenter
	public AddAdressPresenter(AddAdressInfoboxView infoboxView) {
		this.view = infoboxView;
	}

	public void deleteAdress(String Inportantadress) {

		DbService.em.getTransaction().begin();

		// get the id number of the user which is at the beginning of the string
		int AdressId = Integer.parseInt(Inportantadress.substring(0, Inportantadress.indexOf(" ")));

		AddAdress adressToDelete = null;

		// for every user we have in our list
		for (AddAdress adr : adresses) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(adr.getId(), AdressId)) {
				// this is the user we want to delete
				adressToDelete = adr;
			}
		}

		// this is the part where we use the DB
		DbService.em.remove(adressToDelete);
		DbService.em.getTransaction().commit();

		// after the user is deleted we "refresh" the list in the combobox so the
		// deleted user is gone
//		fillTabelleWithAdress();

//		TODO when to close?
		// DbService.em.close();

	}

	public void addAdress(String name, String adress, String adressNr, String postcode, String city,
			String phonenummber) {

		// create new user
		AddAdress newAdress = new AddAdress(name, adress, adressNr, postcode, city, phonenummber);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newAdress);
		DbService.em.getTransaction().commit();

	}

}
