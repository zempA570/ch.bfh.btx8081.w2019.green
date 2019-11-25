package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the entry-importantnotes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("entry-importantnotes")
@JsModule("./src/entry-importantnotes.js")
public class EntryImportantnotes extends PolymerTemplate<EntryImportantnotes.EntryImportantnotesModel> {

    /**
     * Creates a new EntryImportantnotes.
     */
    public EntryImportantnotes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between EntryImportantnotes and entry-importantnotes
     */
    public interface EntryImportantnotesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
