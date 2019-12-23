package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
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
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.presenter.AddPersonPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.UserManagementPresenter;

@Route("AddPersonInfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddPersonInfoboxView extends TemplateView {

	// variabel for the suptitel Add person
	private H4 title1;
	private RadioButtonGroup gender;
	private TextField lastName;
	private TextField firstName;
	private TextField phoneNo;
	private TextField adress;
	private TextField adrNo;
	private TextField postcode;
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
		this.gender = new RadioButtonGroup<>();
		gender.setItems("Mr", "Mrs");

		// Textfield for name
		this.lastName = new TextField("Lastname");


		// Textfield for prename
		this.firstName = new TextField("Firstname");
		

		// Textfield for telephone nummber
		this.phoneNo = new TextField("Phonenummber");
	

		// Textfield for adress
		this.adress = new TextField("Adress");


		// Textfield for adress
		this.adrNo = new TextField("Adress Number");
		

		// Textfield for pstcode
		this.postcode = new TextField("Postcode");


		// Textfield for city
		this.city = new TextField("City");


		// Button for add the person in the Infobox
		Button addPerson = new Button("Add Person", new Icon(VaadinIcon.PLUS));
		addPerson.addClickListener(
				e -> addPersonPresenter.addPerson(gender.getValue().toString(), lastName.getValue(), firstName.getValue(),
						adress.getValue(), adrNo.getValue(), postcode.getValue(), city.getValue(), phoneNo.getValue()));
		addPerson.addClickListener(event -> UI.getCurrent().navigate(InfoboxView.class));

		// Button for cancel the prosses for to add person in the Infobox
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addClickListener(event -> UI.getCurrent().navigate(InfoboxView.class));

		HorizontalLayout genderPos = new HorizontalLayout();
		genderPos.add(gender);

		HorizontalLayout namePos = new HorizontalLayout();
		namePos.add(lastName, firstName);

		HorizontalLayout adressPos = new HorizontalLayout();
		adressPos.add(adress, adrNo);

		HorizontalLayout cityPos = new HorizontalLayout();
		cityPos.add(postcode, city);

		HorizontalLayout phoneNoPos = new HorizontalLayout();
		phoneNoPos.add(phoneNo);

		HorizontalLayout buttonPos = new HorizontalLayout();
		buttonPos.add(addPerson, cancelBtn);

		VerticalLayout endPos = new VerticalLayout();
		endPos.add(genderPos, namePos, adressPos, cityPos, phoneNoPos, buttonPos);

		// add the contents in the View
		super.addContent(endPos);
		
		addPersonPresenter = new AddPersonPresenter(this);

	}

}
