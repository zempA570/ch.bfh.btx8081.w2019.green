package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.ToDoListAddPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("todolistadd")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class ToDoListAddViewImpl extends TemplateView implements ToDoListAddView {

	private List<ToDoListAddViewListener> listeners = new ArrayList<ToDoListAddViewListener>();
	private TextField tfNewTask;
	private ComboBox<String> cmbbxRepetition;
	DatePicker dpDate;

	public ToDoListAddViewImpl() {

		// Change title in header
		super.setHeaderTitle("Add Task");

		// Creating elements
		tfNewTask = new TextField();
		tfNewTask.setLabel("Task");

		cmbbxRepetition = new ComboBox<>("Repetition");
		cmbbxRepetition.setItems("Weekly", "Monthly", "Annually", "None");

		Label lblDate = new Label("Date");
		dpDate = new DatePicker();
		dpDate.setClearButtonVisible(true);
		dpDate.setValue(LocalDate.now());

		Button btnAdd = new Button("Save & Add", new Icon(VaadinIcon.PLUS));
		btnAdd.addClickListener(e -> {
			for (ToDoListAddViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		// Creating horizontal layout
		HorizontalLayout hlASDF = new HorizontalLayout(tfNewTask, cmbbxRepetition);
		HorizontalLayout hlASDF2 = new HorizontalLayout(lblDate, dpDate, btnAdd);

		// Adding components to content space
		super.addContent(hlASDF);
		super.addContent(hlASDF2);

		new ToDoListAddPresenter(this);
	}

	@Override
	public void addListener(ToDoListAddViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public String getTask() {
		return tfNewTask.getValue();
	}

	@Override
	public String getRepetition() {
		return cmbbxRepetition.getValue();
	}

	@Override
	public LocalDate getDate() {
		return dpDate.getValue();
	}

}
