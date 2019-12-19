package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
}
