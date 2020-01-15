package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

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
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxAddAddressPresenter;

/**
 * This class implements the view that represents the add important address View.
 * The methods come from the InfoboxAddAddressView that also represents the interface class.
 * @author gausegan
 *
 */
@Route("AddAdressInfobox")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxAddAdressViewImpl extends TemplateView implements InfoboxAddAddressView {

	private List<InfoboxAddAdressListener> listeners = new ArrayList<InfoboxAddAdressListener>();

	// variabel for the suptitel Add Adress
	private H4 h4TitleAddress;
	private TextField txtfName;
	private TextField txtfAddress;
	private TextField txtfAddrNo;
	private TextField txtfPostcode;
	private TextField txtfCity;
	private TextField txtfPhoneNo;

	private Binder<AddressModel> bndrCheckAdress;
	private Label lblMessage;

	public InfoboxAddAdressViewImpl() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		h4TitleAddress = new H4();
		h4TitleAddress.setText("Add Adress");
		super.addContent(h4TitleAddress);

		// Textfield for name
		this.txtfName = new TextField("Name");

		// Textfield for adress
		this.txtfAddress = new TextField("Adress");

		// Textfield for adress
		this.txtfAddrNo = new TextField("Adress Number");

		// Textfield for pstcode
		this.txtfPostcode = new TextField("Postcode");
		txtfPostcode.setPlaceholder("3000");

		// Textfield for city
		this.txtfCity = new TextField("City");
		txtfCity.setPlaceholder("Bern");

		// Textfield for telephone nummber
		this.txtfPhoneNo = new TextField("Phonenummber");
		txtfPhoneNo.setPlaceholder("0041 xx xxx xx xx");

		this.lblMessage = new Label();

		this.bndrCheckAdress = new Binder<>();
		bndrCheckAdress.forField(txtfName).asRequired("The Name is missing!").bind(AddressModel::getName,
				AddressModel::setName);
		bndrCheckAdress.forField(txtfAddress).asRequired("The Adress is missing!").bind(AddressModel::getStreet,
				AddressModel::setStreet);
		bndrCheckAdress.forField(txtfAddrNo).asRequired("The Adress Number is missing!").bind(AddressModel::getHouseNo,
				AddressModel::setHouseNo);
		bndrCheckAdress.forField(txtfPostcode).asRequired("The Postcode is missing!").bind(AddressModel::getPostcode,
				AddressModel::setPostcode);
		bndrCheckAdress.forField(txtfCity).asRequired("The City is missing!").bind(AddressModel::getCity,
				AddressModel::setCity);
		bndrCheckAdress.forField(txtfPhoneNo).asRequired("The Phonenummber is missing!")
				.bind(AddressModel::getPhonenumber, AddressModel::setPhonenummber);

		// Button for add the adress in the Infobox

		Button btnAdd = new Button("Add Address", new Icon(VaadinIcon.PLUS));
		btnAdd.addClickListener(e -> {
			if (bndrCheckAdress.isValid()) {
				for (InfoboxAddAdressListener listener : listeners) {
					listener.buttonClick(e.getSource());
				}
			} else {
				bndrCheckAdress.validate();
				lblMessage.setText("Something is wrong!");
			}
		});

		// Button for cancel the prosses for to add the adress in the Infobox
		Button btnCancel = new Button("Cancel");
		btnCancel.addClickListener(event -> {
			for (InfoboxAddAdressListener listener : listeners)
				listener.buttonClick(event.getSource());
		});

		HorizontalLayout hlNamePos = new HorizontalLayout();
		hlNamePos.add(txtfName);

		HorizontalLayout hlAddressPos = new HorizontalLayout();
		hlAddressPos.add(txtfAddress, txtfAddrNo);

		HorizontalLayout hlCityPos = new HorizontalLayout();
		hlCityPos.add(txtfPostcode, txtfCity);

		HorizontalLayout hlPhoneNoPos = new HorizontalLayout();
		hlPhoneNoPos.add(txtfPhoneNo);

		HorizontalLayout hlButtonPos = new HorizontalLayout();
		hlButtonPos.add(btnAdd, btnCancel, lblMessage);

		VerticalLayout vlEndPos = new VerticalLayout();
		vlEndPos.add(hlNamePos, hlAddressPos, hlCityPos, hlPhoneNoPos, hlButtonPos);

		// add the contents one the View
		super.addContent(vlEndPos);

		new InfoboxAddAddressPresenter(this);
	}

	@Override
	public void addListener(InfoboxAddAdressListener listener) {
		listeners.add(listener);
	}

	@Override
	public AddressModel getAdressFromField() {

		AddressModel newAdress = new AddressModel();

		newAdress.setStreet(txtfAddress.getValue());
		newAdress.setHouseNo(txtfAddrNo.getValue());
		newAdress.setCity(txtfCity.getValue());
		newAdress.setName(txtfName.getValue());
		newAdress.setPhonenummber(txtfPhoneNo.getValue());
		newAdress.setPostcode(txtfPostcode.getValue());

		return newAdress;
	}

}
