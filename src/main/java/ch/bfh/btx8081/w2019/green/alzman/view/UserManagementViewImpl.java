package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.UserManagementPresenter;

/**
 * The user management view is used to add and remove users of the app
 * 
 * @author Adrian
 */
@Route("usermanagement")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class UserManagementViewImpl extends TemplateView implements UserManagementView {

	private List<UserManagagementViewListener> listeners = new ArrayList<UserManagagementViewListener>();
	private ComboBox<String> cmbbxUserSelection;
	private TextField tfFirstName;
	private TextField tfLastName;

	public UserManagementViewImpl() {

		// Change title in header
		super.setHeaderTitle("User Management");

		// Create components to choose and delete users
		// TODO make combobox value first of available values (default value)
		cmbbxUserSelection = new ComboBox<>("Choose your user");

		Button btnDeleteUser = new Button("Delete User", new Icon(VaadinIcon.TRASH));
		btnDeleteUser.addClickListener(event -> {
			for (UserManagagementViewListener listener : listeners)
				listener.buttonClick(event.getSource());
		});

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
		btnAddUser.addClickListener(event -> {
			for (UserManagagementViewListener listener : listeners)
				listener.buttonClick(event.getSource());
		});

		// Put components in horizontal layout
		HorizontalLayout hlAddUser = new HorizontalLayout();
		hlAddUser.add(tfFirstName, tfLastName, btnAddUser);
		hlAddUser.setAlignItems(Alignment.BASELINE);

		// Adding components to content space
		super.addContent(hlChooseDeleteUser);
		super.addContent(hlAddUser);

		// tell the presenter to wake up and get to work
		new UserManagementPresenter(this);

	}

	@Override
	public String getFirstname() {
		return tfFirstName.getValue();
	}

	@Override
	public String getLastname() {
		return tfLastName.getValue();
	}

	@Override
	public void setComboboxItems(List<String> userNames) {
		cmbbxUserSelection.setItems(userNames);
	}

	@Override
	public void clearTextfields() {
		tfFirstName.clear();
		tfLastName.clear();
	}

	@Override
	public String getComboboxValue() {
		return cmbbxUserSelection.getValue();
	}

	@Override
	public void addListener(UserManagagementViewListener listener) {
		listeners.add(listener);
	}

}
