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
	private VerticalLayout weeklyTasksWrapper = new VerticalLayout();
	private VerticalLayout weeklyTasks = new VerticalLayout();
	private VerticalLayout monthlyTasksWrapper = new VerticalLayout();
	private VerticalLayout monthlyTasks = new VerticalLayout();
	private VerticalLayout annuallyTasksWrapper = new VerticalLayout();
	private VerticalLayout annuallyTasks = new VerticalLayout();
	private VerticalLayout specialTasksWrapper = new VerticalLayout();
	private VerticalLayout specialTasks = new VerticalLayout();
	private VerticalLayout complTasksWrapper = new VerticalLayout();
	private VerticalLayout complTasks = new VerticalLayout();
	private Checkbox chBox;

	public ToDoListView() {

		// Change title in header
		super.setHeaderTitle("To Do List");
		HorizontalLayout horizManager = new HorizontalLayout();
		horizManager.setWidthFull();

		// elements for special-tasks row
		Label lblSpecialTasks = new Label("Special Tasks");
		specialTasksWrapper.add(lblSpecialTasks, specialTasks);
		horizManager.add(specialTasksWrapper);

		// elements for weekly-tasks row
		Label lblWeeklyTasks = new Label("Weekly Tasks");
		weeklyTasksWrapper.add(lblWeeklyTasks, weeklyTasks);
		horizManager.add(weeklyTasksWrapper);

		// elements for monthly-tasks row
//		VerticalLayout monthlyTasks = new VerticalLayout();
		Label lblMonthlyTasks = new Label("Monthly Tasks");
		monthlyTasksWrapper.add(lblMonthlyTasks, monthlyTasks);
		horizManager.add(monthlyTasksWrapper);

		// elements for annual-tasks row
//		VerticalLayout annualTasks = new VerticalLayout();
		Label lblAnnualTasks = new Label("Annual Tasks");
		annuallyTasksWrapper.add(lblAnnualTasks,annuallyTasks);
		horizManager.add(annuallyTasksWrapper);

		// elements for completed-tasks row
//		complTasks = new VerticalLayout();
//		Label lblComplTasks = new Label("Completed Tasks");
//		complTasks.add(lblComplTasks);
//		horizManager.add(complTasks);

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

		chBox = new Checkbox(task.getTask());
		Label date = new Label(task.getDate().toString());

		Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
		btnDelete.addClickListener(e -> presenter.deleteTask(task));

		HorizontalLayout horiz = new HorizontalLayout(chBox, date, btnDelete);

		weeklyTasks.add(horiz);

	}

	public void addMonthlyTask(Task task) {

		chBox = new Checkbox(task.getTask());
		Label date = new Label(task.getDate().toString());

		Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
		btnDelete.addClickListener(e -> presenter.deleteTask(task));

		HorizontalLayout horiz = new HorizontalLayout(chBox, date, btnDelete);

		monthlyTasks.add(horiz);
	}

	public void addAnnualTask(Task task) {

		chBox = new Checkbox(task.getTask());
		Label date = new Label(task.getDate().toString());

		Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
		btnDelete.addClickListener(e -> presenter.deleteTask(task));

		HorizontalLayout horiz = new HorizontalLayout(chBox, date, btnDelete);

		annuallyTasks.add(horiz);
	}

	public void addSpecialTask(Task task) {

		chBox = new Checkbox(task.getTask());
		Label date = new Label(task.getDate().toString());

		Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
		btnDelete.addClickListener(e -> presenter.deleteTask(task));

		HorizontalLayout horiz = new HorizontalLayout(chBox, date, btnDelete);

		specialTasks.add(horiz);
	}

	public void addComplTask(Task task) {

		if (chBox.getValue() == true)
			;
		{
			complTasks.add(chBox);

		}
	}

	public void deleteAllTaskinGui() {
		specialTasks.removeAll();
		weeklyTasks.removeAll();
		monthlyTasks.removeAll();
		annuallyTasks.removeAll();
		complTasks.removeAll();
	}

}
