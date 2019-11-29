package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * A Designer generated component for the login-ui template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-ui")
@JsModule("./src/login-ui.js")
public class LoginUi extends PolymerTemplate<LoginUi.LoginUiModel> {

    @Id("label")
	private Label label;
	@Id("benutzername")
	private TextField benutzername;
	@Id("password")
	private PasswordField password;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("button")
	private NativeButton button;
	@Id("button1")
	private NativeButton button1;
	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;

	/**
     * Creates a new LoginUi.
     */
    public LoginUi() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between LoginUi and login-ui
     */
    public interface LoginUiModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
