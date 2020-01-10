package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Query;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAdressViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddPersonViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView;

public class InfoboxPresenter implements InfoboxView.InfoboxViewListener {

	private InfoboxView view;
	private List<PersonModel> persons;
	private List<AddressModel> adresses;

	public InfoboxPresenter(InfoboxView infoboxView) {
		view = infoboxView;
		view.addListener(this);

		fillTabelleWithPersons();
		fillTabelleWithAdress();
	}

	public void fillTabelleWithPersons() {

		// DB stuff where we get all the users
		Query query = DbService.em.createNativeQuery("SELECT * FROM ImportantPerson", PersonModel.class);

		// get list of users out of the query
		persons = query.getResultList();

		view.fillGridWithUsers(persons);

	}

	public void fillTabelleWithAdress() {

		// DB stuff where we get all the users
		Query query = DbService.em.createNativeQuery("SELECT * FROM ImportantAdress", AddressModel.class);

		// get list of users out of the query
		adresses = query.getResultList();

		view.fillGridWithAdress(adresses);

	}

	public void deletePerson() {

		Set<PersonModel> person = view.getSelectedPerson();

		PersonModel test = person.stream().findFirst().get();
		test.getId();

		// get the id number of the user which is at the beginning of the string
		int PersonId = test.getId();

		PersonModel personToDelete = null;

		// for every user we have in our list
		for (PersonModel pers : persons) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(pers.getId(), PersonId)) {
				// this is the user we want to delete
				personToDelete = pers;
			}
		}

		// this is the part where we use the DB
		DbService.remove(personToDelete);

		fillTabelleWithPersons();

	}

	public void deleteAdress() {

		Set<AddressModel> adress = view.getSelectedAdress();

		AddressModel adressdelete = adress.stream().findFirst().get();
		adressdelete.getId();

		// get the id number of the user which is at the beginning of the string
		int AdressId = adressdelete.getId();

		AddressModel adressToDelete = null;

		// for every user we have in our list
		for (AddressModel adr : adresses) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(adr.getId(), AdressId)) {
				// this is the user we want to delete
				adressToDelete = adr;
			}
		}

		// this is the part where we use the DB
		DbService.remove(adressToDelete);


		fillTabelleWithAdress();


	}

	public void navigateToAddPerson() {
		UI.getCurrent().navigate(InfoboxAddPersonViewImpl.class);
	}

	public void navigateToAddAdress() {
		UI.getCurrent().navigate(InfoboxAddAdressViewImpl.class);
	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add Person":
			navigateToAddPerson();
			break;
		case "Delete Person":
			deletePerson();
			break;
		case "Add Adress":
			navigateToAddAdress();
			break;
		case "Delete Adress":
			deleteAdress();
			break;
		default:
			// TODO
			;
		}

	}

}
