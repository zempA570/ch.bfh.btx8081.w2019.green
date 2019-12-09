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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("AddAdressInfobox")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class AddAdressInfobox extends TemplateView {

	// variabel for the suptitel Add Adress
	private H4 title1;

	public AddAdressInfobox() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Titel for add a person
		title1 = new H4();
		title1.setText("Add Adress");
		super.addContent(title1);

		// Textfield for name
		TextField name = new TextField();
		name.setLabel("Name");

		// Textfield for adress
		TextField adress = new TextField();
		adress.setLabel("Adresse");

		// Textfield for adress
		TextField adrNr = new TextField();
		adrNr.setLabel("Nr");

		// Textfield for pstcode
		TextField plz = new TextField();
		plz.setLabel("Platz");

		// Textfield for city
		TextField city = new TextField();
		city.setLabel("Ort");

		// Textfield for telephone nummber
		TextField telNr = new TextField();
		telNr.setLabel("Telefonnummer");

		// Button for add the adress in the Infobox
		Button add = new Button("Add");

		// Button for cancel the prosses for to add the adress in the Infobox
		Button cancel = new Button("Cancel");

		// the name will be in the first position
		VerticalLayout position1 = new VerticalLayout();
		position1.add(name);

		// the adresse and adress number will be in the second position because the
		// items are next by
		HorizontalLayout position2 = new HorizontalLayout();
		position2.add(adress, adrNr);

		// the postcode and city will be in the third position because the items are
		// under adress and adress number and the items are next by
		HorizontalLayout position3 = new HorizontalLayout();
		position3.add(plz, city);

		// the telephone number will be in the fourt position
		VerticalLayout position4 = new VerticalLayout();
		position4.add(telNr);

		// the Buttons are under postcode and city, the items are next by
		HorizontalLayout position5 = new HorizontalLayout();
		position5.add(add, cancel);

		// add the four contents
		super.addContent(position1);
		super.addContent(position2);
		super.addContent(position3);
		super.addContent(position4);

	}

}