package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddDiaryModel;

public interface DiaryView {
	
	interface DiaryViewListener {
		void buttonClick(Button button);
	}

	public void addListener(DiaryViewListener listener);

	public void clearEntries();

	public void addEntryToView(AddDiaryModel model);

}