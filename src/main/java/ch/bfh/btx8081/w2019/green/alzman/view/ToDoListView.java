package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class ToDoListView extends TemplateView {

	public ToDoListView() {

		// Change title in header
		super.setHeaderTitle("To Do List");

		VerticalLayout list = new VerticalLayout(); 
		HorizontalLayout header = new HorizontalLayout();
		
	//title of the part 1 with label, horizontal
	Label spez = new Label("Ausserordentlich"); 
	Label date = new Label ("11.11.19"); 
	header.add(spez, date); 
	
	//add tasks in form of Checkboxes
	Checkbox ch1 = new Checkbox(); 
	ch1.setLabel("Paket holen");
	Checkbox ch2 = new Checkbox(); 
	ch2.setLabel("Kuchen kaufen");
	
	//checkboxes added to the ListBox
	ListBox<String> list1 = new ListBox<>(); 
	list1.add(header, ch1, ch2);
	
	

		
		
		
		
		
		
	}

}
