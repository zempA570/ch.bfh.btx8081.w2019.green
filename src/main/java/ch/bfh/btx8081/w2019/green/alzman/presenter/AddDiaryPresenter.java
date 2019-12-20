package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextArea;

import ch.bfh.btx8081.w2019.green.alzman.model.Diary;
import ch.bfh.btx8081.w2019.green.alzman.model.User;
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

		Diary addnewRecord = new Diary(date, author, Entry);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(addnewRecord);
		DbService.em.getTransaction().commit();

	}

}