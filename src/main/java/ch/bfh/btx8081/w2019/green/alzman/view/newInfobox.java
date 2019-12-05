package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
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
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class newInfobox extends TemplateView {

	public newInfobox() {

		// Change title in header
		super.setHeaderTitle("Hallo das ist ein Test");
		
		Button b12 = new Button("Add User");
		
		super.addContent(b12);

		Button b13 = new Button("Delete User");
		
		super.addContent(b13);
	
	
	
	
	
	
	}

}
