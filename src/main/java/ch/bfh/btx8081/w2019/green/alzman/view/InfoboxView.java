package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.html.H4;

import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.presenter.AdressService;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.PersonService;



@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxView extends TemplateView {

	private H4 title1;
	private H4 title2;

	private Grid<AddPerson> persongrid = new Grid<>();
	private AdressService services = new AdressService();
	


	private InfoboxPresenter presenter;


	private List<AddAdress> adresses = services.getAllAdress();
	private Grid<AddAdress> adressgrid = new Grid<>();

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
		super.addContent(btnImportantPer);

		add(persongrid);
		persongrid.addColumn(AddPerson::getGender).setHeader("Gender");
		persongrid.addColumn(AddPerson::getFirstname).setHeader("Firstname");
		persongrid.addColumn(AddPerson::getLastname).setHeader("Lastname");
		persongrid.addColumn(AddPerson::getAdress).setHeader("Adress");
		persongrid.addColumn(AddPerson::getAdressNr).setHeader("Nr");
		persongrid.addColumn(AddPerson::getPostcode).setHeader("Postcode");
		persongrid.addColumn(AddPerson::getCity).setHeader("City");
		persongrid.addColumn(AddPerson::getPhonenummber).setHeader("Phonenummber");
		super.addContent(persongrid);

		// Suptitel in H4 format for important adres
		title2 = new H4();
		title2.setText("Wichtige Adressen");
		super.addContent(title2);

		// Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adresse");
		btnImportantAdr.addClickListener(event -> UI.getCurrent().navigate(AddAdressInfoboxView.class));
		super.addContent(btnImportantAdr);

		add(adressgrid);
		adressgrid.setItems(adresses);
		adressgrid.addColumn(AddAdress::getName).setHeader("Name");
		adressgrid.addColumn(AddAdress::getAdress).setHeader("Adress");
		adressgrid.addColumn(AddAdress::getAdressNr).setHeader("Nr");
		adressgrid.addColumn(AddAdress::getPostcode).setHeader("Postcode");
		adressgrid.addColumn(AddAdress::getCity).setHeader("City");
		adressgrid.addColumn(AddAdress::getPhonenummber).setHeader("Phonenummber");
		super.addContent(adressgrid);

		presenter = new InfoboxPresenter(this);
	
	}
	
	public void fillGridWithUsers(List<AddPerson> per) {

		persongrid.setItems(per);
	}

}
