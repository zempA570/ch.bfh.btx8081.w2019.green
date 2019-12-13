package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.CalendarPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("AddAppointment")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddAppointment extends TemplateView {
	
	private CalendarPresenter presenter;

	public AddAppointment() {

		// Change title in header
		super.setHeaderTitle("Termin hinzufügen");
		
		DatePicker date = new DatePicker();
		date.setValue(LocalDate.now());

		// Display an icon which can be clicked to clear the value:
		date.setClearButtonVisible(true);
		
		TimePicker time = new TimePicker();
		time.setValue(LocalTime.now());

		// Display an icon which can be clicked to clear the value:
		time.setClearButtonVisible(true);
		
		

		TextField author = new TextField();
		author.setLabel("Geschrieben von");
		
		TextField  entry = new TextField();
		entry.setLabel("Eintrag");

		Button btnAddEntry = new Button("Add Entry", new Icon(VaadinIcon.PLUS));
		

		// Creating horizontal layout
		HorizontalLayout hLAddUser = new HorizontalLayout();

		// Adding two components to horizontal layout
		hLAddUser.add(author,time, entry , btnAddEntry);
		
		

		// Adding components to content space
	
		super.addContent(date);
		super.addContent(hLAddUser);
		
		btnAddEntry.addClickListener(e -> presenter.addAppointment(date, time,author.getValue(), entry.getValue()));

	}

}
