package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import jdk.internal.joptsimple.internal.Strings;

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
	Label date = new Label ("Datum"); 
	
	//elements for specialtasks with date
	
	
//	ListBox<Strings> list1 = new ListBox<>(); 
//	list1.add(null);
//	
//	list1.setRenderer(new ComponentRenderer<> (task -> {
//		Label name = new Label("task1"); 
//		Label date = new Label("date1"); 
//	)};
//	Label name = new Label("task1"); 
//	Label date = new Label("date1"); 
//	
//	List<Strings> specialtasks = new ArrayList<>(); 
//	
//	specialtasks.addAll(name); 
	
	
	
	//add tasks in form of checkboxes for weekly/monthly/annually
	Checkbox ch1 = new Checkbox(); 
	ch1.setLabel("Post bearbeiten");
	Checkbox ch2 = new Checkbox(); 
	ch2.setLabel("Abendessen");
	
	//checkboxes added to the ListBox
Label weekly = new Label("weekly"); 
Label done = new Label ("Done"); 
HorizontalLayout title1 = new HorizontalLayout(weekly, done); 

ListBox<String> list1 = new ListBox<>(); 
list1.add(ch1, ch2);
	
//add to verticalLayout
list.add(title1, list1);
 
// add monthly section
Label monthly = new Label("monthly"); 
new Label("Done"); 
HorizontalLayout title2 = new HorizontalLayout(monthly, done); 

Checkbox ch3 = new Checkbox(); 
ch3.setLabel("Wohnung Pieterlen - Mieter");
Checkbox ch4 = new Checkbox(); 
ch4.setLabel("Rechnungen zahlen");

ListBox<String> list2 = new ListBox<>(); 
list1.add(ch3, ch4);
	
//add to verticalLayout
list.add(title2, list2);
	
	//adding components to content space
	super.addContent(list); 
	super.addContent(list2);
	
		
		
		
	}

}
