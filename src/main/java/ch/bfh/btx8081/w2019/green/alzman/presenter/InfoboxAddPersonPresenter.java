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
	private List<PersonModel> lstPersons;

	public InfoboxAddPersonPresenter() {

	}

	// constructor for the presenter
	public InfoboxAddPersonPresenter(InfoboxAddPersonView infoboxView) {
		view = infoboxView;
		view.addListener(this);

	}

	private void addPerson() {

		// create new user
		PersonModel newPerson = view.getPersonFromFields();

		// DB stuff
		DbService.persist(newPerson);

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
