package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class LogIn extends TemplateView {

	public LogIn() {

		// Change title in header
		super.setHeaderTitle("Login");

		// Creating elements
				
		TextField enter = new TextField("Login");
		enter.setLabel("Username");
		PasswordField pw = new PasswordField("Password"); 
		
		//Buttons for log in or to register new user
		Button submit = new Button("einloggen");
		Button register = new Button("new register", new Icon(VaadinIcon.PLUS)); 
		register.addClickListener(e -> UI.getCurrent().navigate(RegisterPatientView.class));
		
		HorizontalLayout hor = new HorizontalLayout(submit, register); 

		//Creating Vertical layout
		VerticalLayout verticalLay = new VerticalLayout();
		
		// Adding all components to vertical layout
		verticalLay.add(enter , pw, hor);


		// Adding components to content space
	
		super.addContent(verticalLay);
	

	}

}
