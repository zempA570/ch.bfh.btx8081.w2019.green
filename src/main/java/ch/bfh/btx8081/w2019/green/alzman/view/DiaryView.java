package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

/**
 * 
 * @author Mootaas
 * 
 * This is a Interface for the method of the diary
 *
 */

import ch.bfh.btx8081.w2019.green.alzman.model.DiaryModel;

public interface DiaryView {
	
	interface DiaryViewListener {
		void buttonClick(Button button);
	}

	public void addListener(DiaryViewListener listener);

	public void clearEntries();

	public void addEntryToView(DiaryModel model);

}
