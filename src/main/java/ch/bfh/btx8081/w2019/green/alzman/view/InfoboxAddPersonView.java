package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;

public interface InfoboxAddPersonView {

	interface InfoboxAddPersonListener {
		void buttonClick(Button button);
	}

	public void addListener(InfoboxAddPersonListener listener);
	
	public AddPerson getPersonFromFields();

}
