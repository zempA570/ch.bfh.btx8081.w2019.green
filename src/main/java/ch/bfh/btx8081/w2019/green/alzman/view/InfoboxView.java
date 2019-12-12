package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.Person;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxView extends TemplateView {

	private H4 title1;
	private H4 title2;

	public InfoboxView() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Subtitel in H4 format
		title1 = new H4();
		title1.setText("Wichtige Personen");
		super.addContent(title1);

		// Button for to Add a important Person
		Button btnImportantPer = new Button("Add User");
		btnImportantPer.addClickListener(event -> UI.getCurrent().navigate(AddPersonInfoboxView.class));
		super.addContent(btnImportantPer);

/*
 	
 	List<Person> personList = new ArrayList<>();

		personList.add(new Person(100, "Lucas", "Kane", 68));

		personList.add(new Person(101, "Peter", "Buchanan", 38));

		personList.add(new Person(102, "Samuel", "Lee", 53));

		personList.add(new Person(103, "Anton", "Ross", 37));

		personList.add(new Person(104, "Aaron", "Atkinson", 18));

		personList.add(new Person(105, "Jack", "Woodward", 28));

		Grid<Person> grid = new Grid<>(Person.class);
		grid.setItems(personList);
		//grid.removeColumnByKey("id");

		grid.setColumns("firstName", "lastName", "age");

		super.add(grid);
		
 */
	

		// Suptitel in H4 format for important adres
		title2 = new H4();
		title2.setText("Wichtige Adressen");
		super.addContent(title2);

		// Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adresse");
		btnImportantAdr.addClickListener(event -> UI.getCurrent().navigate(AddAdressInfoboxView.class));
		super.addContent(btnImportantAdr);

	}

}
