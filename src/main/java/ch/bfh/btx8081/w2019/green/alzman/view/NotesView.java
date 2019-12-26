package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.ironlist.IronList;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;
import ch.bfh.btx8081.w2019.green.alzman.model.ImportantNotesDataModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.ImportantNotesPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.NotesPresenter;


/**
 * The user management view will be used to add and remove users of the app
 */
@Route("Notes")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class NotesView extends TemplateView {
	
	//title header and grid
	private H4 titleAddNotes;
	private Grid<ImportantNotesDataModel> notesGrid= new Grid<>();
	
	//variable presenter
	private NotesPresenter presenter;
	

	//private TextArea diaryText = new TextArea();
	
	
	
	 public NotesView() {

		// Change title in header
		super.setHeaderTitle("Important Notes");
		
		//manipulating title
		titleAddNotes = new H4();
		titleAddNotes.setText("Key-Notes");
		super.addContent(titleAddNotes);
		
		
		
		// Button for a new entry
		Button buttonAddEntry = new Button("Create New Entry");
		buttonAddEntry.addClickListener(e -> UI.getCurrent().navigate(AddImportantNotes.class));
		
		//button to delete an entry
		Button buttonDeleteEntry = new Button("Delete Selected Entry");
		buttonDeleteEntry.setVisible(false);
		buttonDeleteEntry.addClickListener(e -> presenter.deleteEntry(notesGrid.getSelectedItems()));
		
		//notify the user
		Notification message = new Notification("Deleted the Entry!");
		buttonDeleteEntry.addClickListener(e -> message.open());
		
		//button to refresh the page
		Icon refreshPage = new Icon (VaadinIcon.RECYCLE);
		refreshPage.addClickListener(e -> UI.getCurrent().getPage().reload());
	
		

		
		// Creating horizontal layout & filling it
		VerticalLayout verticalLayout = new VerticalLayout();

		verticalLayout.add(buttonAddEntry,buttonDeleteEntry,refreshPage);
		super.addContent(verticalLayout);
		
		//setting up the Grid
		
		add(notesGrid);
		notesGrid.addColumn(ImportantNotesDataModel::getEntryID).setVisible(false);
		notesGrid.addColumn(ImportantNotesDataModel::getAuthor).setHeader("Author");
		notesGrid.addColumn(ImportantNotesDataModel::getDate).setHeader("Date");
		notesGrid.addColumn(ImportantNotesDataModel::getContent).setHeader("Note");
		
		notesGrid.addItemClickListener(event -> {
		buttonDeleteEntry.setVisible(true);
		
		});
		
		
		super.addContent(notesGrid);
		
		presenter = new NotesPresenter(this);
		

	

	}
	
	public void fillGridWithEntries(List<ImportantNotesDataModel> entryList) {
		notesGrid.setItems(entryList);
	};

}
