package ch.bfh.btx8081.w2019.green.alzman.presenter;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddPersonView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;

/**
 * This class {@link InfoboxAddPersonPresenter} controls all methods used in the
 * {@link InfoboxAddPersonView} class
 * 
 * @author Gausegan
 *
 */
public class InfoboxAddPersonPresenter implements InfoboxAddPersonView.InfoboxAddPersonListener {

	private InfoboxAddPersonView view;

	public InfoboxAddPersonPresenter() {

	}

	// constructor for the presenter
	public InfoboxAddPersonPresenter(InfoboxAddPersonView infoboxView) {
		view = infoboxView;
		view.addListener(this);

	}

	private void addPerson() {
		// create new user
		PersonModel newPerson = view.getPersonFromField();

		// DB stuff
		DbService.persist(newPerson);
	}

	private void navigateToInfobox() {
		UI.getCurrent().navigate(InfoboxViewImpl.class);
	}

	@Override
	public void buttonClick(Button btnClick) {
		String buttonText = btnClick.getText();

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
