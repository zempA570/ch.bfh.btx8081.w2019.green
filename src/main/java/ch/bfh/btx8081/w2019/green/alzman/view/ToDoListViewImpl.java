package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.ToDoListPresenter;

/**
 * @author Jasmitha
 * 
 *         The TodoList View shows all added tasks
 */
@Route("todolist")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class ToDoListViewImpl extends TemplateView implements ToDoListView {

	private List<ToDoListViewListener> listeners = new ArrayList<ToDoListViewListener>();

	// all needed verticalLayouts
	private VerticalLayout vlWeeklyWrapper = new VerticalLayout();
	private VerticalLayout vlWeeklyContent = new VerticalLayout();
	private VerticalLayout vlMonthlyWrapper = new VerticalLayout();
	private VerticalLayout vlMonthlyContent = new VerticalLayout();
	private VerticalLayout vlAnuallyWrapper = new VerticalLayout();
	private VerticalLayout vlAnuallyContent = new VerticalLayout();
	private VerticalLayout vlSpecialWrapper = new VerticalLayout();
	private VerticalLayout vlSpecialContent = new VerticalLayout();
	private VerticalLayout vlCompletedWrapper = new VerticalLayout();
	private VerticalLayout vlCompletedContent = new VerticalLayout();
	private Checkbox chkbxDone;

	public ToDoListViewImpl() {

		// Change title in header
		super.setHeaderTitle("To Do List");
		HorizontalLayout hlMainContent = new HorizontalLayout();
		hlMainContent.setWidthFull();

		// elements for special-tasks column
		Label lblSpecialTasks = new Label("Special Tasks");
		vlSpecialWrapper.add(lblSpecialTasks, vlSpecialContent);
		hlMainContent.add(vlSpecialWrapper);

		// elements for weekly-tasks column
		Label lblWeeklyTasks = new Label("Weekly Tasks");
		vlWeeklyWrapper.add(lblWeeklyTasks, vlWeeklyContent);
		hlMainContent.add(vlWeeklyWrapper);

		// elements for monthly-tasks column
		Label lblMonthlyTasks = new Label("Monthly Tasks");
		vlMonthlyWrapper.add(lblMonthlyTasks, vlMonthlyContent);
		hlMainContent.add(vlMonthlyWrapper);

		// elements for annual-tasks column
		Label lblAnnualTasks = new Label("Annual Tasks");
		vlAnuallyWrapper.add(lblAnnualTasks, vlAnuallyContent);
		hlMainContent.add(vlAnuallyWrapper);

		// elements for completed-tasks column
		Label lblComplTasks = new Label("Completed Tasks");
		vlCompletedWrapper.add(lblComplTasks, vlCompletedContent);
		hlMainContent.add(vlCompletedWrapper);

		Button addNewTask = new Button("Add new Task", new Icon(VaadinIcon.PLUS));
		addNewTask.addClickListener(e -> {
			for (ToDoListViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});
		VerticalLayout vertButton = new VerticalLayout();
		vertButton.add(addNewTask);

		// adding components to content space
		super.addContent(hlMainContent);
		super.addContent(vertButton);

		new ToDoListPresenter(this);

	}

	// adding tasks per repetition-groups
	public void addWeeklyTask(TaskModel task) {
		vlWeeklyContent.add(createGuiElement(task));
	}

	public void addMonthlyTask(TaskModel task) {
		vlMonthlyContent.add(createGuiElement(task));
	}

	public void addAnnualTask(TaskModel task) {
		vlAnuallyContent.add(createGuiElement(task));
	}

	public void addSpecialTask(TaskModel task) {
		vlSpecialContent.add(createGuiElement(task));
	}

	public void addComplTask(TaskModel task) {
		vlCompletedContent.add(createGuiElement(task));
	}

	private HorizontalLayout createGuiElement(TaskModel task) {
	
		Label lblDate = new Label(task.getDate().toString());
		String taskId = Integer.toString(task.getId());
	
		Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
		btnDelete.setId(taskId);
		btnDelete.addClickListener(e -> {
			for (ToDoListViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});
	
		// This button is invisible and not added to the view
		// It's used to differentiate in the ToDoListPresenter what was clicked
		Button btnInvisible = new Button("Checkbox Clicked");
		btnInvisible.setId(taskId);
	
		chkbxDone = new Checkbox(task.getTask());
		if (task.isDone()) {
			chkbxDone.setValue(true);
		}
	
		chkbxDone.addClickListener(e -> {
			for (ToDoListViewListener listener : listeners)
				listener.buttonClick(btnInvisible);
		});
	
		// horizontallayout for show a complete task
		HorizontalLayout hlTask = new HorizontalLayout(chkbxDone, lblDate, btnDelete);
		return hlTask;
	}

	// delete all tasks
	public void deleteAllTasksInGui() {
		vlSpecialContent.removeAll();
		vlWeeklyContent.removeAll();
		vlMonthlyContent.removeAll();
		vlAnuallyContent.removeAll();
		vlCompletedContent.removeAll();
	}

	@Override
	public void addListener(ToDoListViewListener listener) {
		listeners.add(listener);
	}

}
