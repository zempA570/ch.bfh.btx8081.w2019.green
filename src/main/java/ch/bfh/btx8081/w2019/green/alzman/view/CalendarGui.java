
package ch.bfh.btx8081.w2019.green.alzman.view;



import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.component.html.Label;

/**
 * A Designer generated component for the calendar-gui template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 * @param <DateField>
 */
@Route("CalendarGUI")
@Tag("calendar-gui")
@JsModule("./src/calendar-gui.js")
public class CalendarGui<DateField> extends PolymerTemplate<CalendarGui.CalendarGuiModel> {

    @Id("backButton")
	private Button backButton;
	@Id("calendarDatePicker")
	private DatePicker calendarDatePicker;
	@Id("horizontalLayoutSpacing")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("vaadinTimePicker")
	private TimePicker vaadinTimePicker;
	@Id("appointmentTextField")
	private TextArea appointmentTextField;
	/**
	 * The two buttons are in a horizontal layout so that they can be placed next to each other.
	 */
	@Id("horizontalLayoutSpacing")
	private HorizontalLayout horizontalLayoutSpacing;
	@Id("addButton")
	private Button addButton;
	@Id("cancelButton")
	private Button cancelButton;
	@Id("titleLabel")
	private Label titleLabel;
	
	
	
	
	
	/**
     * Creates a new CalendarGui.
     */
    public CalendarGui() {
        // You can initialise any data required for the connected UI components here.
    	
    	
    }

    /**
     * This model binds properties between CalendarGui and calendar-gui
     */
    public interface CalendarGuiModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
}
