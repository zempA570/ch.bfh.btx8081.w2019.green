package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.checkbox.Checkbox;

/**
 * A Designer generated component for the todo-list template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("todo-list")
@JsModule("./src/todo-list.js")
public class TodoList extends PolymerTemplate<TodoList.TodoListModel> {

    @Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("label")
	private Label label;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("label1")
	private Label label1;
	@Id("vaadinListBox")
	private Element vaadinListBox;
	@Id("label2")
	private Label label2;
	@Id("vaadinListBox1")
	private Element vaadinListBox1;
	@Id("vaadinListBox2")
	private Element vaadinListBox2;
	@Id("vaadinListBox3")
	private Element vaadinListBox3;
	@Id("vaadinItem")
	private Element vaadinItem;
	@Id("vaadinItem1")
	private Element vaadinItem1;
	@Id("vaadinItem2")
	private Element vaadinItem2;
	@Id("vaadinItem3")
	private Element vaadinItem3;
	@Id("hr")
	private Hr hr;
	@Id("vaadinItem4")
	private Element vaadinItem4;
	@Id("hr1")
	private Hr hr1;
	@Id("vaadinCheckbox")
	private Checkbox vaadinCheckbox;
	@Id("vaadinCheckbox1")
	private Checkbox vaadinCheckbox1;
	@Id("vaadinCheckbox2")
	private Checkbox vaadinCheckbox2;
	@Id("vaadinCheckbox3")
	private Checkbox vaadinCheckbox3;

	/**
     * Creates a new TodoList.
     */
    public TodoList() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between TodoList and todo-list
     */
    public interface TodoListModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
