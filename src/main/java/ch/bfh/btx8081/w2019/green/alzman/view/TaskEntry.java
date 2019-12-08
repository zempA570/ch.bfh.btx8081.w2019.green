package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class TaskEntry extends TemplateView {

	public TaskEntry() {

		// Change title in header
		super.setHeaderTitle("Aufgabe einfügen");

		// Creating elements
		
		TextField newtask = new TextField();
		newtask.setLabel("Aufgabe");
		
		ComboBox<String> choice = new ComboBox<>("Wiederholung"); 
		choice.setItems("wöchentlich", "monatlich", "jährlich", "Keine");
		
		Label datum = new Label("Datum"); 
		DatePicker datePick = new DatePicker(); 
		datePick.setValue(LocalDate.now());
		
		
		// icon which can be clicked to clead the value
		datePick.setClearButtonVisible(true);
		
        //add button
		Button add = new Button ("add Note", new Icon(VaadinIcon.PLUS)); 
		

		// Creating horizontal layout
		HorizontalLayout adding = new HorizontalLayout(newtask, choice);
		VerticalLayout adding2 = new VerticalLayout(datum, datePick, add);


		// space
//		Label space2 = new Label("  "); 
//		HorizontalLayout spacing = new HorizontalLayout(space2); 
		
		
		// Adding components to content space
		super.addContent(adding);
		super.addContent(adding2);


	}

}
