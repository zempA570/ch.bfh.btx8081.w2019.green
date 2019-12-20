package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

	public void deletePerson(Set<AddPerson> person) {

		AddPerson test = person.stream().findFirst().get();
		test.getId();

		DbService.em.getTransaction().begin();

		// get the id number of the user which is at the beginning of the string
		int PersonId = test.getId();
		;

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

		fillTabelleWithPersons();

		DbService.em.close();

	}
	
	public void deleteAdress(Set<AddAdress> adress) {

		AddAdress adressdelete = adress.stream().findFirst().get();
		adressdelete.getId();

		DbService.em.getTransaction().begin();

		// get the id number of the user which is at the beginning of the string
		int AdressId = adressdelete.getId();
		;

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

		fillTabelleWithAdress();

		DbService.em.close();

	}
	
}
