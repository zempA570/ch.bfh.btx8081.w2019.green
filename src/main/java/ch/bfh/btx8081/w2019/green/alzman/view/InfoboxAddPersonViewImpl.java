package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxAddPersonPresenter;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView.UserManagagementViewListener;

@Route("AddPersonInfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxAddPersonViewImpl extends TemplateView implements InfoboxAddPersonView {

	private List<InfoboxAddPersonListener> listeners = new ArrayList<InfoboxAddPersonListener>();

	// variabel for the suptitel Add person
	private H4 title1;
	private ComboBox<String> gender;
	private TextField lastName;
	private TextField firstName;
	private TextField phoneNo;
	private TextField adress;
	private TextField adrNo;
	private TextField postcode;
	private TextField city;

	private Binder<AddPerson> binderCheckPerson;
	private Label label;

	public InfoboxAddPersonViewImpl() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		title1 = new H4();
		title1.setText("Add Person");
		super.addContent(title1);

		// Radio Button for gender
		this.gender = new ComboBox<String>();
		gender.setItems("Mr", "Mrs");
		gender.setPlaceholder("Select your gender");

		// Textfield for name
		this.lastName = new TextField("Lastname");

		// Textfield for prename
		this.firstName = new TextField("Firstname");

		// Textfield for telephone nummber
		this.phoneNo = new TextField("Phonenummber");
		phoneNo.setPlaceholder("0041 xx xxx xx xx");

		// Textfield for adress
		this.adress = new TextField("Adress");

		// Textfield for adress
		this.adrNo = new TextField("Adress Number");

		// Textfield for pstcode
		this.postcode = new TextField("Postcode");
		postcode.setPlaceholder("3000");

		// Textfield for city
		this.city = new TextField("City");
		city.setPlaceholder("Bern");

		this.label = new Label();

		this.binderCheckPerson = new Binder<>();
		binderCheckPerson.forField(gender).asRequired("The Gender is missing!").bind(AddPerson::getGender,
				AddPerson::setGender);
		binderCheckPerson.forField(lastName).asRequired("The Lastname is missing!").bind(AddPerson::getLastname,
				AddPerson::setLastname);
		binderCheckPerson.forField(firstName).asRequired("The Firstname is missing!").bind(AddPerson::getFirstname,
				AddPerson::setFirstname);
		binderCheckPerson.forField(phoneNo).asRequired("The Phonenumber is missing!").bind(AddPerson::getPhonenummber,
				AddPerson::setPhonenummber);
		binderCheckPerson.forField(adress).asRequired("The Adress is missing!").bind(AddPerson::getAdress,
				AddPerson::setAdress);
		binderCheckPerson.forField(adrNo).asRequired("The Adress Number is missing!").bind(AddPerson::getAdressNr,
				AddPerson::setAdressNr);
		binderCheckPerson.forField(postcode).asRequired("The Postcode is missing!").bind(AddPerson::getPostcode,
				AddPerson::setPostcode);
		binderCheckPerson.forField(city).asRequired("The City is missing!").bind(AddPerson::getCity,
				AddPerson::setCity);

		// Button for add the person in the Infobox
		Button addPerson = new Button("Add Person", new Icon(VaadinIcon.PLUS));
		addPerson.addClickListener(e -> {

			if (binderCheckPerson.isValid()) {
				for (InfoboxAddPersonListener listener : listeners) {
					listener.buttonClick(e.getSource());
				}
			} else {
				binderCheckPerson.validate();
				label.setText("An error has occurred");
			}

		});

		// Button for cancel the prosses for to add person in the Infobox
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addClickListener(event -> {
			for (InfoboxAddPersonListener listener : listeners)
				listener.buttonClick(event.getSource());
		});

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
		buttonPos.add(addPerson, cancelBtn, label);

		VerticalLayout endPos = new VerticalLayout();
		endPos.add(genderPos, namePos, adressPos, cityPos, phoneNoPos, buttonPos);

		// add the contents in the View
		super.addContent(endPos);

		new InfoboxAddPersonPresenter(this);

	}

	@Override
	public void addListener(InfoboxAddPersonListener listener) {
		listeners.add(listener);
	}

	@Override
	public AddPerson getPersonFromFields() {

		AddPerson person = new AddPerson();

		person.setAdress(adress.getValue());
		person.setAdressNr(adrNo.getValue());
		person.setCity(city.getValue());
		person.setFirstname(firstName.getValue());
		person.setLastname(lastName.getValue());
		person.setGender(gender.getValue().toString());
		person.setPhonenummber(phoneNo.getValue());
		person.setPostcode(postcode.getValue());

		return person;
	}

}
