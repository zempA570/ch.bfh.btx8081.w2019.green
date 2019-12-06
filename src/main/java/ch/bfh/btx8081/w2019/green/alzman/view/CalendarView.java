package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
import org.vaadin.stefan.fullcalendar.Resource;

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


@Route("Calendar")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class CalendarView<FullCalendar> extends TemplateView {
	
	private Label month;

	private Calendar cal;


	public CalendarView() {

		// Change title in header
		super.setHeaderTitle("Calendar");
		ProgressBar progressBar = new ProgressBar();
		progressBar.setIndeterminate(true);
		
		super.add(progressBar);
		
		
		HorizontalLayout horiLay = new HorizontalLayout();
		Image image = new Image("https://previews.123rf.com/images/zimmytws/zimmytws1201/zimmytws120100016/11996238-closeup-of-a-calendar-with-coming-soon-text-in-red.jpg", "In progress");
		Button calAdd = new Button("Eintrag hinzufügen", event -> Notification.show("Funktion noch nicht verfügbar"));
		Button calDel = new Button("Eintrag löschen", event -> Notification.show("Funktion noch nicht verfügbar"));
		horiLay.add(calAdd, calDel, image);
		
		super.add(horiLay);
		super.add();
		

		

	}

}
