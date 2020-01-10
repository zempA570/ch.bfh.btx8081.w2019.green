package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;

import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;

public interface StatusView {
	
	interface StatusListener {
		void buttonClick(Button button);
		
		void iconClick();
	}

	public void addListener(StatusListener listener);

	public void addToView(StatusModel status);

	public String getIndepTfValue();
	
	public String getWhelpTfValue();

	public String getDepTfValue();

	public void clearTextfields();
	
	public void clearContent();


}
