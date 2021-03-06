package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;

/**
 * This Interface represents the view of the status function.
 * 
 * @author Emily
 *
 */
public interface StatusView {

	interface StatusListener {
		void buttonClick(Button button);

		void iconClick();
	}

	public void addToView(StatusModel status);

	public void addListener(StatusListener listener);

	public String getIndepTfValue();

	public String getWhelpTfValue();

	public String getDepTfValue();

	public void clearTextfields();

	public void clearContent();

}
