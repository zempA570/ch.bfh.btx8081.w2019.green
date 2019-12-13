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

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.presenter.AdressService;
import ch.bfh.btx8081.w2019.green.alzman.presenter.PersonService;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxView extends TemplateView {

	private H4 title1;
	private H4 title2;
	//private Grid<String> gridPerson;
	//private Grid<String> gridAdress;
	
	

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
		
		//Test
		final PersonService service = new PersonService();
		

		final List<AddPerson> persons = service.getAllPersons();
		
		final Grid<AddPerson> persongrid = new Grid<>();
		add(persongrid);
		persongrid.setItems(persons);
		
		persongrid.addColumn(AddPerson::getGender).setHeader("Gender");
		persongrid.addColumn(AddPerson::getFirstname).setHeader("Firstname");
		persongrid.addColumn(AddPerson::getLastname).setHeader("Lastname");
		persongrid.addColumn(AddPerson::getAdress).setHeader("Adress");
		persongrid.addColumn(AddPerson::getAdressNr).setHeader("Nr");
		persongrid.addColumn(AddPerson::getPostcode).setHeader("Postcode");
		persongrid.addColumn(AddPerson::getCity).setHeader("City");
		persongrid.addColumn(AddPerson::getPhonenummber).setHeader("Phonenummber");
		
		super.addContent(persongrid);
	
		// Suptitel in H4 format for important adres
		title2 = new H4();
		title2.setText("Wichtige Adressen");
		super.addContent(title2);

		// Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adresse");
		btnImportantAdr.addClickListener(event -> UI.getCurrent().navigate(AddAdressInfoboxView.class));
		super.addContent(btnImportantAdr);

		final AdressService services = new AdressService();
		final List<AddAdress> adresses = services.getAllAdress();
		final Grid<AddAdress> adressgrid = new Grid<>();
		add(adressgrid);
		adressgrid.setItems(adresses);
		

		adressgrid.addColumn(AddAdress::getName).setHeader("Name");
		adressgrid.addColumn(AddAdress::getAdress).setHeader("Adress");
		adressgrid.addColumn(AddAdress::getAdressNr).setHeader("Nr");
		adressgrid.addColumn(AddAdress::getPostcode).setHeader("Postcode");
		adressgrid.addColumn(AddAdress::getCity).setHeader("City");
		adressgrid.addColumn(AddAdress::getPhonenummber).setHeader("Phonenummber");
		
		super.addContent(adressgrid);

	}
/*
 * 

	public void fillGridWithPerson(List<String> person) {

		gridPerson.setItems(person);
		
	}
*/
}
