package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView;

/**
 * 
 * @author Thevian
 *
 */
public class CalendarPresenter {

	private CalendarView Cview;
	private List<CalendarModel> entries;

	// constructor for the presenter
	public CalendarPresenter(CalendarView calendarView) {
		this.Cview = calendarView;

		insertEntriesToCalendar();

	}

	public void addAppointmentToDB(LocalDate LdatePick, LocalTime LtimePick, String author, String Entry) {

		Date datePick = Date.valueOf(LdatePick);

		Time time = Time.valueOf(LtimePick);
		// create new user

		CalendarModel addAppointment = new CalendarModel(datePick, time, author, Entry);

		// DB stuff
		DbService.init();
		DbService.em.getTransaction().begin();
		DbService.em.persist(addAppointment);
		DbService.em.getTransaction().commit();

	}

	public void deleteAppointment(String id) {

		CalendarModel entryToDelete = null;

		for (CalendarModel entries : entries) {

			if (Objects.equals(entries.getId(), id))

				System.out.println(entries.getId());
			System.out.println(id);

			{

				entryToDelete = entries;
			}

		}
		if (entryToDelete != null) {
			DbService.em.getTransaction().begin();
			DbService.em.remove(entryToDelete);
			DbService.em.getTransaction().commit();

		}

	}

	public void insertEntriesToCalendar() {

		Query query = DbService.em.createNativeQuery("SELECT * FROM CALENDARMODEL", CalendarModel.class);

		entries = query.getResultList();

		for (CalendarModel entries : entries) {
			Cview.addEntryToCalendar(entries);
		}

	}
}
