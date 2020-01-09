package ch.bfh.btx8081.w2019.green.alzman.presenter;


import java.util.List;
import java.util.Objects;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAdressView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAdressViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;


public class InfoboxAddAdressPresenter implements InfoboxAddAdressView.InfoboxAddAdressListener{

	private InfoboxAddAdressView view;
	private List<AddAdress> adresses;

	public InfoboxAddAdressPresenter() {

	}

	// constructor for the presenter
	public InfoboxAddAdressPresenter(InfoboxAddAdressView infoboxView) {
		this.view = infoboxView;
		view.addListener(this);
	}

//	ADRIAN: i dont think you need this here.. deleting is in InfoboxPresenter
//	public void deleteAdress(String inportantAdress) {
//
//		DbService.em.getTransaction().begin();
//
//		// get the id number of the user which is at the beginning of the string
//		int AdressId = Integer.parseInt(inportantAdress.substring(0, inportantAdress.indexOf(" ")));
//
//		AddAdress adressToDelete = null;
//
//		// for every user we have in our list
//		for (AddAdress adr : adresses) {
//			// if the id of that user is the same as the id we got from the userIdFullname
//			if (Objects.equals(adr.getId(), AdressId)) {
//				// this is the user we want to delete
//				adressToDelete = adr;
//			}
//		}
//
//		// this is the part where we use the DB
//		DbService.em.remove(adressToDelete);
//		DbService.em.getTransaction().commit();
//
//	}

	public void addAdress() {
		
		// create new user
		AddAdress newAdress = view.getAdressFromFields();

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newAdress);
		DbService.em.getTransaction().commit();

	}
	
	private void navigateToInfobox() {
		UI.getCurrent().navigate(InfoboxViewImpl.class);
	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add Adress":
			addAdress();
			navigateToInfobox();
			break;
		case "Cancel":
			navigateToInfobox();
			break;
		default:
			// TODO
			;
		}
		
	}

}




