package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
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

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
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
		super.addContent(btnImportantPer);

		// Accordion Component from Vaddin to show the list of the important persons
		Accordion accordion1 = new Accordion();
		
		//List of the members of the important person
		VerticalLayout importentNr = new VerticalLayout();
		importentNr.add(new Label("Geschlecht"), new Label("Name"),new Label("Vorname"), new Label("Telefonnummer"),
				new Label("Adresse"),new Label("Nr"), new Label("Platz"),new Label("Ort"), new Button("Delete"));
		accordion1.add("Hans Muster", importentNr);

		super.addContent(accordion1);
		
		//List of the members of the important person
		VerticalLayout importentNr1 = new VerticalLayout();
		importentNr1.add(new Label("Geschlecht"), new Label("Name"),new Label("Vorname"), new Label("Telefonnummer"),
				new Label("Adresse"),new Label("Nr"), new Label("Platz"),new Label("Ort"), new Button("Delete"));
		accordion1.add("Friz Hugo", importentNr1);

		super.addContent(accordion1);
		
		//Suptitel in H4 format for important adres
		title2 = new H4();
		title2.setText("Wichtige Adressen");
		super.addContent(title2);
		
		//Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adresse");
		super.addContent(btnImportantAdr);

		// Accordion Component from Vaddin to show the list of the important Adresses
		Accordion accordion2 = new Accordion();
		
		//List of the members of the important adres
		VerticalLayout importentAdr = new VerticalLayout();
		importentAdr.add(new Label("Name"), new Label("Adresse"), new Label("Nr"), new Label("Platz"), new Label("Ort"),
				new Label("Telefonnummer"), new Button("Delete"));
		accordion2.add("Inselspital", importentAdr);

		super.addContent(accordion2);
		
		//List of the members of the important adres
		VerticalLayout importentAdr1 = new VerticalLayout();
		importentAdr1.add(new Label("Name"), new Label("Adresse"), new Label("Nr"), new Label("Platz"),
				new Label("Ort"), new Label("Telefonnummer"), new Button("Delete"));
		accordion2.add("Hirslanden Klinik", importentAdr1);

	}

}
