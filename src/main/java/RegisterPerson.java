import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the register-person template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("register-person")
@JsModule("./src/register-person.js")
public class RegisterPerson extends PolymerTemplate<RegisterPerson.RegisterPersonModel> {

    /**
     * Creates a new RegisterPerson.
     */
    public RegisterPerson() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between RegisterPerson and register-person
     */
    public interface RegisterPersonModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
