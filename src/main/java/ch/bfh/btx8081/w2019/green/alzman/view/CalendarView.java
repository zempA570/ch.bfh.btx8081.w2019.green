package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.CalendarModel;

public interface CalendarView {

	interface CalendarListener {
		void buttonClick(Button button);
	}

	public void addListener(CalendarListener listener);

	public void addEntryToCalendar(CalendarModel entries);
	
	public CalendarModel getAppointmentFromFields();
	
	public String getIdForAppointmentToDelete();

}
