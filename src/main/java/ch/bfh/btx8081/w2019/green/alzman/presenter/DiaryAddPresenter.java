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
 */
public class DiaryAddPresenter implements DiaryAddView.DiaryAddViewListener {

	private DiaryAddView view;

	// constructor for the presenter
	public DiaryAddPresenter(DiaryAddView diaryView) {
		this.view = diaryView;
		view.addListener(this);
	}

	public void addRecord() {

		System.out.println("i want to add");
		
		// create new Record

		LocalDate date = view.getDate();
		String author = view.getAuthor();
		String entry = view.getEntry();

		DiaryModel addnewRecord = new DiaryModel(date, author, entry);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(addnewRecord);
		DbService.em.getTransaction().commit();

	}

	@Override
	public void buttonClick(Button button) {
		
		System.out.println("clicked");

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