package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
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
 * This class {@link InfoboxPresenter} controls all methods that are used in the class
 * {@link InfoboxView}
 * 
 * @author Gausegan
 *
 */
public class InfoboxPresenter implements InfoboxView.InfoboxViewListener {

	private InfoboxView view;
	private List<PersonModel> lstPersons;
	private List<AddressModel> lstAddresses;

	public InfoboxPresenter(InfoboxView infoboxView) {
		view = infoboxView;
		view.addListener(this);

		fillTableWithPersons();
		fillTableWithAddress();
	}

	public void fillTableWithPersons() {
		// get list of users out of the query
		lstPersons = DbService.getAllPerson();

		view.fillGridWithUsers(lstPersons);
	}

	public void navigateToAddPerson() {
		UI.getCurrent().navigate(InfoboxAddPersonViewImpl.class);
	}

	public void deletePerson() {
		Set<PersonModel> person = view.getSelectedPerson();
		PersonModel personToDelete = person.stream().findFirst().get();

		// delete person
		DbService.remove(personToDelete);

		// reload table
		fillTableWithPersons();

	}

	public void fillTableWithAddress() {
		// get list of users out of the query
		lstAddresses = DbService.getAllAddress();

		view.fillGridWithAdress(lstAddresses);
	}

	public void deleteAddress() {
		Set<AddressModel> address = view.getSelectedAddress();
		AddressModel addressToDelete = address.stream().findFirst().get();
		
		// delete address
		DbService.remove(addressToDelete);

		// reload table from DB
		fillTableWithAddress();
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
		case "Add Address":
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
