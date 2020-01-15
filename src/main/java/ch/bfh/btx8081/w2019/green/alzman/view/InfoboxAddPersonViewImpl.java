package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

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
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxAddPersonPresenter;

/**
 * This class implements the view that represents the add important Person View.
 * The methods come from the InfoboxAddPersonView that also represents the interface class.
 * @author gausegan
 *
 */

@Route("infoboxaddperson")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxAddPersonViewImpl extends TemplateView implements InfoboxAddPersonView {

	private List<InfoboxAddPersonListener> listeners = new ArrayList<InfoboxAddPersonListener>();

	// variabel for the suptitel Add person
	private H4 h4TitlePerson;
	private ComboBox<String> cmbbxGender;
	private TextField txtfLastName;
	private TextField txtfFirstName;
	private TextField txtfPhoneNo;
	private TextField txtfStreet;
	private TextField txtfHouseNo;
	private TextField txtfPostcode;
	private TextField txtfCity;

	private Binder<PersonModel> bndrCheckPerson;
	private Label lblMessage;

	public InfoboxAddPersonViewImpl() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		h4TitlePerson = new H4();
		h4TitlePerson.setText("Add Person");
		super.addContent(h4TitlePerson);

		// Radio Button for gender
		this.cmbbxGender = new ComboBox<String>();
		cmbbxGender.setItems("Mr", "Mrs");
		cmbbxGender.setPlaceholder("Select your gender");

		// Textfield for name
		this.txtfLastName = new TextField("Lastname");

		// Textfield for prename
		this.txtfFirstName = new TextField("Firstname");

		// Textfield for telephone nummber
		this.txtfPhoneNo = new TextField("Phonenumber");
		txtfPhoneNo.setPlaceholder("0041 xx xxx xx xx");

		// Textfield for adress
		this.txtfStreet = new TextField("Street");

		// Textfield for adress
		this.txtfHouseNo = new TextField("House Number");

		// Textfield for pstcode
		this.txtfPostcode = new TextField("Postcode");
		txtfPostcode.setPlaceholder("3000");

		// Textfield for city
		this.txtfCity = new TextField("City");
		txtfCity.setPlaceholder("Bern");

		this.lblMessage = new Label();

		this.bndrCheckPerson = new Binder<>();
		bndrCheckPerson.forField(cmbbxGender).asRequired("The Gender is missing!").bind(PersonModel::getGender,
				PersonModel::setGender);
		bndrCheckPerson.forField(txtfLastName).asRequired("The Lastname is missing!").bind(PersonModel::getLastname,
				PersonModel::setLastname);
		bndrCheckPerson.forField(txtfFirstName).asRequired("The Firstname is missing!").bind(PersonModel::getFirstname,
				PersonModel::setFirstname);
		bndrCheckPerson.forField(txtfPhoneNo).asRequired("The Phonenumber is missing!")
				.bind(PersonModel::getPhonenumber, PersonModel::setPhonenumber);
		bndrCheckPerson.forField(txtfStreet).asRequired("The Street is missing!").bind(PersonModel::getStreet,
				PersonModel::setStreet);
		bndrCheckPerson.forField(txtfHouseNo).asRequired("The House Number is missing!").bind(PersonModel::getHouseNo,
				PersonModel::setHouseNo);
		bndrCheckPerson.forField(txtfPostcode).asRequired("The Postcode is missing!").bind(PersonModel::getPostcode,
				PersonModel::setPostcode);
		bndrCheckPerson.forField(txtfCity).asRequired("The City is missing!").bind(PersonModel::getCity,
				PersonModel::setCity);

		// Button for add the person in the Infobox
		Button btnAdd = new Button("Add Person", new Icon(VaadinIcon.PLUS));
		btnAdd.addClickListener(e -> {

			if (bndrCheckPerson.isValid()) {
				for (InfoboxAddPersonListener listener : listeners) {
					listener.buttonClick(e.getSource());
				}
			} else {
				bndrCheckPerson.validate();
				lblMessage.setText("Something is wrong");

			}

		});

		// Button for cancel the prosses for to add person in the Infobox
		Button btnCancel = new Button("Cancel");
		btnCancel.addClickListener(event -> {
			for (InfoboxAddPersonListener listener : listeners)
				listener.buttonClick(event.getSource());
		});

		HorizontalLayout hlGenderPos = new HorizontalLayout();
		hlGenderPos.add(cmbbxGender);

		HorizontalLayout hlNamePos = new HorizontalLayout();
		hlNamePos.add(txtfLastName, txtfFirstName);

		HorizontalLayout hlAddressPos = new HorizontalLayout();
		hlAddressPos.add(txtfStreet, txtfHouseNo);

		HorizontalLayout hlCityPos = new HorizontalLayout();
		hlCityPos.add(txtfPostcode, txtfCity);

		HorizontalLayout hlPhoneNoPos = new HorizontalLayout();
		hlPhoneNoPos.add(txtfPhoneNo);

		HorizontalLayout hlButtonPos = new HorizontalLayout();
		hlButtonPos.add(btnAdd, btnCancel, lblMessage);

		VerticalLayout vlEndPos = new VerticalLayout();
		vlEndPos.add(hlGenderPos, hlNamePos, hlAddressPos, hlCityPos, hlPhoneNoPos, hlButtonPos);

		// add the contents in the View
		super.addContent(vlEndPos);

		new InfoboxAddPersonPresenter(this);
	}

	@Override
	public void addListener(InfoboxAddPersonListener listener) {
		listeners.add(listener);
	}

	@Override
	public PersonModel getPersonFromField() {
		PersonModel person = new PersonModel();
		person.setStreet(txtfStreet.getValue());
		person.setHouseNo(txtfHouseNo.getValue());
		person.setCity(txtfCity.getValue());
		person.setFirstname(txtfFirstName.getValue());
		person.setLastname(txtfLastName.getValue());
		person.setGender(cmbbxGender.getValue().toString());
		person.setPhonenumber(txtfPhoneNo.getValue());
		person.setPostcode(txtfPostcode.getValue());
		return person;
	}

}
