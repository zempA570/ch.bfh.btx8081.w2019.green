package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

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
