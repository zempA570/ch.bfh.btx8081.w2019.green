package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.AddAdressInfoboxView;
import ch.bfh.btx8081.w2019.green.alzman.view.AddPersonInfoboxView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView;

/**
 * 
 * @author Adrian
 *
 */
public class AddAdressPresenter {

	private InfoboxView view;
	private AddAdressInfoboxView addAdressModel;
	private List<AddAdress> adresses;

	// constructor for the presenter
	public AddAdressPresenter(InfoboxView infoboxView) {
		this.view = infoboxView;

		//Das muss noch geändert werden
		fillTabelleWithAdress();

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
		fillTabelleWithAdress();

//		TODO when to close?
		// DbService.em.close();

	}

	public void addAdress(String name, String adress, String adressNr,
			String postcode, String city, String phonenummber) {

		// create new user
		AddAdress newAdress = new AddAdress(name, adress, adressNr,postcode, city, phonenummber);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newAdress);
		DbService.em.getTransaction().commit();

		// clear the textfields where the user entered the data
		//Muss noch gemacht werden
		addAdressModel.clearTextfieldsAdresse();

		// after the user is added we "refresh" the list in the combobox so the new user
		// appears
		fillTabelleWithAdress();

	}

	private void fillTabelleWithAdress() {

		// DB stuff where we get all the users
		Query query = DbService.em.createNativeQuery("SELECT * FROM Relative", AddPerson.class);

		// get list of users out of the query
		
		adresses = query.getResultList();

		List<String> adressDetail = new ArrayList<String>();
		// for every user in our list
		for (AddAdress adress : adresses) {
			// we add the id and fullname of that user to our List<String>
			adressDetail.add(adress.getId()+ " "+ adress.getFullDetailsAdress());

		}

		// then we tell the view to fill the combobox with the List<String>
		view.fillGridWithPerson(adressDetail);

//		TODO message to user that was deleted?

	}

}
