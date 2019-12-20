package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.time.LocalDate;
import ch.bfh.btx8081.w2019.green.alzman.model.Diarymodel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.EntryRecordDiary;

/**
 * 
 * @author Mootaas
 *
 */
public class AddDiaryPresenter {

	private EntryRecordDiary addnewdiaryview;

	// constructor for the presenter
	public AddDiaryPresenter(EntryRecordDiary diaryView) {
		this.addnewdiaryview = diaryView;

	}

	public void addRecord(LocalDate date, String author, String Entry) {

		// create new Record

		Diarymodel addnewRecord = new Diarymodel(date, author, Entry);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(addnewRecord);
		DbService.em.getTransaction().commit();

	}

}