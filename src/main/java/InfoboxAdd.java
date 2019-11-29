import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the infobox-add template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("infobox-add")
@JsModule("./src/infobox-add.js")
public class InfoboxAdd extends PolymerTemplate<InfoboxAdd.InfoboxAddModel> {

    /**
     * Creates a new InfoboxAdd.
     */
    public InfoboxAdd() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between InfoboxAdd and infobox-add
     */
    public interface InfoboxAddModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
