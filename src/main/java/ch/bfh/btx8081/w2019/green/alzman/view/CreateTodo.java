package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the create-todo template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Tag("create-todo")
@JsModule("./src/create-todo.js")
public class CreateTodo extends PolymerTemplate<CreateTodo.CreateTodoModel> {

	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("label")
	private Label label;
	@Id("aufgabe")
	private TextField aufgabe;
	@Id("datum")
	private DatePicker datum;
	@Id("vaadinRadioGroup")
	private RadioButtonGroup<String> vaadinRadioGroup;
	@Id("label1")
	private Label label1;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
	 * Creates a new CreateTodo.
	 */
	public CreateTodo() {
		// You can initialise any data required for the connected UI components here.
	}

	/**
	 * This model binds properties between CreateTodo and create-todo
	 */
	public interface CreateTodoModel extends TemplateModel {
		// Add setters and getters for template properties here.
	}
}
