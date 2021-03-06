package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;

/**
 * This is the interface class that is needed to implement the {@link InfoboxAddAddressView}.
 * @author Gausegan
 *
 */
public interface InfoboxAddAddressView {

	interface InfoboxAddAdressListener {
		void buttonClick(Button btnClick);
	}

	public void addListener(InfoboxAddAdressListener listener);

	public AddressModel getAdressFromField();

}
