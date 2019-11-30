package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MyUI extends VerticalLayout {

	public MyUI() {

		add(new DashboardGui());
		add(new CalendarGui());
		add(new InfoboxStart());
		add(new RegisterPerson());
		add(new ImportantNotes());
		add(new CreateTodo());
		add(new LoginUi());
		add(new RegisterUser());
		add(new TodoList());
//		missing todo-list-overview.js
//		add(new TodolistOverview());

	}

}
