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
 * Abstract class for any future views, includes header. Footer disabled at the
 * moment because it doesnt add value
 * 
 * @author Adrian
 *
 */
public abstract class TemplateView extends VerticalLayout {

	private HorizontalLayout hlHeader;
	private VerticalLayout vlContent;
//	private HorizontalLayout hlFooter;
	private H2 title;

	public TemplateView() {

		// instantiate
		hlHeader = new HorizontalLayout();
		vlContent = new VerticalLayout();
//		hlFooter = new HorizontalLayout();

		// set id for styling in .css file
		hlHeader.setId("headerStyle");
		vlContent.setId("contentStyle");
//		hlFooter.setId("footerStyle");

		// add the three parts to the vertical layout.
		add(hlHeader);
		add(vlContent);
//		add(hlFooter);

		// fill the header and footer with stuff
		createStandardHeader();
//		createStandardFooter();

	}

	private void createStandardHeader() {

		Button btnBack = new Button("Home", new Icon(VaadinIcon.HOME));
		hlHeader.add(btnBack);
		btnBack.addClickListener(e -> UI.getCurrent().navigate(DashboardViewImpl.class));

		title = new H2("blank");
		hlHeader.add(title);

	}

//	private void createStandardFooter() {
//
//		Button btnLogOut = new Button("Logout", new Icon(VaadinIcon.CLOSE_CIRCLE_O));
//		hlFooter.add(btnLogOut);
//		btnLogOut.addClickListener(e -> UI.getCurrent().navigate(LogIn.class));
//	}

	/**
	 * Adds new components to the "header" area of the site Header is a horizontal
	 * layout
	 * 
	 * @param component The component to be added to the header
	 */
	public void addHeader(Component component) {
		hlHeader.add(component);
	}

	/**
	 * Adds new components to the "content" area of the site Content is a vertical
	 * layout
	 * 
	 * @param component The component to be added to the content
	 */
	public void addContent(Component component) {
		vlContent.add(component);
	}
//
//	/**
//	 * Adds new components to the "footer" area of the site Footer is a vertical
//	 * layout
//	 * 
//	 * @param component The component to be added to the footer
//	 */
//	public void addFooter(Component component) {
//		hlFooter.add(component);
//	}

	/**
	 * Changes the title in the header
	 * 
	 * @param newTitle
	 */
	public void setHeaderTitle(String newTitle) {
		title.setText(newTitle);
	}
}
