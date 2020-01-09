package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;

public interface InfoboxAddAdressView {

	interface InfoboxAddAdressListener {
		void buttonClick(Button button);
	}

	public void addListener(InfoboxAddAdressListener listener);

	public AddAdress getAdressFromFields();

}
