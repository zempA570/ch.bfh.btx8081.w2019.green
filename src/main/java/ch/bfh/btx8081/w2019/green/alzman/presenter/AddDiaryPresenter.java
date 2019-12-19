package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Query;
import com.vaadin.flow.component.datepicker.DatePicker;
import ch.bfh.btx8081.w2019.green.alzman.model.AddDiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.EntryRecordDiary;


/**
 * 
 * @author Mootaas
 *
 */
public class AddDiaryPresenter {

	private EntryRecordDiary pview;
	
	// constructor for the presenter
	public AddDiaryPresenter(EntryRecordDiary diaryView) {
		this.pview = diaryView;


	}

	


	public void addRecord(LocalDate date, String author, String Entry) {

		// create new user
		
		
		AddDiaryModel addnewRecord = new AddDiaryModel(date,author,Entry);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(addnewRecord);
		DbService.em.getTransaction().commit();

	
	}

	
}