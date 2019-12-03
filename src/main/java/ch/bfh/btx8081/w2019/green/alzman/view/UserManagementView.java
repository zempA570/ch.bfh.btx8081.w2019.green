package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("usermanagementview")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class UserManagementView extends TemplateView {

	public UserManagementView() {

		// Change title in header
		super.setHeaderTitle("User Management");

		// Create components for adding users
		TextField tfUsername = new TextField();
		tfUsername.setLabel("Username");
		Button btnAddUser = new Button("Add User", new Icon(VaadinIcon.PLUS));

		// Put components in horizontal layout
		HorizontalLayout hlAddUser = new HorizontalLayout();
		hlAddUser.add(tfUsername, btnAddUser);
		hlAddUser.setAlignItems(Alignment.BASELINE);

		/**
		 * If we opt for multiple users we can add a collection to the combobox below
		 * like in the example:
		 * 
		 * EXAMPLE ComboBox(String label, Collection<T> items)
		 * 
		 * Creates a combo box with the defined label and populated with the items in
		 * the collection.
		 * 
		 * 
		 * NOTE: if we do choose to work with multiple users, code must be changed to
		 * work for objects and not strings
		 */
		ComboBox<String> cmbbxUserSelection = new ComboBox<>("Choose your user");
		cmbbxUserSelection.setItems("TEST", "DUMMY", "BOT");

		TextField asdf = new TextField();
		cmbbxUserSelection.addValueChangeListener(event -> {
			if (event.getSource().isEmpty()) {
				asdf.setPlaceholder(("The current User is TEST"));
			} else {
				asdf.setPlaceholder("The current User is" + event.getValue());
			}
		});

		// Adding components to content space
		super.addContent(cmbbxUserSelection);
		super.addContent(hlAddUser);
//		super.addContent(asdf);

	}

}
