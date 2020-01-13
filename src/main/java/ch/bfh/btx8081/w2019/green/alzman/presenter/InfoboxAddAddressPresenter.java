package ch.bfh.btx8081.w2019.green.alzman.presenter;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddAddressView;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;

/**
 * This class InfoboxAddAdressPresenter controls all methods that are used in
 * the class InfoboxAddAdressView
 * 
 * @author gausegan
 *
 */
public class InfoboxAddAddressPresenter implements InfoboxAddAddressView.InfoboxAddAdressListener {

	private InfoboxAddAddressView view;

	public InfoboxAddAddressPresenter() {

	}

	// constructor for the presenter
	public InfoboxAddAddressPresenter(InfoboxAddAddressView infoboxView) {
		this.view = infoboxView;
		view.addListener(this);
	}

	private void addAdress() {

		// create new user
		AddressModel newAdress = view.getAdressFromField();

		// DB stuff
		DbService.persist(newAdress);

	}

	private void navigateToInfobox() {
		UI.getCurrent().navigate(InfoboxViewImpl.class);
	}

	@Override
	public void buttonClick(Button btnClick) {

		String buttonText = btnClick.getText();

		switch (buttonText) {
		case "Add Address":
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
