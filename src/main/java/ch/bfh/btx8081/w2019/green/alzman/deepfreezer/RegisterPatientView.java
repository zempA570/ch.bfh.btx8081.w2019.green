package ch.bfh.btx8081.w2019.green.alzman.deepfreezer;
//package ch.bfh.btx8081.w2019.green.alzman.trash;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.Route;
//
//import ch.bfh.btx8081.w2019.green.alzman.view.TemplateView;
//
//@Route("Register")
//@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
//public class RegisterPatientView extends TemplateView {
//
//	private RegisterUserPresenter presenter;
//
//	public RegisterPatientView() {
//
//		// Change title in header
//		super.setHeaderTitle("Register Patient");
//
//		// Textfields for relative information
//		TextField tfRelativeFirstname = new TextField("Your Firstname");
//		TextField tfRelativeLastname = new TextField("Your Lastname");
//
//		// enter PatientName
//		TextField tfPatientFirstname = new TextField("Patient's Firstname");
//		TextField tfPatientLastname = new TextField("Patient's Lastname");
//
//		HorizontalLayout horizon1 = new HorizontalLayout(tfRelativeFirstname, tfRelativeLastname);
//		HorizontalLayout horizon2 = new HorizontalLayout(tfPatientFirstname, tfPatientLastname);
//
//		// create Password
//		PasswordField pfPatient = new PasswordField("Create a Password");
//
//		// repeat the password
//		PasswordField pfPatientRepeated = new PasswordField("Repeat the Password");
//
//		HorizontalLayout horizon3 = new HorizontalLayout(pfPatient, pfPatientRepeated);
//		// Buttons for log in or to register new user
//		Button create = new Button("Create");
//		create.addClickListener(e -> presenter.addPatientAndUser(tfRelativeFirstname.getValue(), tfRelativeLastname.getValue(),
//				tfPatientFirstname.getValue(), tfPatientLastname.getValue(), pfPatient.getValue()));
//
//		VerticalLayout vert = new VerticalLayout(horizon1, horizon2, horizon3, create);
//
//		// Adding components to content space
//
//		super.addContent(vert);
//
//		presenter = new RegisterUserPresenter(this);
//
//	}
//}
