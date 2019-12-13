package ch.bfh.btx8081.w2019.green.alzman.view;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
import org.vaadin.stefan.fullcalendar.Resource;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
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
import com.vaadin.flow.router.Route;


/**
 * 
 * @author Thevian
 * 
 * This is a Calendargui
 *
 */

@Route("Calendar")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class CalendarView extends TemplateView {
	



	public CalendarView() {

		// Change title in header
		super.setHeaderTitle("Calendar");
		ProgressBar progressBar = new ProgressBar();
		
		// add a progressbar
		
		progressBar.setIndeterminate(true);
		super.add(progressBar);
		
		//Create and build a calendar
		FullCalendar calendar = FullCalendarBuilder.create().build();
		
		super.addContent(calendar);
		
		// Create a initial sample entry
		Entry entry = new Entry();
		entry.setTitle("Some event");
		entry.setStart(LocalDate.now().withDayOfMonth(3).atTime(10, 0), calendar.getTimezone());
		entry.setEnd(entry.getStart().plusHours(2), calendar.getTimezone());
		entry.setColor("#ff3333");

		calendar.addEntry(entry);
		
		calendar.addTimeslotsSelectedListener((event) -> {
		    entry.setStart(calendar.getTimezone().convertToUTC(event.getStartDateTime()));
		    entry.setEnd(calendar.getTimezone().convertToUTC(event.getEndDateTime()));
		    entry.setAllDay(event.isAllDay());

		    entry.setColor("green");

		    // ... show and editor
		});
		
		

		//Create a horizontal Layout with two button. The button "calAdd" is for add an appointment. 
		// The Button "calDel" is for delete an entry.
		
		HorizontalLayout horiLay = new HorizontalLayout();
		Button calAdd = new Button("Eintrag hinzufügen");
		calAdd.addClickListener(e -> UI.getCurrent().navigate(AddAppointment.class));
		Button calDel = new Button("Eintrag löschen");
		calDel.addClickListener(e -> UI.getCurrent().navigate(DeleteAppointment.class));
		horiLay.add(calAdd, calDel);
		
		super.add(horiLay);
		super.add();
		

		

	}

}
