package ch.bfh.btx8081.w2019.green.alzman.view;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
import org.vaadin.stefan.fullcalendar.Resource;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.shared.ui.datefield.LocalDateTimeFieldState;

import ch.bfh.btx8081.w2019.green.alzman.model.AppointmentModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.CalendarPresenter;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxView.InfoboxViewListener;

/**
 * 
 * @author Thevian
 * 
 *         This is a Calendargui
 *
 */

@Route("Calendar")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class CalendarViewImpl extends TemplateView implements CalendarView {

	private List<CalendarListener> listeners = new ArrayList<CalendarListener>();
	public FullCalendar fc;
	private DatePicker dp;
	private TimePicker tp;
	private TextField txtfAuthor;
	private TextField txtfEntry;
	private TextField txtfDeleteId;

	public CalendarViewImpl() {

		// Change title in header
		super.setHeaderTitle("Calendar");
//		ProgressBar progressBar = new ProgressBar();

		// add a progressbar
		// progressBar.setIndeterminate(true);
		// super.add(progressBar);

		// Create and build a calendar
		fc = FullCalendarBuilder.create().build();

		super.addContent(fc);

//		// Create a initial sample entry
//		Entry entry = new Entry();
//		entry.setTitle("Some event");
//		entry.setStart(LocalDate.now().withDayOfMonth(3).atTime(10, 0), calendar.getTimezone());
//		entry.setEnd(entry.getStart().plusHours(2), calendar.getTimezone());
//		entry.setColor("#ff3333");
//		entry.setEditable(false);
//
//		calendar.addEntry(entry);

//		calendar.addTimeslotsSelectedListener((event) -> {
//			entry.setStart(calendar.getTimezone().convertToUTC(event.getStartDateTime()));
//			entry.setEnd(calendar.getTimezone().convertToUTC(event.getEndDateTime()));
//			entry.setAllDay(event.isAllDay());
//
//			entry.setColor("green");
//
//			// ... show and editor
//		});

		// Create a horizontal Layout with two button. The button "calAdd" is for add an
		// appointment.
		// The Button "calDel" is for delete an entry.
		HorizontalLayout hlButtons = new HorizontalLayout();
		Button calAdd = new Button("Eintrag hinzufügen");
		calAdd.addClickListener(e -> {
			for (CalendarListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		Button calDel = new Button("Eintrag löschen");
		calDel.addClickListener(e -> {
			for (CalendarListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		dp = new DatePicker();
		dp.setValue(LocalDate.now());
		dp.setLabel("Datum");
		// Display an icon which can be clicked to clear the value:
		dp.setClearButtonVisible(true);

		tp = new TimePicker();
		tp.setValue(LocalTime.now());
		tp.setLabel("Zeit");
		// Display an icon which can be clicked to clear the value:
		tp.setClearButtonVisible(true);

		txtfAuthor = new TextField();
		txtfAuthor.setLabel("Geschrieben von");

		txtfEntry = new TextField();
		txtfEntry.setLabel("Eintrag");

		txtfDeleteId = new TextField();
		txtfDeleteId.setLabel("ID for delete an entry");

		// Creating horizontal layout
		HorizontalLayout dateTimeHLayout = new HorizontalLayout();
		dateTimeHLayout.add(dp, tp);

		// Creating horizontal layout
		HorizontalLayout hlText = new HorizontalLayout();
		hlText.add(txtfAuthor, txtfEntry);

		hlButtons.add(calAdd, calDel, txtfDeleteId);

		// Adding components to content space
		super.add(hlButtons);
		super.add(dateTimeHLayout);
		super.add(hlText);

		new CalendarPresenter(this);

	}

	public void addEntryToCalendar(AppointmentModel cModel) {

		// Create a initial sample entry
		Entry entry = new Entry();
		entry.setTitle(cModel.getEntry() + " " + cModel.getId());
		entry.setDescription(cModel.getAuthor());

		LocalDateTime actDateTime = LocalDateTime.of(cModel.getDate().toLocalDate(), cModel.getTime().toLocalTime());

		entry.setStart(actDateTime);
		// entry.setEnd(entry.getStart().plusHours(2), calendar.getTimezone());

		entry.setColor("#ff3333");
		entry.setEditable(true);

		fc.addEntry(entry);

	}

	@Override
	public void addListener(CalendarListener listener) {
		listeners.add(listener);
	}

	@Override
	public AppointmentModel getAppointmentFromFields() {

		AppointmentModel newCalendarModel = new AppointmentModel();

		newCalendarModel.setAuthor(txtfAuthor.getValue());
		newCalendarModel.setDate(Date.valueOf(dp.getValue()));
		newCalendarModel.setEntry(txtfEntry.getValue());
		newCalendarModel.setTime(Time.valueOf(tp.getValue()));

		return newCalendarModel;
	}

	@Override
	public String getIdForAppointmentToDelete() {
		return txtfDeleteId.getValue();
	}

}
