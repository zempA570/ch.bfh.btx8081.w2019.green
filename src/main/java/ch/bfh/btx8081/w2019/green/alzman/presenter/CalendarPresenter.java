package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AppointmentModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.CalendarView;

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

	// Insert an Appointment in DB
	public void addAppointmentToDB() {

		AppointmentModel addAppointment = view.getAppointmentFromFields();

		DbService.persist(addAppointment);

	}

	// Delete an Appointment from DB
	public void deleteAppointment() {

		int idToDelete = Integer.parseInt(view.getIdForAppointmentToDelete());

		AppointmentModel calendarModelToDelete = null;

		for (AppointmentModel entry : allAppointments) {
			if (Objects.equals(entry.getId(), idToDelete)) {
				calendarModelToDelete = entry;
			}
		}

		if (calendarModelToDelete != null) {
			DbService.remove(calendarModelToDelete);

		}
	}

	// Fills the Calendar with the entries
	public void fillCalendar() {

		allAppointments = DbService.getAllAppointments();

		for (AppointmentModel appointment : allAppointments) {
			view.addEntryToCalendar(appointment);
		}
	}

	// Reload the Page

	private void reloadPage() {
		UI.getCurrent().getPage().reload();

	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add entry":
			addAppointmentToDB();
			reloadPage();
			break;
		case "Delete entry":
			deleteAppointment();
			reloadPage();
			break;
		default:
			// TODO
			;
		}

	}
}
