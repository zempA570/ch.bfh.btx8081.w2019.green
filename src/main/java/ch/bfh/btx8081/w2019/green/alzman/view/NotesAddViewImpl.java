package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.NotesAddPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("NotesAddView")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class NotesAddViewImpl extends TemplateView implements NotesAddView {

	private List<NotesAddListener> listeners = new ArrayList<NotesAddListener>();

	private TextField author;
	private DatePicker datePicker;
	private TextArea textArea;

	public NotesAddViewImpl() {

		// Change title in header
		super.setHeaderTitle("Add Key-Notes");

		// Label and a Textfield
		author = new TextField("Author");
		textArea = new TextArea("Notes");
		datePicker = new DatePicker("Date");

		// Display an icon which can be clicked to clear the value:
		datePicker.setClearButtonVisible(true);
		datePicker.setValue(LocalDate.now());

		textArea.getStyle().set("minHeight", "250px");
		textArea.setPlaceholder("Write here ...");

		// Buttons to be clickd on
		Button addEntry = new Button("Add to Key-Notes", new Icon(VaadinIcon.PLUS));

		// Click Listener that triggers an Event for Add-To-Key-Notes-Button
		addEntry.addClickListener(e -> {
			for (NotesAddListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		Notification infoNotification2 = new Notification("Entry added to Key-Notes!", 3000);
		addEntry.addClickListener(e -> infoNotification2.open());

		// Put components in horizontal layout
		HorizontalLayout addIN = new HorizontalLayout();
		addIN.setAlignItems(Alignment.BASELINE);
		addIN.add(author, datePicker);

		HorizontalLayout addIN2 = new HorizontalLayout();
		addIN2.setAlignItems(Alignment.BASELINE);
		addIN2.add(textArea, addEntry);

		// Adding components to content space
		super.addContent(addIN);
		super.addContent(addIN2);
		
		new NotesAddPresenter(this);

	}

	@Override
	public void addListener(NotesAddListener listener) {
		listeners.add(listener);
	}

	@Override
	public LocalDate getDate() {
		return datePicker.getValue();
	}

	@Override
	public String getAuthor() {
		return author.getValue();
	}

	@Override
	public String getEntry() {
		return textArea.getValue();
	};

}
