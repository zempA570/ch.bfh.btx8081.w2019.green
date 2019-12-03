package ch.bfh.btx8081.w2019.green.alzman.view;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;

/**
 * A Designer generated component for the dashboard-gui template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("dashboard-gui")
@JsModule("./src/dashboard-gui.js")
public class DashboardGui extends PolymerTemplate<DashboardGui.DashboardGuiModel> {

    @Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("vaadinTextField")
	private TextField vaadinTextField;

	/**
     * Creates a new DashboardGui.
     */
    public DashboardGui() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between DashboardGui and dashboard-gui
     */
    public interface DashboardGuiModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
