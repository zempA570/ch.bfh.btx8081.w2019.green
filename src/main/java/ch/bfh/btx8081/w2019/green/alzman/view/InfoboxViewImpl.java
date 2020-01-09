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

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.presenter.InfoboxPresenter;

@Route("InfoboxView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class InfoboxViewImpl extends TemplateView implements InfoboxView {

	private List<InfoboxViewListener> listeners = new ArrayList<InfoboxViewListener>();
	private H4 titleImportantPerson;
	private H4 titleImportantAdress;

	private Grid<AddPerson> gridImportantPerson = new Grid<>();
	private Grid<AddAdress> gridImportantAdress = new Grid<>();

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
		gridImportantAdress.addColumn(AddAdress::getId).setVisible(false);
		gridImportantAdress.addColumn(AddAdress::getName).setHeader("Name");
		gridImportantAdress.addColumn(AddAdress::getAdress).setHeader("Adress");
		gridImportantAdress.addColumn(AddAdress::getAdressNr).setHeader("Adress Number");
		gridImportantAdress.addColumn(AddAdress::getPostcode).setHeader("Postcode");
		gridImportantAdress.addColumn(AddAdress::getCity).setHeader("City");
		gridImportantAdress.addColumn(AddAdress::getPhonenummber).setHeader("Phonenummber");

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

	public void fillGridWithUsers(List<AddPerson> listPerson) {

		gridImportantPerson.setItems(listPerson);
	}

	public void fillGridWithAdress(List<AddAdress> listAdress) {

		gridImportantAdress.setItems(listAdress);
	}

	@Override
	public void addListener(InfoboxViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public Set<AddPerson> getSelectedPerson() {
		return gridImportantPerson.getSelectedItems();
	}

	@Override
	public Set<AddAdress> getSelectedAdress() {
		return gridImportantAdress.getSelectedItems();
	}

}
