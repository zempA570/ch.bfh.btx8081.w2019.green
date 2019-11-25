package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.html.NativeButton;

/**
 * A Designer generated component for the register-user template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("register-user")
@JsModule("./src/register-user.js")
public class RegisterUser extends PolymerTemplate<RegisterUser.RegisterUserModel> {

    @Id("label")
	private Label label;
	@Id("benutzername")
	private TextField benutzername;
	@Id("passwort")
	private PasswordField passwort;
	@Id("passwortWiederholen")
	private PasswordField passwortWiederholen;
	@Id("button")
	private NativeButton button;

	/**
     * Creates a new RegisterUser.
     */
    public RegisterUser() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between RegisterUser and register-user
     */
    public interface RegisterUserModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
