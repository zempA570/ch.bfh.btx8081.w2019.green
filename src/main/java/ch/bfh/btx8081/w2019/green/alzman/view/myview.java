package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class myview extends TemplateView {

	public myview() {

		DatePicker datePicker = new DatePicker();
		datePicker.setLabel("Select a day within this month");
		datePicker.setPlaceholder("Date within this month");

		LocalDate now = LocalDate.now();

		datePicker.setMin(now.withDayOfMonth(1));
		datePicker.setMax(now.withDayOfMonth(now.lengthOfMonth()));

		TextArea textArea = new TextArea("Description");
		textArea.setPlaceholder("Write here ...");
		
		Button button = new Button();	
		super.addContent(button);
		super.addContent(datePicker);
		super.addContent(textArea);	
	}
}
