package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the important-notes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("important-notes")
@JsModule("./src/important-notes.js")
public class ImportantNotes extends PolymerTemplate<ImportantNotes.ImportantNotesModel> {

    @Id("label")
	private Label label;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("addDate")
	private Label addDate;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("username")
	private Label username;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("ironIcon")
	private Element ironIcon;

	/**
     * Creates a new ImportantNotes.
     */
    public ImportantNotes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between ImportantNotes and important-notes
     */
    public interface ImportantNotesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
