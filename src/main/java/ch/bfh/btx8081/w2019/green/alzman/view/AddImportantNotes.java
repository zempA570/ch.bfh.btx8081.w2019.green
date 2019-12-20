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

import ch.bfh.btx8081.w2019.green.alzman.model.ImportantNotesDataModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("AddImportantNotes")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddImportantNotes extends TemplateView {

	DatePicker datePicker = new DatePicker();
	TextArea textArea = new TextArea("Notes");

	public AddImportantNotes() {

		// Change title in header
		super.setHeaderTitle("Add Important Notes");
		
		//Label and a Textfield
		TextField author = new TextField();
		author.setLabel("Author");
		
		
		datePicker.setValue(LocalDate.now());

		// Display an icon which can be clicked to clear the value:
		datePicker.setClearButtonVisible(true);
		
		
		textArea.getStyle().set("minHeight", "250px");
		textArea.setPlaceholder("Write here ...");
		

		// Buttons to be clickd on
		Button AddToDiary = new Button("Add To Diary", new Icon(VaadinIcon.PLUS));
		Button AddToKeyNotes = new Button("Add to Key-Notes", new Icon(VaadinIcon.PLUS));
		Button AddToBoth = new Button ("Add To Both", new Icon(VaadinIcon.PLUS));
		
		//Click Listener that triggers an Event for Add-To-Key-Notes-Button
		AddToKeyNotes.addClickListener(e -> addNotesDB());
		

		// Put components in horizontal layout
		HorizontalLayout addIN = new HorizontalLayout();
		addIN.setAlignItems(Alignment.BASELINE);
		addIN.add(author, datePicker);

		HorizontalLayout addIN2 = new HorizontalLayout();
		addIN2.setAlignItems(Alignment.BASELINE);
		addIN2.add(textArea, AddToDiary, AddToKeyNotes, AddToBoth);

		// Adding components to content space
		super.addContent(addIN);
		super.addContent(addIN2);
		


	
	}

	private void addNotesDB() {

		// get Infos from Interface elements to add to Database
		ImportantNotesDataModel notesToSave = new ImportantNotesDataModel();
		notesToSave.setEntryDate(datePicker.getValue());

		notesToSave.setEntryContent(textArea.getValue());
		notesToSave.setAuthor("Bibi Blocksberg");

		// method to add a note to the Database
		DbService.em.getTransaction().begin();
		DbService.em.persist(notesToSave);
		DbService.em.getTransaction().commit();

	};

}
