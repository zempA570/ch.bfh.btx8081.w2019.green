package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;

/**
 * This is the interface class that is needed to implement the InfoboxAddPersonView.
 * @author gausegan
 *
 */
public interface InfoboxAddPersonView {

	interface InfoboxAddPersonListener {
		void buttonClick(Button btnClick);
	}

	public void addListener(InfoboxAddPersonListener listener);

	public PersonModel getPersonFromField();

}
