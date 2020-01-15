package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

/**
 * 
 * @author Mootaas
 * 
 * This is a Interface for the method of the diary
 *
 */

import com.vaadin.flow.component.button.Button;

public interface DiaryAddView {

	interface DiaryAddViewListener {
		void buttonClick(Button button);
	}
	
	public String getEntry();
	
	public LocalDate getDate();
	
	public String getAuthor();

	public void addListener(DiaryAddViewListener listener);

}
