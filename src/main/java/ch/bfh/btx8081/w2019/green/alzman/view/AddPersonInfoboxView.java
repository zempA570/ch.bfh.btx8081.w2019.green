package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.AddPersonPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.UserManagementPresenter;

@Route("AddPersonInfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddPersonInfoboxView extends TemplateView {

	// variabel for the suptitel Add person
	private H4 title1;
	private RadioButtonGroup gender;
	private TextField name;
	private TextField vorname;
	private TextField telNr;
	private TextField adress;
	private TextField adrNr;
	private TextField plz;
	private TextField city;

	private AddPersonPresenter addPersonPresenter;

	public AddPersonInfoboxView() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		title1 = new H4();
		title1.setText("Add Person");
		super.addContent(title1);

		// Radio Button for gender
		gender = new RadioButtonGroup<>();
		gender.setItems("Mann", "Frau");

		// Textfield for name
		name = new TextField("Name");


		// Textfield for prename
		vorname = new TextField("Vorname");
		

		// Textfield for telephone nummber
		telNr = new TextField("Telefonnummer");
	

		// Textfield for adress
		adress = new TextField("Adresse");


		// Textfield for adress
		adrNr = new TextField("Nr");
		

		// Textfield for pstcode
		plz = new TextField("Platz");


		// Textfield for city
		city = new TextField("Ort");


		// Button for add the person in the Infobox
		Button addPerson = new Button("Add Person", new Icon(VaadinIcon.PLUS));
		addPerson.addClickListener(
				e -> addPersonPresenter.addPerson(gender.getValue().toString(), name.getValue(), vorname.getValue(),
						adress.getValue(), adrNr.getValue(), plz.getValue(), city.getValue(), telNr.getValue()));

		// Button for cancel the prosses for to add person in the Infobox
		Button cancel = new Button("Cancel");

		HorizontalLayout position1 = new HorizontalLayout();
		position1.add(gender);

		HorizontalLayout position2 = new HorizontalLayout();
		position2.add(name, vorname);

		HorizontalLayout position3 = new HorizontalLayout();
		position3.add(adress, adrNr);

		HorizontalLayout position4 = new HorizontalLayout();
		position4.add(plz, city);

		HorizontalLayout position5 = new HorizontalLayout();
		position5.add(telNr);

		HorizontalLayout position6 = new HorizontalLayout();
		position6.add(addPerson, cancel);

		VerticalLayout ende = new VerticalLayout();
		ende.add(position1, position2, position3, position4, position5, position6);

		// add the contents in the View
		super.addContent(ende);
		
		addPersonPresenter = new AddPersonPresenter(this);

	}

	public void clearTextfieldsPerson() {
		gender.clear();
		name.clear();
		vorname.clear();
		telNr.clear();
		adress.clear();
		adrNr.clear();
		plz.clear();
		city.clear();

	}
}
