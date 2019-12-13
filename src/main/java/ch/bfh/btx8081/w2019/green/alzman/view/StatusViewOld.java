package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.CssImport.Container;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("Statusview")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")

public class StatusView extends TemplateView {

	public StatusView() {

		// Change title in header
		super.setHeaderTitle("Status");

		// GUI Layout
		
		/**
		 * A Layout from Vaadin, with which you can align the elements vertically.
		 */
		
		FormLayout detailsLayout = new FormLayout();
		
		/**
		 * Details is a component of Vaadin with which you can 
		 * expand a text to get more information.
		 * infocomponent01 explains what is meant by "independent".
		 */
		Details infocomponent01 = new Details("Independend",
		        new Text("Here you can add activities and properties that "
		        		+ "your relative can practise independently and without "
		        		+ "outside help."));
		
		/**
		 * infocomponent02 explains what is meant by "with help".
		 */
		
		Details infocomponent02 = new Details("With Help",
		        new Text("Here you can add activities and properties that "
		        		+ "your relative can perform with support."));
		
		/**
		 * infocomponent03 explains what is meant by "dependent".
		 */
		
		Details infocomponent03 = new Details("Dependend",
		        new Text("Here you can add activities and features that your"
		        		+ " loved one can no longer perform "
		        		+ "independently and needs full help.."));
		
		/**
		 * With this layout feature the Details components
		 * are displayed in a structured way.
		 */
		detailsLayout.setResponsiveSteps(
		        new ResponsiveStep("25em", 1),
		        new ResponsiveStep("32em", 2),
		        new ResponsiveStep("40em", 3));
		
		
		/**
		 * With the FormLayout from Vaadin, 4 Layouts are created
		 * The textLayout contains the three Details component.
		 * textLayout02, textLayout03 and textLayout04
		 * contains three vertical textfields.
		 */
		FormLayout textLayout = new FormLayout();
		FormLayout textLayout02 = new FormLayout();
		FormLayout textLayout03 = new FormLayout();
		FormLayout textLayout04 = new FormLayout();
		
		/**
		 * This three Textfields are in vertical order under the
		 * Details components.
		 */
		TextField independendField = new TextField();
		TextField withHelpField = new TextField();
		TextField dependendField = new TextField();
		
		/**
		 * This are also textfields in a vertical arrangement under the
		 * three above.
		 */
		TextField independendField02 = new TextField();
		TextField withHelpField02 = new TextField();
		TextField dependendField02 = new TextField();
		
		/**
		 * This are the last three textfields in a vertical arrangement.
		 */
		TextField independendField03 = new TextField();
		TextField withHelpField03 = new TextField();
		TextField dependendField03 = new TextField();
		
		/**
		 * The textfields are now added to the for layouts.
		 */
		textLayout.add(independendField, withHelpField, dependendField);
		textLayout02.add(independendField02, withHelpField02, dependendField02);
		textLayout03.add(independendField03, withHelpField03, dependendField03);
		detailsLayout.add(infocomponent01, infocomponent02, infocomponent03);
		
		
		/**
		 * With this layout feature, 
		 * the text fields are displayed next 
		 * to each other at the same distance.
		 */
		textLayout.setResponsiveSteps(
		        new ResponsiveStep("25em", 1),
		        new ResponsiveStep("32em", 2),
		        new ResponsiveStep("40em", 3));
		
		textLayout02.setResponsiveSteps(
		        new ResponsiveStep("25em", 1),
		        new ResponsiveStep("32em", 2),
		        new ResponsiveStep("40em", 3));
		
		textLayout03.setResponsiveSteps(
		        new ResponsiveStep("20em", 1),
		        new ResponsiveStep("25em", 2),
		        new ResponsiveStep("30em", 3));

		/**
		 * When the user clicks this button, 
		 * a new text field is created. 
		 * Currently this button does not have a trigger event.
		 */
		Button button1 = new Button("+");
		
		/**
		 * The textLayout04 layout is located below the other layouts. 
		 * Thus, the button that is added to this layout
		 * is also below all text fields.
		 */
		textLayout04.add(button1);
		
		/**
		 * With the super-function all layouts  are added to the view 
		 * and thus visible for the user on the website.
		 */
		super.add(textLayout);
		super.add(textLayout02);
		super.add(textLayout03);
		super.add(button1);
		
		
		/**
		 * The Details components in the detailsLayout
		 * will be above the text fields.
		 */
		super.addContent(detailsLayout);
		
		
		
		
	}

}
