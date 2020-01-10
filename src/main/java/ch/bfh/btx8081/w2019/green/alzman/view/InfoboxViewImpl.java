package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxPresenter;

/**
 * 
 * @author gausegan
 *
 */
@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxViewImpl extends TemplateView implements InfoboxView {

	private List<InfoboxViewListener> lstListeners = new ArrayList<InfoboxViewListener>();
	private H4 h4TitleImportantPerson;
	private H4 h4TitleImportantAddress;

	private Grid<PersonModel> grdImportantPerson = new Grid<>();
	private Grid<AddressModel> grdImportantAddress = new Grid<>();

	public InfoboxViewImpl() {

		// Change title in header
		super.setHeaderTitle("Infobox");

		// Subtitel in H4 format
		h4TitleImportantPerson = new H4();
		h4TitleImportantPerson.setText("Important Person");
		super.addContent(h4TitleImportantPerson);

		// Button for to Add a important Person
		Button btnAddPer = new Button("Add Person");
		btnAddPer.addClickListener(e -> {
			for (InfoboxViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});

		Button btnDeletePer = new Button("Delete Person");
		btnDeletePer.setVisible(false);
		btnDeletePer.addClickListener(e -> {
			for (InfoboxViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});

		HorizontalLayout hlPositionButtonsPer = new HorizontalLayout();
		hlPositionButtonsPer.add(btnAddPer, btnDeletePer);

		super.addContent(hlPositionButtonsPer);

		add(grdImportantPerson);
		grdImportantPerson.addColumn(PersonModel::getId).setVisible(false);
		grdImportantPerson.addColumn(PersonModel::getGender).setHeader("Gender");
		grdImportantPerson.addColumn(PersonModel::getFirstname).setHeader("Firstname");
		grdImportantPerson.addColumn(PersonModel::getLastname).setHeader("Lastname");
		grdImportantPerson.addColumn(PersonModel::getAdress).setHeader("Adress");
		grdImportantPerson.addColumn(PersonModel::getAdressNr).setHeader("Adress Number");
		grdImportantPerson.addColumn(PersonModel::getPostcode).setHeader("Postcode");
		grdImportantPerson.addColumn(PersonModel::getCity).setHeader("City");
		grdImportantPerson.addColumn(PersonModel::getPhonenummber).setHeader("Phonenummber");

		grdImportantPerson.addItemClickListener(event -> {
			if (grdImportantPerson.getSelectedItems().isEmpty()) {
				btnDeletePer.setVisible(false);
			} else {
				btnDeletePer.setVisible(true);
			}
		});

		super.addContent(grdImportantPerson);

		// Suptitel in H4 format for important adres
		h4TitleImportantAddress = new H4();
		h4TitleImportantAddress.setText("Important Adress");
		super.addContent(h4TitleImportantAddress);

		// Button for to Add a important adress
		Button btnAddAddr = new Button("Add Adress");
		btnAddAddr.addClickListener(e -> {
			for (InfoboxViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});

		Button btnDeleteAddr = new Button("Delete Adress");
		btnDeleteAddr.setVisible(false);
		btnDeleteAddr.addClickListener(e -> {
			for (InfoboxViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});

		HorizontalLayout hlPositionButtonsAddr = new HorizontalLayout();
		hlPositionButtonsAddr.add(btnAddAddr, btnDeleteAddr);

		super.addContent(hlPositionButtonsAddr);

		add(grdImportantAddress);
		grdImportantAddress.addColumn(AddressModel::getId).setVisible(false);
		grdImportantAddress.addColumn(AddressModel::getName).setHeader("Name");
		grdImportantAddress.addColumn(AddressModel::getAdress).setHeader("Adress");
		grdImportantAddress.addColumn(AddressModel::getAdressNr).setHeader("Adress Number");
		grdImportantAddress.addColumn(AddressModel::getPostcode).setHeader("Postcode");
		grdImportantAddress.addColumn(AddressModel::getCity).setHeader("City");
		grdImportantAddress.addColumn(AddressModel::getPhonenummber).setHeader("Phonenummber");

		grdImportantAddress.addItemClickListener(event -> {
			if (grdImportantAddress.getSelectedItems().isEmpty()) {
				btnDeleteAddr.setVisible(false);
			} else {
				btnDeleteAddr.setVisible(true);
			}
		});

		super.addContent(grdImportantAddress);

		new InfoboxPresenter(this);

	}

	public void fillGridWithUsers(List<PersonModel> listPerson) {

		grdImportantPerson.setItems(listPerson);
	}

	public void fillGridWithAdress(List<AddressModel> listAdress) {

		grdImportantAddress.setItems(listAdress);
	}

	@Override
	public void addListener(InfoboxViewListener listener) {
		lstListeners.add(listener);
	}

	@Override
	public Set<PersonModel> getSelectedPerson() {
		return grdImportantPerson.getSelectedItems();
	}

	@Override
	public Set<AddressModel> getSelectedAddress() {
		return grdImportantAddress.getSelectedItems();
	}

}
