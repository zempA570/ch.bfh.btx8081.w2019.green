import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the infobox-start template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("infobox-start")
@JsModule("./src/infobox-start.js")
public class InfoboxStart extends PolymerTemplate<InfoboxStart.InfoboxStartModel> {

    /**
     * Creates a new InfoboxStart.
     */
    public InfoboxStart() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between InfoboxStart and infobox-start
     */
    public interface InfoboxStartModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
