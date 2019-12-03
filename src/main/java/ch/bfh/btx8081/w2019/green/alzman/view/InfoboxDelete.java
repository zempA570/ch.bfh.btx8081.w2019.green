package ch.bfh.btx8081.w2019.green.alzman.view;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the infobox-delete template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("infobox-delete")
@JsModule("./src/infobox-delete.js")
public class InfoboxDelete extends PolymerTemplate<InfoboxDelete.InfoboxDeleteModel> {

    /**
     * Creates a new InfoboxDelete.
     */
    public InfoboxDelete() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between InfoboxDelete and infobox-delete
     */
    public interface InfoboxDeleteModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
