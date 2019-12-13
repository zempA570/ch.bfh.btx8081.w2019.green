package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.timepicker.TimePicker;

import ch.bfh.btx8081.w2019.green.alzman.model.CalendarModel;
import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.CalendarView;
import ch.bfh.btx8081.w2019.green.alzman.view.EntryRecordDiary;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView;

/**
 * 
 * @author Mootaas
 *
 */
public class DiaryPresenter {

	private EntryRecordDiary pview;
	
	// constructor for the presenter
	public DiaryPresenter(EntryRecordDiary diaryView) {
		this.pview = diaryView;


	}

	


	public void addAppointment(DatePicker date, String author, String Entry) {

		// create new user
		
		
		DiaryModel addnewRecord = new DiaryModel(date,author,Entry);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(addnewRecord);
		DbService.em.getTransaction().commit();

	
	}

	
}