package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView;

public class InfoboxPresenter {

	private InfoboxView view;
	private List<AddPerson> persons;
	private List<AddAdress> adresses;
	
	

	

	public InfoboxPresenter(InfoboxView infoboxView) {
		view = infoboxView;
		
		fillTabelleWithPersons();
		fillTabelleWithAdress();
	}




	public void fillTabelleWithPersons() {

		if (persons == null) {

			// DB stuff where we get all the users
			Query query = DbService.em.createNativeQuery("SELECT * FROM ImportantPerson", AddPerson.class);

			// get list of users out of the query
			persons = query.getResultList();

			view.fillGridWithUsers(persons);

		}
	}
	
	public void fillTabelleWithAdress() {

		if (adresses == null) {

			// DB stuff where we get all the users
			Query query = DbService.em.createNativeQuery("SELECT * FROM ImportantAdress", AddAdress.class);

			// get list of users out of the query
			adresses = query.getResultList();

			view.fillGridWithAdress(adresses);

		}
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
//		fillTabelleWithPersons();

//		TODO when to close?
		// DbService.em.close();

	}
	
}
