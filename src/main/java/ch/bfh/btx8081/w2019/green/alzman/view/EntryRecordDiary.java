package ch.bfh.btx8081.w2019.green.alzman.view;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.green.alzman.presenter.AddDiaryPresenter;
import ch.bfh.btx8081.w2019.green.alzman.presenter.UserManagementPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */

@Route("EntryRecordDiary")


@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class EntryRecordDiary extends TemplateView {
	
	private AddDiaryPresenter presenter;
	private LocalDate tdate;
	private TextArea tauthor;
	private TextArea tentry;

	public EntryRecordDiary() {		

		super.setHeaderTitle("Entry Record Diary");

				//Creating a new Datepicker.  
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		 
		
		
		//Creating a new Textarea
		tauthor = new TextArea();
		tauthor.setLabel("Author");
		
		
		//Creating a new Textarea
	
		tentry = new TextArea();
		tentry.setLabel("Entry");

		
		//Creating a new Button
		Button button = new Button("Add new Record", new Icon(VaadinIcon.PLUS));
		button.addClickListener(e -> presenter.addRecord(datePicker.getValue(), tauthor.getValue(), tentry.getValue()));
		
		
		
		//Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.add(datePicker, tauthor, tentry,button);
		
		//Adding components to content space
		super.addContent(verticalLayout);

	}
}
