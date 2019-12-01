package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class MyUI extends TemplateView {

	public MyUI() {

		super.setHeaderTitle("SchnäbiZägg");

		TimePicker timePicker = new TimePicker();

		super.addContent(timePicker);

	}

}
