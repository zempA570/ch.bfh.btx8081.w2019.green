package ch.bfh.btx8081.w2019.green.alzman.view;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the infobox-edit template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("infobox-edit")
@JsModule("./src/infobox-edit.js")
public class InfoboxEdit extends PolymerTemplate<InfoboxEdit.InfoboxEditModel> {

    /**
     * Creates a new InfoboxEdit.
     */
    public InfoboxEdit() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between InfoboxEdit and infobox-edit
     */
    public interface InfoboxEditModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
