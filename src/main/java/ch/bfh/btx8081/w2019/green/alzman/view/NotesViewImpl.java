package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.NotesPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("Notes")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class NotesViewImpl extends TemplateView implements NotesView {
	
	private List<NotesListener> listeners = new ArrayList<NotesListener>();

	// title header and grid
	private H4 titleAddNotes;
	private Grid<NotesModel> notesGrid = new Grid<>();

	// private TextArea diaryText = new TextArea();

	public NotesViewImpl() {

		// Change title in header
		super.setHeaderTitle("Important Notes");

		// manipulating title
		titleAddNotes = new H4();
		titleAddNotes.setText("Key-Notes");
		super.addContent(titleAddNotes);

		// Button for a new entry
		Button buttonAddEntry = new Button("Create New Entry");
		buttonAddEntry.addClickListener(e -> {
			for (NotesListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		// button to delete an entry
		Button buttonDeleteEntry = new Button("Delete Selected Entry");
		buttonDeleteEntry.setVisible(false);
		buttonDeleteEntry.addClickListener(e -> {
			for (NotesListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		// notify the user
		Notification message = new Notification("Deleted the Entry!");
		buttonDeleteEntry.addClickListener(e -> message.open());

		// button to refresh the page
		Button btnRefreshPage = new Button("Refresh", new Icon(VaadinIcon.RECYCLE));
		btnRefreshPage.addClickListener(e -> {
			for (NotesListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		// Creating horizontal layout & filling it
		VerticalLayout verticalLayout = new VerticalLayout();

		verticalLayout.add(buttonAddEntry, buttonDeleteEntry, btnRefreshPage);
		super.addContent(verticalLayout);

		// setting up the Grid

		add(notesGrid);
		notesGrid.addColumn(NotesModel::getEntryID).setVisible(false);
		notesGrid.addColumn(NotesModel::getAuthor).setHeader("Author");
		notesGrid.addColumn(NotesModel::getDate).setHeader("Date");
		notesGrid.addColumn(NotesModel::getContent).setHeader("Note");

		notesGrid.addItemClickListener(event -> {
			buttonDeleteEntry.setVisible(true);

		});

		super.addContent(notesGrid);

		new NotesPresenter(this);

	}

	public void fillGridWithEntries(List<NotesModel> entryList) {
		notesGrid.setItems(entryList);
	}

	@Override
	public void addListener(NotesListener listener) {
		listeners.add(listener);
	}

	@Override
	public Set<NotesModel> getSelectedNote() {
		return notesGrid.getSelectedItems();
	};

}
