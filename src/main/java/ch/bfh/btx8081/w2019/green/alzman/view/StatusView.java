package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.StatusPresenter;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;

/**
 * The user management view will be used to add and remove users of the app
 * 
 * @author Emily Torresan
 */

@Route("statusview")
//@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
@CssImport(value = "./styles/statusStyle.css", include = "common-styles")

public class StatusView extends TemplateView {

	public StatusView() {

		super.setHeaderTitle("Status");
		setSizeFull();
		setAlignItems(Alignment.CENTER);

		// GUI Layout

		/**
		 * A Layout from Vaadin, with which you can align the elements vertically.
		 */

		FormLayout detailsLayout = new FormLayout();
		/**
		 * Details is a component of Vaadin with which you can expand a text to get more
		 * information. infocomponent01 explains what is meant by "independent".
		 */
		Details infocomponent01 = new Details("Independend", new Text("Here you can add activities and properties that "
				+ "your relative can practise independently and without " + "outside help."));

		/**
		 * infocomponent02 explains what is meant by "with help".
		 */

		Details infocomponent02 = new Details("With Help", new Text(
				"Here you can add activities and properties that " + "your relative can perform with support."));

		/**
		 * infocomponent03 explains what is meant by "dependent".
		 */

		Details infocomponent03 = new Details("Dependend", new Text("Here you can add activities and features that your"
				+ " loved one can no longer perform " + "independently and needs full help.."));

		/**
		 * With this layout feature the Details components are displayed in a structured
		 * way.
		 */
		detailsLayout.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		detailsLayout.add(infocomponent01, infocomponent02, infocomponent03);
		super.addContent(detailsLayout);

//---------------------------------------------------------------------------------
		/**
		 * Below the Details components a new layout for the buttons will be created.
		 * The form layout of Vaadin allows to display the different components in an
		 * orderly way.
		 */

		FormLayout textLayout04 = new FormLayout();

		textLayout04.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		/**
		 * In this form layout, three icons with the plus symbol are added. The size of
		 * these icons is determined, as is the color.
		 * 
		 * @plus01 This icon is implemented for the functionality of the area
		 *         "independent".
		 * 
		 * @plus02 This icon is implemented for the functionality of the area "with
		 *         help".
		 * 
		 * @plus03 This icon is implemented for the functionality of the area
		 *         "dependent".
		 * 
		 *         See the Click Events section for more details.
		 */

		Icon plus01 = new Icon(VaadinIcon.PLUS);
		plus01.setSize("30px");
		plus01.setColor("lightgreen");

		Icon plus02 = new Icon(VaadinIcon.PLUS);
		plus02.setSize("30px");
		plus02.setColor("lightgreen");

		Icon plus03 = new Icon(VaadinIcon.PLUS);
		plus03.setSize("30px");
		plus03.setColor("lightgreen");

		textLayout04.add(plus01, plus02, plus03);

		super.add(textLayout04);

//---------------------------------------------------------------------------------
		/**
		 * In this form layout, three icons with a check symbol are added. The size of
		 * these icons is determined, as is the color. At the beginning these icons are
		 * not visible, because the user must first unlock the text field with the plus
		 * icon and enter a text.
		 * 
		 */

		Icon check01 = new Icon(VaadinIcon.CHECK_CIRCLE);
		check01.setSize("25px");
		check01.setColor("blue");
		check01.setVisible(false);

		Icon check02 = new Icon(VaadinIcon.CHECK_CIRCLE);
		check02.setSize("25px");
		check02.setColor("blue");
		check02.setVisible(false);

		Icon check03 = new Icon(VaadinIcon.CHECK_CIRCLE);
		check03.setSize("25px");
		check03.setColor("blue");
		check03.setVisible(false);
//-----------------------------------------------------------------------------------	

		FormLayout textLayout05 = new FormLayout();

		textLayout05.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		TextField textFieldDep = new TextField();
		textFieldDep.setValue("Dependend");
		textFieldDep.addClassName("wrapperField");
		textFieldDep.setEnabled(false);
		textFieldDep.setVisible(false);

		TextField textFieldIndep = new TextField();
		textFieldIndep.setValue("Independend");
		textFieldIndep.addClassName("wrapperField");
		textFieldIndep.setEnabled(false);
		textFieldIndep.setVisible(false);

		TextField textFieldWhelp = new TextField();
		textFieldWhelp.setValue("With Help");
		textFieldWhelp.addClassName("wrapperField");
		textFieldWhelp.setEnabled(false);
		textFieldWhelp.setVisible(false);
		// textFieldWhelp.setVisible(false);

		textLayout05.add(textFieldDep, check01, textFieldIndep, check02, textFieldWhelp, check03);

		super.add(textLayout05);

//----------------------------------------------------------------------------------		

		plus01.addClickListener(event -> textFieldDep.setVisible(true));
		plus01.addClickListener(event -> textFieldDep.setEnabled(true));
		plus01.addClickListener(event -> check01.setVisible(true));

		plus02.addClickListener(event -> textFieldIndep.setVisible(true));
		plus02.addClickListener(event -> textFieldIndep.setEnabled(true));
		plus02.addClickListener(event -> check02.setVisible(true));

		plus03.addClickListener(event -> textFieldWhelp.setVisible(true));
		plus03.addClickListener(event -> textFieldWhelp.setEnabled(true));
		plus03.addClickListener(event -> check03.setVisible(true));

//----------------------------------------------------------------------------------
		MenuBar menuBar01 = new MenuBar();
		MenuBar menuBar02 = new MenuBar();
		MenuBar menuBar03 = new MenuBar();

		MenuItem delete = menuBar01.addItem("Delete");
		MenuItem account = menuBar01.addItem("Move");

		SubMenu projectSubMenu = delete.getSubMenu();
		projectSubMenu.addItem("hallo");

		super.add(menuBar01);

//----------------------------------------------------------------------------------		

		HorizontalLayout columnA;
		HorizontalLayout columnB;
		HorizontalLayout columnC;

		HorizontalLayout columnAWrapper = new HorizontalLayout();
		columnAWrapper.addClassName("wrapper");
		columnA = new HorizontalLayout();
		columnA.addClassNames("column", "column-a");
		columnAWrapper.add(new Label("Independent"), columnA);

		HorizontalLayout columnBWrapper = new HorizontalLayout();
		columnBWrapper.addClassName("wrapper");
		columnB = new HorizontalLayout();
		columnB.addClassNames("column", "column-b");
		columnBWrapper.add(new Label("With help"), columnB);

		HorizontalLayout columnCWrapper = new HorizontalLayout();
		columnCWrapper.addClassName("wrapper");
		columnC = new HorizontalLayout();
		columnC.addClassNames("column", "column-c");
		columnCWrapper.add(new Label("Dependent"), columnC);

		super.add(columnAWrapper, columnBWrapper, columnCWrapper);

//--------------------------------------------------------------------------------------
		check01.addClickListener(event -> columnAWrapper.add(new Button(textFieldDep.getValue()), columnA));
		check01.addClickListener(event -> textFieldDep.clear());

		check02.addClickListener(event -> columnBWrapper.add(new Button(textFieldIndep.getValue()), columnB));
		check02.addClickListener(event -> textFieldIndep.clear());

		check03.addClickListener(event -> columnCWrapper.add(new Button(textFieldWhelp.getValue()), columnB));
		check03.addClickListener(event -> textFieldWhelp.clear());


//--------------------------------------------------------------------------------------		
		/**
		 * Now we connect the Logic of the Status with our Database.
		 */

		StatusModel status = new StatusModel("schuhe zubinden", "duschen", "medikamente einnehmen");

		DbService.init();
		DbService.em.getTransaction().begin();
		DbService.em.persist(status);
		DbService.em.getTransaction().commit();
	}

}