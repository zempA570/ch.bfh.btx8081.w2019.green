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

	private H4 titleImportantPerson;
	private H4 titleImportantAdress;

	private Grid<AddPerson> gridImportantPerson = new Grid<>();
	private Grid<AddAdress> gridImportantAdress = new Grid<>();

	private InfoboxPresenter presenter;

	public InfoboxView() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Subtitel in H4 format
		titleImportantPerson = new H4();
		titleImportantPerson.setText("Important Person");
		super.addContent(titleImportantPerson);

		// Button for to Add a important Person
		Button btnImportantPer = new Button("Add Person");
		btnImportantPer.addClickListener(event -> UI.getCurrent().navigate(AddPersonInfoboxView.class));

		Button btnDeletePer = new Button("Delete Person");
		btnDeletePer.setVisible(false);
		btnDeletePer.addClickListener(e -> presenter.deletePerson(gridImportantPerson.getSelectedItems()));
		btnDeletePer.addClickListener(event -> UI.getCurrent().navigate(DashboardView.class));

		HorizontalLayout positionButtonsPer = new HorizontalLayout();
		positionButtonsPer.add(btnImportantPer, btnDeletePer);

		super.addContent(positionButtonsPer);

		add(gridImportantPerson);
		gridImportantPerson.addColumn(AddPerson::getId).setVisible(false);
		gridImportantPerson.addColumn(AddPerson::getGender).setHeader("Gender");
		gridImportantPerson.addColumn(AddPerson::getFirstname).setHeader("Firstname");
		gridImportantPerson.addColumn(AddPerson::getLastname).setHeader("Lastname");
		gridImportantPerson.addColumn(AddPerson::getAdress).setHeader("Adress");
		gridImportantPerson.addColumn(AddPerson::getAdressNr).setHeader("Adress Number");
		gridImportantPerson.addColumn(AddPerson::getPostcode).setHeader("Postcode");
		gridImportantPerson.addColumn(AddPerson::getCity).setHeader("City");
		gridImportantPerson.addColumn(AddPerson::getPhonenummber).setHeader("Phonenummber");

		gridImportantPerson.addItemClickListener(event -> {
			btnDeletePer.setVisible(false);

		});
		gridImportantPerson.addItemDoubleClickListener(event -> {
			btnDeletePer.setVisible(true);
		});

		super.addContent(gridImportantPerson);

		// Suptitel in H4 format for important adres
		titleImportantAdress = new H4();
		titleImportantAdress.setText("Important Adress");
		super.addContent(titleImportantAdress);

		// Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adresse");
		btnImportantAdr.addClickListener(event -> UI.getCurrent().navigate(AddAdressInfoboxView.class));

		Button btnDeleteAdr = new Button("Delete Adress");
		btnDeleteAdr.setVisible(false);
		btnDeleteAdr.addClickListener(e -> presenter.deleteAdress(gridImportantAdress.getSelectedItems()));
		btnDeleteAdr.addClickListener(event -> UI.getCurrent().navigate(DashboardView.class));

		HorizontalLayout positionButtonsAdr = new HorizontalLayout();
		positionButtonsAdr.add(btnImportantAdr, btnDeleteAdr);

		super.addContent(positionButtonsAdr);

		add(gridImportantAdress);
		gridImportantAdress.addColumn(AddAdress::getId).setVisible(false);
		gridImportantAdress.addColumn(AddAdress::getName).setHeader("Name");
		gridImportantAdress.addColumn(AddAdress::getAdress).setHeader("Adress");
		gridImportantAdress.addColumn(AddAdress::getAdressNr).setHeader("Adress Number");
		gridImportantAdress.addColumn(AddAdress::getPostcode).setHeader("Postcode");
		gridImportantAdress.addColumn(AddAdress::getCity).setHeader("City");
		gridImportantAdress.addColumn(AddAdress::getPhonenummber).setHeader("Phonenummber");

		gridImportantAdress.addItemClickListener(event -> {
			btnDeleteAdr.setVisible(false);

		});
		gridImportantAdress.addItemDoubleClickListener(event -> {
			btnDeleteAdr.setVisible(true);
		});

		super.addContent(gridImportantAdress);

		presenter = new InfoboxPresenter(this);

	}

	public void fillGridWithUsers(List<AddPerson> listPerson) {

		gridImportantPerson.setItems(listPerson);
	}

	public void fillGridWithAdress(List<AddAdress> listAdress) {

		gridImportantAdress.setItems(listAdress);
	}

}
