package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;

/**
 * This is the interface class that is needed to implement the InfoboxView.
 * @author gausegan
 *
 */

public interface InfoboxView {

	interface InfoboxViewListener {
		void buttonClick(Button btnClick);
	}

	public void addListener(InfoboxViewListener listener);

	public Set<PersonModel> getSelectedPerson();

	public Set<AddressModel> getSelectedAddress();

	public void fillGridWithAdress(List<AddressModel> lstAddresses);

	public void fillGridWithUsers(List<PersonModel> lstPersons);

}
