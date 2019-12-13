package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;

import com.vaadin.flow.component.UI;
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

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class Diary extends TemplateView {

	public Diary() {
		
		super.setHeaderTitle("Diary");

		//Creating a new Textarea
		TextArea textArea = new TextArea("");
		textArea.setPlaceholder("");
		
		// Add a new Diary
		Button button = new Button("Add new Diary", new Icon(VaadinIcon.PLUS));
		button.addClickListener(e -> UI.getCurrent().navigate(EntryRecordDiary.class));
		
		//Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout(button, textArea);
		
		//Adding components to content space
		super.addContent(verticalLayout);

		
	}
}
