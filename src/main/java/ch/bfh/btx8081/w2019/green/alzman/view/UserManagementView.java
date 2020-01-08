package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.presenter.UserManagementPresenter;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;

/**
 * The user management view will be used to add and remove users of the app
 * 
 * @author Adrian
 */
@Route("usermanagementview")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class UserManagementView extends TemplateView {

	private UserManagementPresenter presenter;
	private ComboBox<String> cmbbxUserSelection;
	private TextField tfFirstName;
	private TextField tfLastName;

	public UserManagementView() {

		// Change title in header
		super.setHeaderTitle("User Management");

		// Create components to choose and delete users
		cmbbxUserSelection = new ComboBox<>("Choose your user");

		Button btnDeleteUser = new Button("Delete User", new Icon(VaadinIcon.TRASH));
		btnDeleteUser.addClickListener(e -> presenter.deleteUser(cmbbxUserSelection.getValue()));

		// Put components in horizontal layout
		HorizontalLayout hlChooseDeleteUser = new HorizontalLayout();
		hlChooseDeleteUser.add(cmbbxUserSelection, btnDeleteUser);
		hlChooseDeleteUser.setAlignItems(Alignment.BASELINE);

		// Create components for adding users
		tfFirstName = new TextField();
		tfFirstName.setLabel("Firstname");
		tfLastName = new TextField();
		tfLastName.setLabel("Lastname");

		Button btnAddUser = new Button("Add User", new Icon(VaadinIcon.PLUS));
		btnAddUser.addClickListener(e -> presenter.addUser(tfFirstName.getValue(), tfLastName.getValue()));

		// Put components in horizontal layout
		HorizontalLayout hlAddUser = new HorizontalLayout();
		hlAddUser.add(tfFirstName, tfLastName, btnAddUser);
		hlAddUser.setAlignItems(Alignment.BASELINE);

		// Adding components to content space
		super.addContent(hlChooseDeleteUser);
		super.addContent(hlAddUser);

		// instantiate the presenter with this view
		presenter = new UserManagementPresenter(this);

	}

	public void fillComboboxWithUsers(List<String> userNames) {

		cmbbxUserSelection.setItems(userNames);
	}

	public void clearTextfields() {
		tfFirstName.clear();
		tfLastName.clear();
	}

}
