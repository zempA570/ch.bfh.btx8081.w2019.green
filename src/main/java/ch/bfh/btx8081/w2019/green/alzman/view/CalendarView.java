package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.Calendar;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 * @param <FullCalendar>
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class CalendarView<FullCalendar> extends TemplateView {
	
	private Label month;

	


	public CalendarView() {

		// Change title in header
		super.setHeaderTitle("Calendar");
		
		
	
		
		Button b1 = new Button("Add Entry");
		super.addContent(b1);
		
		

		

	}

}
