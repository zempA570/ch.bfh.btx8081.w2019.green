package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
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

		Button btnOpenUserManagement = new Button("User Management", new Icon(VaadinIcon.USERS));
		btnOpenUserManagement.addClickListener(e -> UI.getCurrent().navigate(UserManagementView.class));
		
		//Creating Elements
		
		
		
		/**
		 * If we opt for multiple users we can add a colleciton
		 * to the combobox below like in the example:
		 * 
		 * EXAMPLE
		 * ComboBox(String label,
        Collection<T> items)

		Creates a combo box with the defined label and populated with the items in the collection.
		 * 
		 * 
		 * NOTE: if we do choose to work with multiple users, code must be changed
		 * to work for objects and not strings
		 */
	ComboBox <String> chooseUserBox = new ComboBox<>("Users");
	chooseUserBox.setItems("TEST", "DUMMY", "BOT");
	
	chooseUserBox.addValueChangeListener(event -> {
		Button message = null;
		if (event.getSource().isEmpty()) {
			message.setText("The current User is TEST");
			
		} else {
			message.setText("The current User is" + event.getValue());
		}
	});
	
	Icon userIcon = new Icon(VaadinIcon.USERS);
	
	
	/**
	 * creating the Icons for the Dashboard
	 */
	Icon calendarIcon = new Icon(VaadinIcon.CALENDAR);
	
	Icon statusIcon = new Icon (VaadinIcon.BULLETS);
	
	Icon importantNotesIcon = new Icon(VaadinIcon.NOTEBOOK);
	
	Icon diaryIcon = new Icon(VaadinIcon.EDIT);
	
	Icon todoIcon = new Icon(VaadinIcon.TASKS);
	
	Icon infoBoxIcon = new Icon(VaadinIcon.INFO_CIRCLE);
	
	
	
	
	
	
	
	VerticalLayout iconViewLeft = new VerticalLayout(calendarIcon, statusIcon, importantNotesIcon);
	VerticalLayout iconViewRight = new VerticalLayout(diaryIcon, todoIcon,infoBoxIcon);
	HorizontalLayout userBar = new HorizontalLayout(chooseUserBox, userIcon);
	HorizontalLayout iconViewCentral = new HorizontalLayout(iconViewLeft,iconViewRight);

	//adding Stuff to the Objects
		super.addContent(btnOpenUserManagement);
		super.addContent(userBar);
		super.addContent(iconViewCentral);
		
		
	}
	
	
	}


