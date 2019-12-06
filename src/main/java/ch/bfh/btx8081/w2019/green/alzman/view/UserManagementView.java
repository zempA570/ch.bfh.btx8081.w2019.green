package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("sdf")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class UserManagementView extends TemplateView {

	public UserManagementView() {

		// Change title in header
		super.setHeaderTitle("User Management");

		// Creating elements
		ListBox<String> listBox = new ListBox<>();
		listBox.setItems("Relative 1", "Relative 2", "Relative 3");

		TextField username = new TextField();
		username.setLabel("Username");

		Button btnAddUser = new Button("Add User", new Icon(VaadinIcon.PLUS));

		// Creating horizontal layout
		HorizontalLayout hLAddUser = new HorizontalLayout();

		// Adding two components to horizontal layout
		hLAddUser.add(username, btnAddUser);

		// Adding components to content space
		super.addContent(listBox);
		super.addContent(hLAddUser);

	}

}
