package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Register")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class RegisterUser extends TemplateView {
	
	public RegisterUser() {

		// Change title in header
		super.setHeaderTitle("Register");

		// Creating User
				
		TextField FirstN = new TextField("Firstname");
		FirstN.setLabel("Firstname");
		
		TextField LastN = new TextField("Lastname");
		LastN.setLabel("Lastname");
		 
		// enter PatientName
		TextField PatientFirstN = new TextField("Patient's Firstname"); 
		PatientFirstN.setLabel("Patient's Firstname");
		
		TextField PatientLastN = new TextField("Patient's Lastname");
		PatientLastN.setLabel("Patient's Lastname");
		
		HorizontalLayout horizon1 = new HorizontalLayout(FirstN, LastN); 
		HorizontalLayout horizon2 = new HorizontalLayout(PatientFirstN, PatientLastN); 
	
		// create Password
		PasswordField NPw = new PasswordField("Create a Password"); 
		NPw.setLabel("Create a Password");
		
		// repeat the password
		PasswordField RPw = new PasswordField("Repeat the Password"); 
		RPw.setLabel("Repeat the Password");
		
		HorizontalLayout horizon3 = new HorizontalLayout(NPw, RPw); 
		//Buttons for log in or to register new user
		Button create = new Button("Create");
		create.addClickListener(e -> UI.getCurrent().navigate(LogIn.class));
		
		VerticalLayout vert = new VerticalLayout(horizon1, horizon2, horizon3, create); 

		

		// Adding components to content space
	
		super.addContent(vert);
	

}}
