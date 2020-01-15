package ch.bfh.btx8081.w2019.green.alzman.view;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AppointmentModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.CalendarPresenter;

/**
 * 
 * @author Thevian
 * 
 *         This is a Calendargui
 *
 */

@Route("calendar")
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

		fc = FullCalendarBuilder.create().build();

		super.addContent(fc);

		// Create a horizontal Layout with two button. The button "calAdd" is for add an
		// appointment.
		// The Button "calDel" is for delete an entry.
		Button calAdd = new Button("Add entry");
		calAdd.addClickListener(e -> {
			for (CalendarListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		Button calDel = new Button("Delete entry");
		calDel.addClickListener(e -> {
			for (CalendarListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		dp = new DatePicker();
		dp.setValue(LocalDate.now());
		dp.setLabel("Date");
		// Display an icon which can be clicked to clear the value:
		dp.setClearButtonVisible(true);

		tp = new TimePicker();
		tp.setValue(LocalTime.now());
		tp.setLabel("Time");
		// Display an icon which can be clicked to clear the value:
		tp.setClearButtonVisible(true);

		txtfAuthor = new TextField();
		txtfAuthor.setLabel("Written by");

		txtfEntry = new TextField();
		txtfEntry.setLabel("Entry");

		txtfDeleteId = new TextField();
		txtfDeleteId.setLabel("ID for delete an entry");

		// Creating horizontal layout
		HorizontalLayout dateTimeHLayout = new HorizontalLayout();
		dateTimeHLayout.add(dp, tp);

		// Creating horizontal layout
		HorizontalLayout hlText = new HorizontalLayout();
		hlText.add(txtfAuthor, txtfEntry, calAdd);

		HorizontalLayout hlDelete = new HorizontalLayout();
		hlDelete.add(calDel, txtfDeleteId);

		// Progressbar for design
		ProgressBar progressBar = new ProgressBar();
		progressBar.setValue(1);

		// Adding components to content space
		super.add(dateTimeHLayout);
		super.add(hlText);
		super.add(progressBar);
		super.add(hlDelete);

		new CalendarPresenter(this);

	}

	// Add an Entry to the Calendar
	public void addEntryToCalendar(AppointmentModel cModel) {

		Entry entry = new Entry();
		entry.setTitle(cModel.getEntry() + " **" + "ID: " + cModel.getId());
		entry.setDescription(cModel.getAuthor());

		LocalDateTime actDateTime = LocalDateTime.of(cModel.getDate().toLocalDate(), cModel.getTime().toLocalTime());

		entry.setStart(actDateTime);

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
