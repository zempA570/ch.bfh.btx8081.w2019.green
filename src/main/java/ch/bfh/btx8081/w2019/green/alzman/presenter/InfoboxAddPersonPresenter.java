package ch.bfh.btx8081.w2019.green.alzman.presenter;


import java.util.List;
import java.util.Objects;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddPersonView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddPersonViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;

public class InfoboxAddPersonPresenter implements InfoboxAddPersonView.InfoboxAddPersonListener {

	private InfoboxAddPersonView view;
	private List<PersonModel> persons;

	public InfoboxAddPersonPresenter() {

	}

	// constructor for the presenter
	public InfoboxAddPersonPresenter(InfoboxAddPersonView infoboxView) {
		view = infoboxView;
		view.addListener(this);

	}

//	ADRIAN: I dont think you need this function here? you are only adding not deleting stuff..
//	public void deletePerson(String inportantPerson) {
//
//		DbService.em.getTransaction().begin();
//
//		// get the id number of the user which is at the beginning of the string
//		int PersonId = Integer.parseInt(inportantPerson.substring(0, inportantPerson.indexOf(" ")));
//
//		AddPerson personToDelete = null;
//
//		// for every user we have in our list
//		for (AddPerson pers : persons) {
//			// if the id of that user is the same as the id we got from the userIdFullname
//			if (Objects.equals(pers.getId(), PersonId)) {
//				// this is the user we want to delete
//				personToDelete = pers;
//			}
//		}
//
//		// this is the part where we use the DB
//		DbService.em.remove(personToDelete);
//		DbService.em.getTransaction().commit();
//
//		// after the user is deleted we "refresh" the list in the combobox so the
//		// deleted user is gone
//		
//		
//
//	}

	private void addPerson() {

		// create new user
		PersonModel newPerson = view.getPersonFromFields();

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newPerson);
		DbService.em.getTransaction().commit();

	}
	
	private void navigateToInfobox() {
		UI.getCurrent().navigate(InfoboxViewImpl.class);
	}

	@Override
	public void buttonClick(Button button) {
		String buttonText = button.getText();

		switch (buttonText) {
		case "Add Person":
			addPerson();
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
