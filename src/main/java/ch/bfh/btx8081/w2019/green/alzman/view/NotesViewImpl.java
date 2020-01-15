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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.NotesPresenter;

/**
 * this class represents the (Key-)Notes View which the user can use to either
 * see the entries he made or delete them by clicking the button he can create a
 * new entry and is redirected to another View
 * 
 * @author Simon
 *
 */
@Route("notes")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class NotesViewImpl extends TemplateView implements NotesView {

	private List<NotesListener> lstNotes = new ArrayList<NotesListener>();

	// grid
	private Grid<NotesModel> grdNotes = new Grid<>();

	public NotesViewImpl() {

		// Change title in header
		super.setHeaderTitle("Key-Notes");

		// Button for a new entry
		Button btnAddEntry = new Button("Create New Entry");
		btnAddEntry.addClickListener(e -> {
			for (NotesListener listener : lstNotes)
				listener.buttonClick(e.getSource());
		});

		// button to delete an entry
		Button btnDeleteEntry = new Button("Delete Selected Entry");
		btnDeleteEntry.setVisible(false);
		btnDeleteEntry.addClickListener(e -> {
			for (NotesListener listener : lstNotes)
				listener.buttonClick(e.getSource());
		});

		// notify the user
		Notification message = new Notification("Deleted the Entry!");
		btnDeleteEntry.addClickListener(e -> message.open());

		// button to refresh the page
		Button btnRefreshPage = new Button("Refresh", new Icon(VaadinIcon.RECYCLE));
		btnRefreshPage.addClickListener(e -> {
			for (NotesListener listener : lstNotes)
				listener.buttonClick(e.getSource());
		});

		// Creating horizontal layout & filling it
		HorizontalLayout hlButtonControlCenter = new HorizontalLayout();

		hlButtonControlCenter.add(btnAddEntry, btnRefreshPage, btnDeleteEntry);
		super.addContent(hlButtonControlCenter);

		// setting up the Grid
		add(grdNotes);
		grdNotes.addColumn(NotesModel::getEntryID).setVisible(false);
		grdNotes.addColumn(NotesModel::getAuthor).setHeader("Author");
		grdNotes.addColumn(NotesModel::getDate).setHeader("Date");
		grdNotes.addColumn(NotesModel::getContent).setHeader("Note");

		grdNotes.addItemClickListener(event -> {
			if (grdNotes.getSelectedItems().isEmpty()) {
				btnDeleteEntry.setVisible(false);
			} else {
				btnDeleteEntry.setVisible(true);
			}
		});

		super.addContent(grdNotes);

		new NotesPresenter(this);
	}

	public void fillGridWithEntries(List<NotesModel> lstEntries) {
		grdNotes.setItems(lstEntries);
	}

	@Override
	public void addListener(NotesListener listener) {
		lstNotes.add(listener);
	}

	@Override
	public Set<NotesModel> getSelectedNote() {
		return grdNotes.getSelectedItems();
	};

}
