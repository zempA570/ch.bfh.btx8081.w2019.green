package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.ui.renderers.ImageRenderer;

import ch.bfh.btx8081.w2019.green.alzman.services.DbService;

<<<<<<< HEAD
@Route("Dashboard")

=======
@Route("")
>>>>>>> refs/remotes/origin/master
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DashboardView extends TemplateView {

	public DashboardView() {
		
		DbService.init();
		
		// displays the Title of this Component
		super.setHeaderTitle("Dashboard");

		// create and add icon to header
		Icon userIcon = new Icon(VaadinIcon.USERS);
		userIcon.setSize("40px");
		userIcon.addClickListener(e -> UI.getCurrent().navigate(UserManagementView.class));
		super.addHeader(userIcon);

		
	
		
		
		
		//creating buttons and icons for the dashboard menu
		Button calendarButton = new Button();
		Icon calendarIcon = new Icon(VaadinIcon.CALENDAR);
		calendarButton.getElement().appendChild(calendarIcon.getElement());
		
		Button statusButton = new Button();
		Icon statusIcon = new Icon(VaadinIcon.BULLETS);
		statusButton.getElement().appendChild(statusIcon.getElement());
		
		Button importantNotesButton = new Button();
		Icon importantNotesIcon = new Icon(VaadinIcon.NOTEBOOK);
		importantNotesButton.getElement().appendChild(importantNotesIcon.getElement());
		
		Button diaryButton = new Button();
		Icon diaryIcon = new Icon(VaadinIcon.EDIT);
		diaryButton.getElement().appendChild(diaryIcon.getElement());
		
		Button todoButton = new Button();
		Icon todoIcon = new Icon(VaadinIcon.TASKS);
		todoButton.getElement().appendChild(todoIcon.getElement());
		
		Button infoBoxButton = new Button();
		Icon infoBoxIcon = new Icon(VaadinIcon.INFO_CIRCLE);
		infoBoxButton.getElement().appendChild(infoBoxIcon.getElement());
		
		
		
		

		// change Icon Size and Shape
		calendarIcon.setSize("80px");
		statusIcon.setSize("80px");
		importantNotesIcon.setSize("80px");
		diaryIcon.setSize("80px");
		todoIcon.setSize("80px");
		infoBoxIcon.setSize("80px");
		
		

		// creating labels to label the icons
		Label calendarText = new Label("Calendar");
		Label statusText = new Label("Status");
		Label importantNotesText = new Label("Key-Notes");
		Label diaryText = new Label("Diary");
		Label todoText = new Label("To-Do-List");
		Label infoBoxText = new Label("Infobox");

		// configuring the layout
		VerticalLayout iconViewLeft = new VerticalLayout(calendarText, calendarButton, statusText, statusButton,
				importantNotesText, importantNotesButton);
		VerticalLayout iconViewRight = new VerticalLayout(diaryText, diaryButton, todoText, todoButton, infoBoxText,
				infoBoxButton);

		HorizontalLayout iconViewCentral = new HorizontalLayout(iconViewLeft, iconViewRight);
		
		//configuring the icons so they can be clicked on		
		/**
		 * the code below is working, waiting for the other View Classes to be finished so they can be
		 * implemented just as the one below
		 */
		infoBoxButton.addClickListener(event -> UI.getCurrent().navigate(InfoboxView.class));
		todoButton.addClickListener(e -> UI.getCurrent().navigate(ToDoListView.class));
		diaryButton.addClickListener(e -> UI.getCurrent().navigate(Diary.class));
		importantNotesButton.addClickListener(e -> UI.getCurrent().navigate(NotesView.class));
//		statusButton.addClickListener(e -> UI.getCurrent().navigate(UserManagementView.class));
		calendarButton.addClickListener(e -> UI.getCurrent().navigate(CalendarView.class));

		
		

		super.addContent(iconViewCentral);

	}

}
