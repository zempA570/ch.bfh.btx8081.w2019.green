package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DashboardView extends TemplateView {

	public DashboardView() {

		// displays the Title of this Component
		super.setHeaderTitle("Dashboard");

		// create and add icon to header
		Icon userIcon = new Icon(VaadinIcon.USERS);
		userIcon.setSize("40px");
		userIcon.addClickListener(e -> UI.getCurrent().navigate(UserManagementView.class));
		super.addHeader(userIcon);

		// creating the Icons for the Dashboard
		Icon calendarIcon = new Icon(VaadinIcon.CALENDAR);
		Icon statusIcon = new Icon(VaadinIcon.BULLETS);
		Icon importantNotesIcon = new Icon(VaadinIcon.NOTEBOOK);
		Icon diaryIcon = new Icon(VaadinIcon.EDIT);
		Icon todoIcon = new Icon(VaadinIcon.TASKS);
		Icon infoBoxIcon = new Icon(VaadinIcon.INFO_CIRCLE);

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
		VerticalLayout iconViewLeft = new VerticalLayout(calendarText, calendarIcon, statusText, statusIcon,
				importantNotesText, importantNotesIcon);
		VerticalLayout iconViewRight = new VerticalLayout(diaryText, diaryIcon, todoText, todoIcon, infoBoxText,
				infoBoxIcon);

		HorizontalLayout iconViewCentral = new HorizontalLayout(iconViewLeft, iconViewRight);

		super.addContent(iconViewCentral);

	}

}
