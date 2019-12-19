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

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("todoList")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class ToDoListView extends TemplateView {

	public ToDoListView() {
		
	

		// Change title in header
		super.setHeaderTitle("To Do List");

		HorizontalLayout header = new HorizontalLayout();

		// title of the part 1 with label, horizontal

		Label spez = new Label("Special Tasks");
		Label date = new Label("Date");

		header.add(spez, date);

		// shows special tasks with duedate

		Label task1 = new Label("task1");
		Label date1 = new Label("date1");
		
		HorizontalLayout row = new HorizontalLayout(task1, date1); 

		// specialtasks shown in listbox

		ListBox<String> list1 = new ListBox<>();
		list1.add(row);
		
		//order in vertical
		VerticalLayout vertical = new VerticalLayout(); 
		vertical.add(header, list1);

		// header of the weekly-list
		Label t1 = new Label("tasks");
		Label weekly = new Label("Weekly");
		HorizontalLayout title1 = new HorizontalLayout(weekly, t1);

		// add tasks in form of checkboxes for weekly
		Checkbox ch1 = new Checkbox();
		ch1.setLabel("Post bearbeiten");
		Checkbox ch2 = new Checkbox();
		ch2.setLabel("Abendessen");

		ListBox<String> week = new ListBox<>();
		week.add(ch1, ch2);

		// order header & list in verticalForm
		VerticalLayout vertical1 = new VerticalLayout();
		vertical1.add(title1, week);

		// add monthly section
		Label monthly = new Label("Monthly");
		Label t2 = new Label("tasks"); 
		HorizontalLayout title2 = new HorizontalLayout(monthly, t2);

		//weekly tasks in form of checkbox'
		Checkbox ch3 = new Checkbox();
		ch3.setLabel("Appartment Pieterlen");
		Checkbox ch4 = new Checkbox();
		ch4.setLabel("Paying Invoices");
		
		//add checkbox' to a new list
		ListBox<String> month = new ListBox<>();
		month.add(ch3, ch4);

		//add to verticalLayout
		VerticalLayout vertical2 = new VerticalLayout(); 
		vertical2.add(title2, month);
		
		// add annualy section
		Label annualy = new Label("Annually");
		Label t3 = new Label("tasks"); 
		HorizontalLayout title3 = new HorizontalLayout(annualy, t3);

		//weekly tasks in form of checkbox'
		Checkbox ch5 = new Checkbox();
		ch5.setLabel("Tax declaration");
		Checkbox ch6 = new Checkbox();
		ch6.setLabel("Insurances");
		
		//add checkbox' to a new list
		ListBox<String> list4 = new ListBox<>();
		list4.add(ch5, ch6);

		//add to verticalLayout
		VerticalLayout vertical3 = new VerticalLayout(); 
		vertical3.add(title3, list4);
		
//		Label space1 = new Label ("     ");
//		HorizontalLayout space = new HorizontalLayout(); 
		
		Button addNewTask = new Button("add new Task", new Icon(VaadinIcon.PLUS)); 
		addNewTask.addClickListener(e -> UI.getCurrent().navigate(TaskEntryView.class)); 
		vertical3.add(addNewTask);
		
		//HorizontalLayout adding = new HorizontalLayout(addNewTask); 

		// adding components to content space
		super.addContent(vertical);
		super.addContent(vertical1);
		super.addContent(vertical2);
		super.addContent(vertical3);
		//super.addContent(space); 
		//super.addContent(addNewTask);
		

	}

}
