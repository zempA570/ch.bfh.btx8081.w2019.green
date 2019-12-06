package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * Abstract class for any future views, includes header and footer.
 * 
 * @author Adrian
 *
 */
public abstract class TemplateView extends VerticalLayout {

	private HorizontalLayout header;
	private VerticalLayout content;
	private HorizontalLayout footer;
	private H2 title;

	public TemplateView() {

		// instantiate
		header = new HorizontalLayout();
		content = new VerticalLayout();
		footer = new HorizontalLayout();

		// set id for styling in .css file
		header.setId("headerStyle");
		content.setId("contentStyle");
		footer.setId("footerStyle");

		// add the three parts to the vertical layout.
		add(header);
		add(content);
		add(footer);

		// fill the header and footer with stuff
		createStandardHeader();
		createStandardFooter();

//		Doesn't do anything (yet)
//		header.setAlignItems(FlexComponent.Alignment.CENTER);
	}

	private void createStandardHeader() {

		Button btnBack = new Button("Back", new Icon(VaadinIcon.CHEVRON_LEFT_SMALL));
		header.add(btnBack);
		btnBack.addClickListener(e -> UI.getCurrent().navigate(DashboardView.class));

		title = new H2("blank");
		header.add(title);

	}

	private void createStandardFooter() {

		Button btnLogOut = new Button("Logout", new Icon(VaadinIcon.CLOSE_CIRCLE_O));
		footer.add(btnLogOut);

	}

	/**
	 * Adds new components to the "content" area of the site
	 * 
	 * @param component The component to be added to the content
	 */
	public void addContent(Component component) {
		content.add(component);
	}

	/**
	 * Changes the title in the header
	 * 
	 * @param newTitle
	 */
	public void setHeaderTitle(String newTitle) {
		title.setText(newTitle);
	}

}
