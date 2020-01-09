package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
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

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxAddAdressPresenter;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxAddPersonView.InfoboxAddPersonListener;

@Route("AddAdressInfobox")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxAddAdressViewImpl extends TemplateView implements InfoboxAddAdressView {

	private List<InfoboxAddAdressListener> listeners = new ArrayList<InfoboxAddAdressListener>();

	// variabel for the suptitel Add Adress
	private H4 title1;
	private TextField name;
	private TextField adress;
	private TextField adrNo;
	private TextField postcode;
	private TextField city;
	private TextField phoneNo;

	private Binder<AddAdress> binderCheckAdress;
	private Label label;

	public InfoboxAddAdressViewImpl() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		title1 = new H4();
		title1.setText("Add Adress");
		super.addContent(title1);

		// Textfield for name
		this.name = new TextField("Name");

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

		// Textfield for telephone nummber
		this.phoneNo = new TextField("Phonenummber");
		phoneNo.setPlaceholder("0041 xx xxx xx xx");

		this.label = new Label();

		this.binderCheckAdress = new Binder<>();
		binderCheckAdress.forField(name).asRequired("The Name is missing!").bind(AddAdress::getName,
				AddAdress::setName);
		binderCheckAdress.forField(adress).asRequired("The Adress is missing!").bind(AddAdress::getAdress,
				AddAdress::setAdress);
		binderCheckAdress.forField(adrNo).asRequired("The Adress Number is missing!").bind(AddAdress::getAdressNr,
				AddAdress::setAdressNr);
		binderCheckAdress.forField(postcode).asRequired("The Postcode is missing!").bind(AddAdress::getPostcode,
				AddAdress::setPostcode);
		binderCheckAdress.forField(city).asRequired("The City is missing!").bind(AddAdress::getCity,
				AddAdress::setCity);
		binderCheckAdress.forField(phoneNo).asRequired("The Phonenumber is missing!").bind(AddAdress::getPhonenummber,
				AddAdress::setPhonenummber);

		// Button for add the adress in the Infobox

		Button addAdress = new Button("Add Adress", new Icon(VaadinIcon.PLUS));
		addAdress.addClickListener(e -> {
			if (binderCheckAdress.isValid()) {
				for (InfoboxAddAdressListener listener : listeners) {
					listener.buttonClick(e.getSource());
				}
			} else {
				binderCheckAdress.validate();
				label.setText("An error has occurred");
			}
		});

		// Button for cancel the prosses for to add the adress in the Infobox
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addClickListener(event -> {
			for (InfoboxAddAdressListener listener : listeners)
				listener.buttonClick(event.getSource());
		});

		HorizontalLayout namePos = new HorizontalLayout();
		namePos.add(name);

		HorizontalLayout adressPos = new HorizontalLayout();
		adressPos.add(adress, adrNo);

		HorizontalLayout cityPos = new HorizontalLayout();
		cityPos.add(postcode, city);

		HorizontalLayout phoneNoPos = new HorizontalLayout();
		phoneNoPos.add(phoneNo);

		HorizontalLayout buttonPos = new HorizontalLayout();
		buttonPos.add(addAdress, cancelBtn, label);

		VerticalLayout endPos = new VerticalLayout();
		endPos.add(namePos, adressPos, cityPos, phoneNoPos, buttonPos);

		// add the contents one the View
		super.addContent(endPos);

		new InfoboxAddAdressPresenter(this);
	}

	@Override
	public void addListener(InfoboxAddAdressListener listener) {
		listeners.add(listener);
	}

	@Override
	public AddAdress getAdressFromFields() {
		
		AddAdress newAdress = new AddAdress();
		
		newAdress.setAdress(adress.getValue());
		newAdress.setAdressNr(adrNo.getValue());
		newAdress.setCity(city.getValue());
		newAdress.setName(name.getValue());
		newAdress.setPhonenummber(phoneNo.getValue());
		newAdress.setPostcode(postcode.getValue());
		
		return newAdress;
	}

}
