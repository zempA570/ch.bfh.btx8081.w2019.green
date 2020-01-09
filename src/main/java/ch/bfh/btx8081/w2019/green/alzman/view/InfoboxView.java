package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;

public interface InfoboxView {

	interface InfoboxViewListener {
		void buttonClick(Button button);
	}

	public void addListener(InfoboxViewListener listener);
	
	public Set<AddPerson> getSelectedPerson();
	
	public Set<AddAdress> getSelectedAdress();

	public void fillGridWithAdress(List<AddAdress> adresses);

	public void fillGridWithUsers(List<AddPerson> persons);


}
