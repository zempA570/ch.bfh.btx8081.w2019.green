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

@Route("dashboard")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DashboardView extends TemplateView {

	public DashboardView() {

		// displays the Title of this Component
		super.setHeaderTitle("Dashboard");

		// create and add icon to header
		Icon userIcon = new Icon(VaadinIcon.USERS);
		userIcon.setSize("40px");
		userIcon.addClickListener(e -> UI.getCurrent().navigate(UserManagementViewImpl.class));
		super.addHeader(userIcon);

		// creating Icons that are clickable
		Icon calendarIcon = new Icon(VaadinIcon.CALENDAR);
		calendarIcon.setSize("80px");

		Icon statusIcon = new Icon(VaadinIcon.BULLETS);
		statusIcon.setSize("80px");

		Icon importantNotesIcon = new Icon(VaadinIcon.NOTEBOOK);
		importantNotesIcon.setSize("80px");

		Icon diaryIcon = new Icon(VaadinIcon.EDIT);
		diaryIcon.setSize("80px");

		Icon todoIcon = new Icon(VaadinIcon.TASKS);
		todoIcon.setSize("80px");

		Icon infoBoxIcon = new Icon(VaadinIcon.INFO_CIRCLE);
		infoBoxIcon.setSize("80px");

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
		Label importantNotesText = new Label("Notes");
		Label diaryText = new Label("Diary");
		Label todoText = new Label("To-Do-List");
		Label infoBoxText = new Label("Infobox");

		// configuring the layout
		VerticalLayout iconViewLeft = new VerticalLayout(calendarText, calendarIcon, statusText, statusIcon,
				importantNotesText, importantNotesIcon);
		VerticalLayout iconViewRight = new VerticalLayout(diaryText, diaryIcon, todoText, todoIcon, infoBoxText,
				infoBoxIcon);

		HorizontalLayout iconViewCentral = new HorizontalLayout(iconViewLeft, iconViewRight);

		// configuring the icons so they can be clicked on
		/**
		 * the code below is working, waiting for the other View Classes to be finished
		 * so they can be implemented just as the one below
		 */

		calendarIcon.addClickListener(e -> UI.getCurrent().navigate(CalendarViewImpl.class));
		statusIcon.addClickListener(e -> UI.getCurrent().navigate(StatusViewImpl.class));
		todoIcon.addClickListener(e -> UI.getCurrent().navigate(ToDoListViewImpl.class));
		diaryIcon.addClickListener(e -> UI.getCurrent().navigate(DiaryViewImpl.class));
		importantNotesIcon.addClickListener(e -> UI.getCurrent().navigate(NotesViewImpl.class));
		infoBoxIcon.addClickListener(e -> UI.getCurrent().navigate(InfoboxViewImpl.class));

		super.addContent(iconViewCentral);

	}

}
