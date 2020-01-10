package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAdressViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddPersonViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView;

/**
 * This class InfoboxPresenter controls all methods that are used in the class
 * InfoboxView
 * 
 * @author gausegan
 *
 */
public class InfoboxPresenter implements InfoboxView.InfoboxViewListener {

	private InfoboxView view;
	private List<PersonModel> lstPersons;
	private List<AddressModel> lstAddresses;

	public InfoboxPresenter(InfoboxView infoboxView) {
		view = infoboxView;
		view.addListener(this);

		fillTabelleWithPersons();
		fillTabelleWithAddress();
	}

	public void fillTabelleWithPersons() {

		// get list of users out of the query
		lstPersons = DbService.getAllPerson();

		view.fillGridWithUsers(lstPersons);

	}

	public void navigateToAddPerson() {
		UI.getCurrent().navigate(InfoboxAddPersonViewImpl.class);
	}

	public void deletePerson() {

		Set<PersonModel> person = view.getSelectedPerson();

		PersonModel test = person.stream().findFirst().get();
		test.getId();

		// get the id number of the user which is at the beginning of the string
		int PersonId = test.getId();

		PersonModel personToDelete = null;

		// for every user we have in our list
		for (PersonModel pers : lstPersons) {
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

	public void fillTabelleWithAddress() {

		// get list of users out of the query
		lstAddresses = DbService.getAllAddress();

		view.fillGridWithAdress(lstAddresses);

	}

	public void deleteAddress() {

		Set<AddressModel> adress = view.getSelectedAddress();

		AddressModel adressdelete = adress.stream().findFirst().get();
		adressdelete.getId();

		// get the id number of the user which is at the beginning of the string
		int AdressId = adressdelete.getId();

		AddressModel adressToDelete = null;

		// for every user we have in our list
		for (AddressModel adr : lstAddresses) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(adr.getId(), AdressId)) {
				// this is the user we want to delete
				adressToDelete = adr;
			}
		}

		// this is the part where we use the DB
		DbService.remove(adressToDelete);

		fillTabelleWithAddress();

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
			deleteAddress();
			break;
		default:
			;
		}

	}

}
