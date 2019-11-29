package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the todolist-overview template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("todolist-overview")
@JsModule("./src/todolist-overview.js")
public class TodolistOverview extends PolymerTemplate<TodolistOverview.TodolistOverviewModel> {

    /**
     * Creates a new TodolistOverview.
     */
    public TodolistOverview() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between TodolistOverview and todolist-overview
     */
    public interface TodolistOverviewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
