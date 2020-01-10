package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AppointmentModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.CalendarView;
import ch.bfh.btx8081.w2019.green.alzman.view.CalendarViewImpl;

/**
 * 
 * @author Thevian
 *
 */
public class CalendarPresenter implements CalendarView.CalendarListener {

	private CalendarView view;
	private List<AppointmentModel> allAppointments;

	// constructor for the presenter
	public CalendarPresenter(CalendarView calendarView) {
		view = calendarView;
		view.addListener(this);

		fillCalendar();
	}

	public void addAppointmentToDB() {

		AppointmentModel addAppointment = view.getAppointmentFromFields();

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(addAppointment);
		DbService.em.getTransaction().commit();

	}

	public void deleteAppointment() {

		int idToDelete = Integer.parseInt(view.getIdForAppointmentToDelete());
		
		AppointmentModel calendarModelToDelete = null;
		

		for (AppointmentModel entry : allAppointments) {
			if (Objects.equals(entry.getId(), idToDelete)) {
				calendarModelToDelete = entry;
			}
		}

		if (calendarModelToDelete != null) {
			DbService.em.getTransaction().begin();
			DbService.em.remove(calendarModelToDelete);
			DbService.em.getTransaction().commit();
		}
	}

	public void fillCalendar() {
		Query query = DbService.em.createNativeQuery("SELECT * FROM Appointment", AppointmentModel.class);
		allAppointments = query.getResultList();

		for (AppointmentModel appointment : allAppointments) {
			view.addEntryToCalendar(appointment);
		}
	}

	private void reloadPage() {
		UI.getCurrent().getPage().reload();

	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Eintrag hinzufügen":
			addAppointmentToDB();
			reloadPage();
			break;
		case "Eintrag löschen":
			deleteAppointment();
			reloadPage();
			break;
		default:
			// TODO
			;
		}

	}
}
