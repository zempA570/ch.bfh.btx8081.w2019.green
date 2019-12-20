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
	private TextField adrNr;
	private TextField plz;
	private TextField city;
	private TextField telNr;

	private AddAdressPresenter addAdressPresenter;

	public AddAdressInfoboxView() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		title1 = new H4();
		title1.setText("Add Adress");
		super.addContent(title1);

		// Textfield for name
		TextField name = new TextField("Name");

		// Textfield for adress
		TextField adress = new TextField("Adresse");

		// Textfield for adress
		TextField adrNr = new TextField("Nr");

		// Textfield for pstcode
		TextField plz = new TextField("Platz");

		// Textfield for city
		TextField city = new TextField("Ort");

		// Textfield for telephone nummber
		TextField telNr = new TextField("Telefonnummer");

		// Button for add the adress in the Infobox
		Button addAdress = new Button("Add", new Icon(VaadinIcon.PLUS));
		addAdress.addClickListener(e -> addAdressPresenter.addAdress(name.getValue(), adress.getValue(),
				adrNr.getValue(), plz.getValue(), city.getValue(), telNr.getValue()));
		addAdress.addClickListener(event -> UI.getCurrent().navigate(InfoboxView.class));

		// Button for cancel the prosses for to add the adress in the Infobox
		Button cancel = new Button("Cancel");

		HorizontalLayout position1 = new HorizontalLayout();
		position1.add(name);

		HorizontalLayout position2 = new HorizontalLayout();
		position2.add(adress, adrNr);

		HorizontalLayout position3 = new HorizontalLayout();
		position3.add(plz, city);

		HorizontalLayout position4 = new HorizontalLayout();
		position4.add(telNr);

		HorizontalLayout position5 = new HorizontalLayout();
		position5.add(addAdress, cancel);

		VerticalLayout ende = new VerticalLayout();
		ende.add(position1, position2, position3, position4, position5);

		// add the contents one the View
		super.addContent(ende);

		addAdressPresenter = new AddAdressPresenter(this);
	}

	public void clearTextfieldsAdresse() {
		name.clear();
		adress.clear();
		adrNr.clear();
		plz.clear();
		city.clear();
		telNr.clear();

	}

}
