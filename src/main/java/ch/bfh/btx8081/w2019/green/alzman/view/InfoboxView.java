package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;

public interface InfoboxView {

	interface InfoboxViewListener {
		void buttonClick(Button button);
	}

	public void addListener(InfoboxViewListener listener);
	
	public Set<PersonModel> getSelectedPerson();
	
	public Set<AddressModel> getSelectedAdress();

	public void fillGridWithAdress(List<AddressModel> adresses);

	public void fillGridWithUsers(List<PersonModel> persons);


}
