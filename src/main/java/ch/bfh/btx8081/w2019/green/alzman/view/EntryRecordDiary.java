package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */

@Route("EntryRecordDiary")


@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class EntryRecordDiary extends TemplateView {

	public EntryRecordDiary() {


		super.setHeaderTitle("Entry Record");

		super.setHeaderTitle("Entry Record Diary");

		
		//Creating a new Datepicker.  
		DatePicker datePicker = new DatePicker();
		datePicker.setLabel("Date");
		datePicker.setPlaceholder("Select a Date");
		
		//Creating a new Textarea
		TextArea textArea = new TextArea("Comment");
		textArea.setPlaceholder("Write here  ...");
		textArea.setLabel("Geschrieben von..");
		
		//Creating a new Button
		Button button = new Button("Add new Record", new Icon(VaadinIcon.PLUS));
		
		//Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout(datePicker, textArea,button);
		
		//Adding components to content space
		super.addContent(verticalLayout);

	}
}
