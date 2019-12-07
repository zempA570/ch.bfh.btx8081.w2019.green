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
		
		// Create components to choose and delete users
		ComboBox<String> cmbbxUserSelection = new ComboBox<>("Choose your user");
		cmbbxUserSelection.setItems("TEST", "DUMMY", "BOT");
		Button btnDeleteUser = new Button("Delete User", new Icon(VaadinIcon.TRASH));
		
		// Put components in horizontal layout
		HorizontalLayout hlChooseDeleteUser = new HorizontalLayout();
		hlChooseDeleteUser.add(cmbbxUserSelection, btnDeleteUser);
		hlChooseDeleteUser.setAlignItems(Alignment.BASELINE);

		// This will be used as soon as logic is implemented
//		TextField asdf = new TextField();
//		cmbbxUserSelection.addValueChangeListener(event -> {
//			if (event.getSource().isEmpty()) {
//				asdf.setPlaceholder(("The current User is TEST"));
//			} else {
//				asdf.setPlaceholder("The current User is" + event.getValue());
//			}
//		});
//		super.addContent(asdf);


		// Create components for adding users
		TextField tfFirstName = new TextField();
		tfFirstName.setLabel("Firstname");
		TextField tfLastName = new TextField();
		tfLastName.setLabel("Lastname");
		Button btnAddUser = new Button("Add User", new Icon(VaadinIcon.PLUS));

		// Put components in horizontal layout
		HorizontalLayout hlAddUser = new HorizontalLayout();
		hlAddUser.add(tfFirstName, tfLastName, btnAddUser);
		hlAddUser.setAlignItems(Alignment.BASELINE);

		// Adding components to content space
		super.addContent(hlChooseDeleteUser);
		super.addContent(hlAddUser);

	}

}
