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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.AddAdressPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.AddPersonPresenter;

@Route("AddAdressInfobox")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddAdressInfoboxView extends TemplateView {

	// variabel for the suptitel Add Adress
	private H4 title1;
	private TextField name;
	private TextField adress;
	private TextField adrNo;
	private TextField postcode;
	private TextField city;
	private TextField phoneNo;

	private AddAdressPresenter addAdressPresenter;

	public AddAdressInfoboxView() {

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

		// Textfield for city
		this.city = new TextField("City");

		// Textfield for telephone nummber
		this.phoneNo = new TextField("Phonenummber");

		// Button for add the adress in the Infobox
		Button addAdress = new Button("Add Adress", new Icon(VaadinIcon.PLUS));
		addAdress.addClickListener(e -> addAdressPresenter.addAdress(name.getValue(), adress.getValue(),
				adrNo.getValue(), postcode.getValue(), city.getValue(), phoneNo.getValue()));
		addAdress.addClickListener(event -> UI.getCurrent().navigate(InfoboxView.class));

		// Button for cancel the prosses for to add the adress in the Infobox
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addClickListener(event -> UI.getCurrent().navigate(InfoboxView.class));

		HorizontalLayout namePos = new HorizontalLayout();
		namePos.add(name);

		HorizontalLayout adressPos = new HorizontalLayout();
		adressPos.add(adress, adrNo);

		HorizontalLayout cityPos = new HorizontalLayout();
		cityPos.add(postcode, city);

		HorizontalLayout phoneNoPos = new HorizontalLayout();
		phoneNoPos.add(phoneNo);

		HorizontalLayout buttonPos = new HorizontalLayout();
		buttonPos.add(addAdress, cancelBtn);

		VerticalLayout endPos = new VerticalLayout();
		endPos.add(namePos, adressPos, cityPos, phoneNoPos, buttonPos);

		// add the contents one the View
		super.addContent(endPos);

		addAdressPresenter = new AddAdressPresenter(this);
	}


}
