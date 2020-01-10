package ch.bfh.btx8081.w2019.green.alzman.presenter;


import java.util.List;
import java.util.Objects;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAdressView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAdressViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;


public class InfoboxAddAdressPresenter implements InfoboxAddAdressView.InfoboxAddAdressListener{

	private InfoboxAddAdressView view;
	private List<AddressModel> lstAddresses;

	public InfoboxAddAdressPresenter() {

	}

	// constructor for the presenter
	public InfoboxAddAdressPresenter(InfoboxAddAdressView infoboxView) {
		this.view = infoboxView;
		view.addListener(this);
	}

	public void addAdress() {
		
		// create new user
		AddressModel newAdress = view.getAdressFromFields();

		// DB stuff
		DbService.persist(newAdress);

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




