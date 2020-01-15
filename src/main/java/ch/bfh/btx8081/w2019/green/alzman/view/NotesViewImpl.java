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
/**
 * this class represents the (Key-)Notes View which the user can use to either
 * see the entries he made or delete them by clicking the button he can create a
 * new entry and is redirected to another View
 * 
 * @author simon
 *
 */
public class NotesViewImpl extends TemplateView implements NotesView {

	private List<NotesListener> lstNotesList = new ArrayList<NotesListener>();

	// title header and grid
	private H4 h4titleAddNotes;
	private Grid<NotesModel> grdNotes = new Grid<>();

	// private TextArea diaryText = new TextArea();

	public NotesViewImpl() {

		// Change title in header
		super.setHeaderTitle("Important Notes");

		// manipulating title
		h4titleAddNotes = new H4();
		h4titleAddNotes.setText("Key-Notes");
		super.addContent(h4titleAddNotes);

		// Button for a new entry
		Button btnAddEntry = new Button("Create New Entry");
		btnAddEntry.addClickListener(e -> {
			for (NotesListener listener : lstNotesList)
				listener.buttonClick(e.getSource());
		});

		// button to delete an entry
		Button btnDeleteEntry = new Button("Delete Selected Entry");
		btnDeleteEntry.setVisible(false);
		btnDeleteEntry.addClickListener(e -> {
			for (NotesListener listener : lstNotesList)
				listener.buttonClick(e.getSource());
		});

		// notify the user
		Notification message = new Notification("Deleted the Entry!");
		btnDeleteEntry.addClickListener(e -> message.open());

		// button to refresh the page
		Button btnRefreshPage = new Button("Refresh", new Icon(VaadinIcon.RECYCLE));
		btnRefreshPage.addClickListener(e -> {
			for (NotesListener listener : lstNotesList)
				listener.buttonClick(e.getSource());
		});

		// Creating horizontal layout & filling it
		VerticalLayout vlComponents1 = new VerticalLayout();

		vlComponents1.add(btnAddEntry, btnDeleteEntry, btnRefreshPage);
		super.addContent(vlComponents1);

		// setting up the Grid

		add(grdNotes);
		grdNotes.addColumn(NotesModel::getEntryID).setVisible(false);
		grdNotes.addColumn(NotesModel::getAuthor).setHeader("Author");
		grdNotes.addColumn(NotesModel::getDate).setHeader("Date");
		grdNotes.addColumn(NotesModel::getContent).setHeader("Note");

		grdNotes.addItemClickListener(event -> {
			btnDeleteEntry.setVisible(true);

		});

		super.addContent(grdNotes);

		new NotesPresenter(this);

	}

	public void fillGridWithEntries(List<NotesModel> lstEntries) {
		grdNotes.setItems(lstEntries);
	}

	@Override
	public void addListener(NotesListener listener) {
		lstNotesList.add(listener);
	}

	@Override
	public Set<NotesModel> getSelectedNote() {
		return grdNotes.getSelectedItems();
	};

}
