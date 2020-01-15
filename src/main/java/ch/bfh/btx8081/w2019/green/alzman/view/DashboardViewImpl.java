package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import ch.bfh.btx8081.w2019.green.alzman.presenter.DashboardPresenter;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryView.DiaryViewListener;

/**
 * This class represents the dashboard which is also the main-window of the application
 * the dashboard has clickable icons that are linked with their related functionalities
 * 
 * @author Simon
 *
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DashboardViewImpl extends TemplateView implements DashboardView {
	
	private List<DashboardViewListener> lstListeners = new ArrayList<DashboardViewListener>();

	private Icon icnUser;
	private Icon icnCalendar; 
	private Icon icnStatus;
	private Icon icnKeyNotes;
	private Icon icnDiary;
	private Icon icnToDo;
	private Icon icnInfoBox;
	
	public DashboardViewImpl() {

		// displays the Title of this Component
		super.setHeaderTitle("Dashboard");

		// create and add icon to header
		icnUser = new Icon(VaadinIcon.USERS);
		icnUser.setSize("40px");
		icnUser.setId("User");
		icnUser.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});
		super.addHeader(icnUser);

		// creating Icons
		icnCalendar = new Icon(VaadinIcon.CALENDAR);
		icnCalendar.setSize("80px");
		icnCalendar.setId("Calendar");

		icnStatus = new Icon(VaadinIcon.BULLETS);
		icnStatus.setSize("80px");
		icnStatus.setId("Status");

		icnKeyNotes = new Icon(VaadinIcon.NOTEBOOK);
		icnKeyNotes.setSize("80px");
		icnKeyNotes.setId("Notes");

		icnDiary = new Icon(VaadinIcon.EDIT);
		icnDiary.setSize("80px");
		icnDiary.setId("Diary");

		icnToDo = new Icon(VaadinIcon.TASKS);
		icnToDo.setSize("80px");
		icnToDo.setId("Todo");

		icnInfoBox = new Icon(VaadinIcon.INFO_CIRCLE);
		icnInfoBox.setSize("80px");
		icnInfoBox.setId("Infobox");

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
		icnCalendar.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});
		icnStatus.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});
		icnToDo.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});
		icnDiary.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});
		icnKeyNotes.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});
		icnInfoBox.addClickListener(e -> {
			for (DashboardViewListener listener : lstListeners)
				listener.iconClick(e.getSource());
		});

		super.addContent(hlComposedIconLayout);
		
		new DashboardPresenter(this);

	}

	@Override
	public void addListener(DashboardViewListener listener) {
		lstListeners.add(listener);
	}

}
