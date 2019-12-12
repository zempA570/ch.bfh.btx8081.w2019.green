package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
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

		HorizontalLayout header = new HorizontalLayout();

		// title of the part 1 with label, horizontal

		Label spez = new Label("Special");
		Label date = new Label("Date");

		header.add(spez, date);

		// shows special tasks with duedate

		Label task1 = new Label("task1");
		Label date1 = new Label("date1");
		
		HorizontalLayout row = new HorizontalLayout(task1, date1); 

		// specialtasks shown in listbox

		ListBox<Strings> list1 = new ListBox<>();
		list1.add(row);
		
		//order in vertical
		VerticalLayout vertical = new VerticalLayout(); 
		vertical.add(header, list1);

		// header of the weekly-list
		Label weekly = new Label("weekly");
		Label d1 = new Label("Done");
		HorizontalLayout title1 = new HorizontalLayout(d1, weekly);

		// add tasks in form of checkboxes for weekly
		Checkbox ch1 = new Checkbox();
		ch1.setLabel("Post bearbeiten");
		Checkbox ch2 = new Checkbox();
		ch2.setLabel("Abendessen");

		ListBox<String> list2 = new ListBox<>();
		list2.add(ch1, ch2);

		// order header & list in verticalForm
		VerticalLayout vertical1 = new VerticalLayout();
		vertical1.add(title1, list2);

		// add monthly section
		Label monthly = new Label("monthly");
		Label d2 = new Label("Done"); 
		HorizontalLayout title2 = new HorizontalLayout(d2, monthly);

		//weekly tasks in form of checkbox'
		Checkbox ch3 = new Checkbox();
		ch3.setLabel("Wohnung Pieterlen - Mieter");
		Checkbox ch4 = new Checkbox();
		ch4.setLabel("Rechnungen zahlen");
		
		//add checkbox' to a new list
		ListBox<String> list3 = new ListBox<>();
		list3.add(ch3, ch4);

		//add to verticalLayout
		VerticalLayout vertical2 = new VerticalLayout(); 
		vertical2.add(title2, list3);
		
		// add annualy section
		Label annualy = new Label("annualy");
		Label d3 = new Label("Done"); 
		HorizontalLayout title3 = new HorizontalLayout(d3, annualy);

		//weekly tasks in form of checkbox'
		Checkbox ch5 = new Checkbox();
		ch5.setLabel("Steuererklärung");
		Checkbox ch6 = new Checkbox();
		ch6.setLabel("Versicherungen");
		
		//add checkbox' to a new list
		ListBox<String> list4 = new ListBox<>();
		list4.add(ch5, ch6);

		//add to verticalLayout
		VerticalLayout vertical3 = new VerticalLayout(); 
		vertical3.add(title3, list4);
		
		Label space1 = new Label ("     ");
		HorizontalLayout space = new HorizontalLayout(); 
		
		Button addNewTask = new Button(new Icon(VaadinIcon.PLUS)); 
		addNewTask.addClickListener(e -> UI.getCurrent().navigate(TaskEntryView.class)); 

		// adding components to content space
		super.addContent(vertical);
		super.addContent(vertical1);
		super.addContent(vertical2);
		super.addContent(vertical3);
		super.addContent(space); 
		super.addContent(addNewTask);

	}

}
