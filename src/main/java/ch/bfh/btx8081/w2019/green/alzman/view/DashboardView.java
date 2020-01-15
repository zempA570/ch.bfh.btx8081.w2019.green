package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * This class represents the dashboard which is also the main-window of the application
 * the dashboard has clickable icons that are linked with their related functionalities
 * 
 * @author simon
 *
 */
@Route("dashboard")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DashboardView extends TemplateView {

	public DashboardView() {

		// displays the Title of this Component
		super.setHeaderTitle("Dashboard");

		// create and add icon to header
		Icon icnUser = new Icon(VaadinIcon.USERS);
		icnUser.setSize("40px");
		icnUser.addClickListener(e -> UI.getCurrent().navigate(UserManagementViewImpl.class));
		super.addHeader(icnUser);

		// creating Icons that are clickable
		Icon icnCalendar = new Icon(VaadinIcon.CALENDAR);
		icnCalendar.setSize("80px");

		Icon icnStatus = new Icon(VaadinIcon.BULLETS);
		icnStatus.setSize("80px");

		Icon icnKeyNotes = new Icon(VaadinIcon.NOTEBOOK);
		icnKeyNotes.setSize("80px");

		Icon icnDiary = new Icon(VaadinIcon.EDIT);
		icnDiary.setSize("80px");

		Icon icnToDo = new Icon(VaadinIcon.TASKS);
		icnToDo.setSize("80px");

		Icon icnInfoBox = new Icon(VaadinIcon.INFO_CIRCLE);
		icnInfoBox.setSize("80px");

		// change Icon Size and Shape
		icnCalendar.setSize("80px");
		icnStatus.setSize("80px");
		icnKeyNotes.setSize("80px");
		icnDiary.setSize("80px");
		icnToDo.setSize("80px");
		icnInfoBox.setSize("80px");

		// creating labels to label the icons
		Label calendarText = new Label("Calendar");
		Label statusText = new Label("Status");
		Label importantNotesText = new Label("Notes");
		Label diaryText = new Label("Diary");
		Label todoText = new Label("To-Do-List");
		Label infoBoxText = new Label("Infobox");

		// configuring the layout
		VerticalLayout vlLeftSideIcons = new VerticalLayout(calendarText, icnCalendar, statusText, icnStatus,
				importantNotesText, icnKeyNotes);
		VerticalLayout vlRightSideIcons = new VerticalLayout(diaryText, icnDiary, todoText, icnToDo, infoBoxText,
				icnInfoBox);

		HorizontalLayout hlComposedIconLayout = new HorizontalLayout(vlLeftSideIcons, vlRightSideIcons);

		// configuring the icons so they can be clicked on
		icnCalendar.addClickListener(e -> UI.getCurrent().navigate(CalendarViewImpl.class));
		icnStatus.addClickListener(e -> UI.getCurrent().navigate(StatusViewImpl.class));
		icnToDo.addClickListener(e -> UI.getCurrent().navigate(ToDoListViewImpl.class));
		icnDiary.addClickListener(e -> UI.getCurrent().navigate(DiaryViewImpl.class));
		icnKeyNotes.addClickListener(e -> UI.getCurrent().navigate(NotesViewImpl.class));
		icnInfoBox.addClickListener(e -> UI.getCurrent().navigate(InfoboxViewImpl.class));

		//composing the layout
		
		super.addContent(hlComposedIconLayout);

	}

}
