package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.DiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryAddView;

/**
 * 
 * @author Mootaas
 * 
 * This is the presenter of the diary. All the logic of the diary is controlled by this class
 *
 */
public class DiaryAddPresenter implements DiaryAddView.DiaryAddViewListener {

	private DiaryAddView view;

	public DiaryAddPresenter(DiaryAddView diaryView) {
		this.view = diaryView;
		view.addListener(this);
	}

	public void addRecord() {
		LocalDate date = view.getDate();
		String author = view.getAuthor();
		String entry = view.getEntry();
		DiaryModel addnewRecord = new DiaryModel(date, author, entry);
		DbService.persist(addnewRecord);
	}

	@Override
	public void buttonClick(Button button) {
		String buttonText = button.getText();
		switch (buttonText) {
		case "Add new Record":
			addRecord();
			break;
		default:
			// TODO
			;
		}
	}
}