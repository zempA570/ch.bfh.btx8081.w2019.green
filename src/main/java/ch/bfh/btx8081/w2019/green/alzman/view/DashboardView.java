package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DashboardView extends TemplateView {

	public DashboardView() {

		super.setHeaderTitle("Dashboard");

		Button btnOpenUserManagement = new Button("User Management", new Icon(VaadinIcon.USERS));
		btnOpenUserManagement.addClickListener(e -> UI.getCurrent().navigate(UserManagementView.class));

		super.addContent(btnOpenUserManagement);

	}

}
