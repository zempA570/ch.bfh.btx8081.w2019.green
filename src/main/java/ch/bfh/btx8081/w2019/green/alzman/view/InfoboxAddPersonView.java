package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;

public interface InfoboxAddPersonView {

	interface InfoboxAddPersonListener {
		void buttonClick(Button button);
	}

	public void addListener(InfoboxAddPersonListener listener);
	
	public PersonModel getPersonFromFields();

}
