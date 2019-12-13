package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.AddPersonInfoboxView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView;


/**
 * 
 * @author Adrian
 *
 */
public class AddPersonPresenter {

	private InfoboxView view;
	private AddPersonInfoboxView addPersonModel;
	private List<AddPerson> persons;

	// constructor for the presenter
	public AddPersonPresenter(InfoboxView infoboxView) {
		this.view = infoboxView;

		//Das muss noch geändert werden
		fillTabelleWithPersons();

	}

	public void deletePerson(String Inportantperson) {

		DbService.em.getTransaction().begin();

		// get the id number of the user which is at the beginning of the string
		int PersonId = Integer.parseInt(Inportantperson.substring(0, Inportantperson.indexOf(" ")));

		AddPerson personToDelete = null;

		// for every user we have in our list
		for (AddPerson pers : persons) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(pers.getId(), PersonId)) {
				// this is the user we want to delete
				personToDelete = pers;
			}
		}

		// this is the part where we use the DB
		DbService.em.remove(personToDelete);
		DbService.em.getTransaction().commit();

		// after the user is deleted we "refresh" the list in the combobox so the
		// deleted user is gone
		fillTabelleWithPersons();

//		TODO when to close?
		// DbService.em.close();

	}

	public void addPerson(String gender, String firstname, String lastname, String adress, String adressNr,
			String postcode, String city, String phonenummber) {

		// create new user
		AddPerson newUser = new AddPerson(gender, firstname, lastname,adress, adressNr,
				postcode, city, phonenummber);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newUser);
		DbService.em.getTransaction().commit();

		// clear the textfields where the user entered the data
		//Muss noch gemacht werden
		addPersonModel.clearTextfields();

		// after the user is added we "refresh" the list in the combobox so the new user
		// appears
		fillTabelleWithPersons();

	}

	private void fillTabelleWithPersons() {

		// DB stuff where we get all the users
		Query query = DbService.em.createNativeQuery("SELECT * FROM Relative", AddPerson.class);

		// get list of users out of the query
		
		persons = query.getResultList();

		List<String> personDetail = new ArrayList<String>();
		// for every user in our list
		for (AddPerson person : persons) {
			// we add the id and fullname of that user to our List<String>
			personDetail.add(person.getId()+ " "+ person.getFullDetails());

		}

		// then we tell the view to fill the combobox with the List<String>
		view.fillGridWithPerson(personDetail);

//		TODO message to user that was deleted?

	}

}
