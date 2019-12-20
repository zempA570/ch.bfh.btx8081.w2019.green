package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.presenter.AddPersonPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxPresenter;

@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxView extends TemplateView {

	private H4 title1;
	private H4 title2;

	private Grid<AddPerson> persongrid = new Grid<>();
	private Grid<AddAdress> adressgrid = new Grid<>();

	private InfoboxPresenter presenter;

	private AddPerson addPerson;

	public InfoboxView() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Subtitel in H4 format
		title1 = new H4();
		title1.setText("Wichtige Personen");
		super.addContent(title1);

		// Button for to Add a important Person
		Button btnImportantPer = new Button("Add Person");
		btnImportantPer.addClickListener(event -> UI.getCurrent().navigate(AddPersonInfoboxView.class));

		Button btnDeletePer = new Button("delete Person");
		btnDeletePer.setVisible(false);
//		btnDeletePer.addClickListener(e -> presenter.deletePerson(Inportantperson));

		HorizontalLayout positionButtonsPer = new HorizontalLayout();
		positionButtonsPer.add(btnImportantPer, btnDeletePer);

		super.addContent(positionButtonsPer);

		add(persongrid);
		persongrid.addColumn(AddPerson::getGender).setHeader("Gender");
		persongrid.addColumn(AddPerson::getFirstname).setHeader("Firstname");
		persongrid.addColumn(AddPerson::getLastname).setHeader("Lastname");
		persongrid.addColumn(AddPerson::getAdress).setHeader("Adress");
		persongrid.addColumn(AddPerson::getAdressNr).setHeader("Nr");
		persongrid.addColumn(AddPerson::getPostcode).setHeader("Postcode");
		persongrid.addColumn(AddPerson::getCity).setHeader("City");
		persongrid.addColumn(AddPerson::getPhonenummber).setHeader("Phonenummber");

		persongrid.addItemClickListener(event -> {
			btnDeletePer.setVisible(true);

		});

		super.addContent(persongrid);

		// Suptitel in H4 format for important adres
		title2 = new H4();
		title2.setText("Wichtige Adressen");
		super.addContent(title2);

		// Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adresse");
		btnImportantAdr.addClickListener(event -> UI.getCurrent().navigate(AddAdressInfoboxView.class));

		Button btnDeleteAdr = new Button("delete Adress");
		btnDeleteAdr.setVisible(false);

		HorizontalLayout positionButtonsAdr = new HorizontalLayout();
		positionButtonsAdr.add(btnImportantAdr, btnDeleteAdr);

		super.addContent(positionButtonsAdr);

		add(adressgrid);
		adressgrid.addColumn(AddAdress::getName).setHeader("Name");
		adressgrid.addColumn(AddAdress::getAdress).setHeader("Adress");
		adressgrid.addColumn(AddAdress::getAdressNr).setHeader("Nr");
		adressgrid.addColumn(AddAdress::getPostcode).setHeader("Postcode");
		adressgrid.addColumn(AddAdress::getCity).setHeader("City");
		adressgrid.addColumn(AddAdress::getPhonenummber).setHeader("Phonenummber");

		adressgrid.addItemClickListener(event -> {
			btnDeleteAdr.setVisible(true);
		});

		super.addContent(adressgrid);

		presenter = new InfoboxPresenter(this);

	}

	public void fillGridWithUsers(List<AddPerson> per) {

		persongrid.setItems(per);
	}

	public void fillGridWithAdress(List<AddAdress> adr) {

		adressgrid.setItems(adr);
	}

}
