package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxaddView extends TemplateView {

	public InfoboxaddView() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Radio Button for gender
		RadioButtonGroup<String> gender = new RadioButtonGroup<>();
		gender.setItems("Mann", "Frau");

		// Textfield for name
		TextField name = new TextField();
		name.setLabel("Name");

		// Textfield for prename
		TextField vorname = new TextField();
		vorname.setLabel("Vorname");

		// Textfield for telephone nummber
		TextField telNr = new TextField();
		telNr.setLabel("Telefonnummer");

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
		city.setLabel("Telefonnummer");

		// Button for add the person in the Infobox
		Button add = new Button("Add");

		// Button for cancel the prosses for to add person in the Infobox
		Button cancel = new Button("Cancel");

		VerticalLayout position1 = new VerticalLayout();
		position1.add(gender, name, vorname, telNr);

		HorizontalLayout position2 = new HorizontalLayout();
		position2.add(adress, adrNr);

		HorizontalLayout position3 = new HorizontalLayout();
		position3.add(plz, city);

		HorizontalLayout position4 = new HorizontalLayout();
		position4.add(add, cancel);
		

		super.addContent(position1);
		super.addContent(position2);
		super.addContent(position3);
		super.addContent(position4);

	}
}
