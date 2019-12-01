package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class TemplateView extends VerticalLayout {

	private HorizontalLayout header;
	private VerticalLayout content;
	private HorizontalLayout footer;
	private H2 title;

	public TemplateView() {

		header = new HorizontalLayout();
		content = new VerticalLayout();
		footer = new HorizontalLayout();

		header.setId("headerStyle");
		content.setId("contentStyle");
		footer.setId("footerStyle");

		add(header);
		add(content);
		add(footer);

		createStandardHeader();
		createStandardFooter();

		header.setAlignItems(FlexComponent.Alignment.CENTER);
	}

	private void createStandardHeader() {

		Button btnBack = new Button("Back", new Icon(VaadinIcon.CHEVRON_LEFT_SMALL));
		header.add(btnBack);

		title = new H2("blank");
		header.add(title);

	}

	private void createStandardFooter() {

		Button btnLogOut = new Button("Logout", new Icon(VaadinIcon.CLOSE_CIRCLE_O));
		footer.add(btnLogOut);

	}

	public void addContent(Component component) {
		content.add(component);
	}

	public void setHeaderTitle(String newTitle) {
		title.setText(newTitle);
	}

}
