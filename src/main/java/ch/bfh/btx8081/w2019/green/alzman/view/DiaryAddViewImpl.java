package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.DiaryAddPresenter;


/**
 * The user management view will be used to add and remove users of the app
 */

@Route("EntryRecordDiary")

@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DiaryAddViewImpl extends TemplateView implements DiaryAddView {

	private List<DiaryAddViewListener> listeners = new ArrayList<DiaryAddViewListener>();
	private TextArea tauthor;
	private TextArea tentry;
	private DatePicker datePicker;
	private Button button;

	public DiaryAddViewImpl() {

		super.setHeaderTitle("Entry Record Diarymodel");

		// Creating a new Datepicker.
		datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());

		// Creating a new Textarea
		tauthor = new TextArea();
		tauthor.setLabel("Author");

		// Creating a new Textarea

		tentry = new TextArea();
		tentry.setLabel("Entry");

		// Creating a new Button
		button = new Button("Add new Record", new Icon(VaadinIcon.PLUS));
		button.addClickListener(e -> {
			for (DiaryAddViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		// Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.add(datePicker, tauthor, tentry, button);

		// Adding components to content space
		super.addContent(verticalLayout);

		new DiaryAddPresenter(this);
	}

	@Override
	public String getEntry() {
		return tentry.getValue();
	}

	@Override
	public LocalDate getDate() {
		return datePicker.getValue();
	}

	@Override
	public String getAuthor() {
		return tauthor.getValue();
	}

	@Override
	public void addListener(DiaryAddViewListener listener) {
		listeners.add(listener);
	}
}
