package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.Task;
import ch.bfh.btx8081.w2019.green.alzman.presenter.ToDoListPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("todoList")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class ToDoListView extends TemplateView {

	private ToDoListPresenter presenter;
	private VerticalLayout weeklyTasks = new VerticalLayout();

	public ToDoListView() {

		// Change title in header
		super.setHeaderTitle("To Do List");
		HorizontalLayout horizManager = new HorizontalLayout();
		horizManager.setWidthFull();

		VerticalLayout specialTasks = new VerticalLayout();
		Label lblSpecialTasks = new Label("Special Tasks");
		specialTasks.add(lblSpecialTasks);
		horizManager.add(specialTasks);

		Label lblWeeklyTasks = new Label("Weekly Tasks");
		weeklyTasks.add(lblWeeklyTasks);
		horizManager.add(weeklyTasks);

		VerticalLayout monthlyTasks = new VerticalLayout();
		Label lblMonthlyTasks = new Label("Monthly Tasks");
		monthlyTasks.add(lblMonthlyTasks);
		horizManager.add(monthlyTasks);

		VerticalLayout annualTasks = new VerticalLayout();
		Label lblAnnualTasks = new Label("Annual Tasks");
		annualTasks.add(lblAnnualTasks);
		horizManager.add(annualTasks);

		Button addNewTask = new Button("add new Task", new Icon(VaadinIcon.PLUS));
		addNewTask.addClickListener(e -> UI.getCurrent().navigate(TaskEntryView.class));
		VerticalLayout vertButton = new VerticalLayout();
		vertButton.add(addNewTask);

		// adding components to content space
		super.addContent(horizManager);
		super.addContent(vertButton);
		
		presenter = new ToDoListPresenter(this);

	}

	public void addWeeklyTask(Task task) {

		Checkbox chBox = new Checkbox(task.getTask());
		Label date = new Label(task.getDate().toString());
		
		Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
		
		HorizontalLayout horiz = new HorizontalLayout(chBox, date, btnDelete);
		
		weeklyTasks.add(horiz);

	}

}
