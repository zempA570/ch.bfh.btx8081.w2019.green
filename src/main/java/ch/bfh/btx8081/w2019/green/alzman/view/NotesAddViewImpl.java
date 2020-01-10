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

	private TextField txtfAuthor;
	private DatePicker dpEntryDate;
	private TextArea txtaEntry;

	public NotesAddViewImpl() {

		// Change title in header
		super.setHeaderTitle("Add Key-Notes");

		// Label and a Textfield
		txtfAuthor = new TextField("Author");
		txtaEntry = new TextArea("Notes");
		dpEntryDate = new DatePicker("Date");

		// Display an icon which can be clicked to clear the value:
		dpEntryDate.setClearButtonVisible(true);
		dpEntryDate.setValue(LocalDate.now());

		txtaEntry.getStyle().set("minHeight", "250px");
		txtaEntry.setPlaceholder("Write here ...");

		// Buttons to be clickd on
		Button btnAddEntry = new Button("Add to Key-Notes", new Icon(VaadinIcon.PLUS));

		// Click Listener that triggers an Event for Add-To-Key-Notes-Button
		btnAddEntry.addClickListener(e -> {
			for (NotesAddListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		Notification infoNotification2 = new Notification("Entry added to Key-Notes!", 3000);
		btnAddEntry.addClickListener(e -> infoNotification2.open());

		// Put components in horizontal layout
		HorizontalLayout hlComponents1 = new HorizontalLayout();
		hlComponents1.setAlignItems(Alignment.BASELINE);
		hlComponents1.add(txtfAuthor, dpEntryDate);

		HorizontalLayout hlComponents2 = new HorizontalLayout();
		hlComponents2.setAlignItems(Alignment.BASELINE);
		hlComponents2.add(txtaEntry, btnAddEntry);

		// Adding components to content space
		super.addContent(hlComponents1);
		super.addContent(hlComponents2);
		
		new NotesAddPresenter(this);

	}

	@Override
	public void addListener(NotesAddListener listener) {
		listeners.add(listener);
	}

	@Override
	public LocalDate getDate() {
		return dpEntryDate.getValue();
	}

	@Override
	public String getAuthor() {
		return txtfAuthor.getValue();
	}

	@Override
	public String getEntry() {
		return txtaEntry.getValue();
	};

}
