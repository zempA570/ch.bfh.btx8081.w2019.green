package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("AddImportantNotes")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddImportantNotes extends TemplateView {

	public AddImportantNotes() {

		// Change title in header
		super.setHeaderTitle("Add Important Notes");
		
		//Label and a Textfield
		TextField author = new TextField();
		author.setLabel("Author");
		
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());

		// Display an icon which can be clicked to clear the value:
		datePicker.setClearButtonVisible(true);
		
		TextArea textArea = new TextArea("Notes");
		textArea.getStyle().set("minHeight", "250px");
		textArea.setPlaceholder("Write here ...");
		

		
		Button btnAddIN = new Button("Add Notes", new Icon(VaadinIcon.PLUS));

		// Put components in horizontal layout
		HorizontalLayout addIN = new HorizontalLayout();
		addIN.setAlignItems(Alignment.BASELINE);
		addIN.add(author, datePicker);

		HorizontalLayout addIN2 = new HorizontalLayout();
		addIN2.setAlignItems(Alignment.BASELINE);
		addIN2.add(textArea, btnAddIN);

		// Adding components to content space
		super.addContent(addIN);
		super.addContent(addIN2);
		
		
	
	}

}
