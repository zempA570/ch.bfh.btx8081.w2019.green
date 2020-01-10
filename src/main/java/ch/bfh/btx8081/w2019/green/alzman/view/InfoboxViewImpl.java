package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxPresenter;

@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxViewImpl extends TemplateView implements InfoboxView {

	private List<InfoboxViewListener> listeners = new ArrayList<InfoboxViewListener>();
	private H4 titleImportantPerson;
	private H4 titleImportantAdress;

	private Grid<PersonModel> gridImportantPerson = new Grid<>();
	private Grid<AddressModel> gridImportantAdress = new Grid<>();

	public InfoboxViewImpl() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Subtitel in H4 format
		titleImportantPerson = new H4();
		titleImportantPerson.setText("Important Person");
		super.addContent(titleImportantPerson);

		// Button for to Add a important Person
		Button btnImportantPer = new Button("Add Person");
		btnImportantPer.addClickListener(e -> {
			for (InfoboxViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		Button btnDeletePer = new Button("Delete Person");
		btnDeletePer.setVisible(false);
		btnDeletePer.addClickListener(e -> {
			for (InfoboxViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		HorizontalLayout positionButtonsPer = new HorizontalLayout();
		positionButtonsPer.add(btnImportantPer, btnDeletePer);

		super.addContent(positionButtonsPer);

		add(gridImportantPerson);
		gridImportantPerson.addColumn(PersonModel::getId).setVisible(false);
		gridImportantPerson.addColumn(PersonModel::getGender).setHeader("Gender");
		gridImportantPerson.addColumn(PersonModel::getFirstname).setHeader("Firstname");
		gridImportantPerson.addColumn(PersonModel::getLastname).setHeader("Lastname");
		gridImportantPerson.addColumn(PersonModel::getAdress).setHeader("Adress");
		gridImportantPerson.addColumn(PersonModel::getAdressNr).setHeader("Adress Number");
		gridImportantPerson.addColumn(PersonModel::getPostcode).setHeader("Postcode");
		gridImportantPerson.addColumn(PersonModel::getCity).setHeader("City");
		gridImportantPerson.addColumn(PersonModel::getPhonenummber).setHeader("Phonenummber");

		gridImportantPerson.addItemClickListener(event -> {
			if(gridImportantPerson.getSelectedItems().isEmpty()) {
				btnDeletePer.setVisible(false);
			} else {
				btnDeletePer.setVisible(true);
			}					
		});

		super.addContent(gridImportantPerson);

		// Suptitel in H4 format for important adres
		titleImportantAdress = new H4();
		titleImportantAdress.setText("Important Adress");
		super.addContent(titleImportantAdress);

		// Button for to Add a important adress
		Button btnImportantAdr = new Button("Add Adress");
		btnImportantAdr.addClickListener(e -> {
			for (InfoboxViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		Button btnDeleteAdr = new Button("Delete Adress");
		btnDeleteAdr.setVisible(false);
		btnDeleteAdr.addClickListener(e -> {
			for (InfoboxViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		HorizontalLayout positionButtonsAdr = new HorizontalLayout();
		positionButtonsAdr.add(btnImportantAdr, btnDeleteAdr);

		super.addContent(positionButtonsAdr);

		add(gridImportantAdress);
		gridImportantAdress.addColumn(AddressModel::getId).setVisible(false);
		gridImportantAdress.addColumn(AddressModel::getName).setHeader("Name");
		gridImportantAdress.addColumn(AddressModel::getAdress).setHeader("Adress");
		gridImportantAdress.addColumn(AddressModel::getAdressNr).setHeader("Adress Number");
		gridImportantAdress.addColumn(AddressModel::getPostcode).setHeader("Postcode");
		gridImportantAdress.addColumn(AddressModel::getCity).setHeader("City");
		gridImportantAdress.addColumn(AddressModel::getPhonenummber).setHeader("Phonenummber");

		gridImportantAdress.addItemClickListener(event -> {
			if(gridImportantAdress.getSelectedItems().isEmpty()) {
				btnDeleteAdr.setVisible(false);
			} else {
				btnDeleteAdr.setVisible(true);
			}					
		});

		super.addContent(gridImportantAdress);

		new InfoboxPresenter(this);

	}

	public void fillGridWithUsers(List<PersonModel> listPerson) {

		gridImportantPerson.setItems(listPerson);
	}

	public void fillGridWithAdress(List<AddressModel> listAdress) {

		gridImportantAdress.setItems(listAdress);
	}

	@Override
	public void addListener(InfoboxViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public Set<PersonModel> getSelectedPerson() {
		return gridImportantPerson.getSelectedItems();
	}

	@Override
	public Set<AddressModel> getSelectedAdress() {
		return gridImportantAdress.getSelectedItems();
	}

}
