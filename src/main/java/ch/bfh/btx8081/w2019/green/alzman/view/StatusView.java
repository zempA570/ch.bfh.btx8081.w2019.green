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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.StatusPresenter;

/**
 * The user management view will be used to add and remove users of the app
 * 
 * @author Emily Torresan
 */

@Route("statusview")
//@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
@CssImport(value = "./styles/statusStyle.css", include = "common-styles")

public class StatusView extends TemplateView {

	private StatusPresenter presenter;
	HorizontalLayout columnA;
	HorizontalLayout columnB;
	HorizontalLayout columnC;
	HorizontalLayout columnAWrapper;
	HorizontalLayout columnBWrapper;
	HorizontalLayout columnCWrapper;
	SubMenu deleteSubMenu01;
	SubMenu deleteSubMenu02;
	SubMenu deleteSubMenu03;
	SubMenu moveSubMenu01;
	SubMenu moveSubMenu02;
	SubMenu moveSubMenu03;
	TextField textFieldDep;
	TextField textFieldIndep;
	TextField textFieldWhelp;

	public StatusView() {

		super.setHeaderTitle("Status");
		setSizeFull();
		setAlignItems(Alignment.CENTER);

		// GUI Layout

//---------------------------------------------------------------------------------------------------------------		
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
		 *         See the Click Events section for more details.
		 */

		Icon plus01 = new Icon(VaadinIcon.PLUS);
		plus01.setSize("60px");
		plus01.setColor("lightgreen");

		Button plusButton = new Button("Click here to add a new Task ", plus01);

		textLayout04.add(plusButton);

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
//-----------------------------------------------------------------------------------------------------	

		FormLayout textLayout05 = new FormLayout();

		textLayout05.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		textFieldDep = new TextField();
		textFieldDep.addClassName("wrapperField");
		textFieldDep.setEnabled(false);
		textFieldDep.setVisible(false);

		textFieldIndep = new TextField();
		textFieldIndep.addClassName("wrapperField");
		textFieldIndep.setEnabled(false);
		textFieldIndep.setVisible(false);

		textFieldWhelp = new TextField();
		textFieldWhelp.addClassName("wrapperField");
		textFieldWhelp.setEnabled(false);
		textFieldWhelp.setVisible(false);

		textLayout05.add(textFieldDep, check01, textFieldIndep, check02, textFieldWhelp, check03);

		super.add(textLayout05);
//----------------------------------------------------------------------------------		

		plusButton.addClickListener(event -> textFieldDep.setVisible(true));
		plusButton.addClickListener(event -> textFieldDep.setEnabled(true));
		plusButton.addClickListener(event -> check01.setVisible(true));

		plusButton.addClickListener(event -> textFieldIndep.setVisible(true));
		plusButton.addClickListener(event -> textFieldIndep.setEnabled(true));
		plusButton.addClickListener(event -> check02.setVisible(true));

		plusButton.addClickListener(event -> textFieldWhelp.setVisible(true));
		plusButton.addClickListener(event -> textFieldWhelp.setEnabled(true));
		plusButton.addClickListener(event -> check03.setVisible(true));

//----------------------------------------------------------------------------------
		MenuBar menuBar01 = new MenuBar();
		MenuItem delete01 = menuBar01.addItem("Delete");
		MenuItem move01 = menuBar01.addItem("Move down");
		deleteSubMenu01 = delete01.getSubMenu();
		moveSubMenu01 = move01.getSubMenu();

		MenuBar menuBar02 = new MenuBar();
		MenuItem delete02 = menuBar02.addItem("Delete");
		MenuItem move02 = menuBar02.addItem("move down");
		deleteSubMenu02 = delete01.getSubMenu();
		moveSubMenu02 = move02.getSubMenu();

		MenuBar menuBar03 = new MenuBar();
		MenuItem delete03 = menuBar03.addItem("Delete");
		MenuItem move03 = menuBar03.addItem("Move up");
		deleteSubMenu03 = delete03.getSubMenu();
		moveSubMenu03 = move03.getSubMenu();

//----------------------------------------------------------------------------------		

		columnAWrapper = new HorizontalLayout();
		columnAWrapper.addClassName("wrapper");
		columnA = new HorizontalLayout();
		columnA.addClassNames("column", "column-a");
		columnAWrapper.add(new Label("Independent"), columnA);
		columnAWrapper.add(menuBar01);

		columnBWrapper = new HorizontalLayout();
		columnBWrapper.addClassName("wrapper");
		columnB = new HorizontalLayout();
		columnB.addClassNames("column", "column-b");
		columnBWrapper.add(new Label("With help"), columnB);
		columnBWrapper.add(menuBar02);

		columnCWrapper = new HorizontalLayout();
		columnCWrapper.addClassName("wrapper");
		columnC = new HorizontalLayout();
		columnC.addClassNames("column", "column-c");
		columnCWrapper.add(new Label("Dependent"), columnC);
		columnCWrapper.add(menuBar03);

		super.add(columnAWrapper, columnBWrapper, columnCWrapper);

//----------------------------------------------------------------------------------------------------------------		
		presenter = new StatusPresenter(this);
		
//----------------------------------------------------------------------------------------------------------------
		check01.addClickListener(event -> presenter.addTaskToDB(textFieldDep.getValue(), 1));
		check02.addClickListener(event -> presenter.addTaskToDB(textFieldIndep.getValue(), 2));
		check03.addClickListener(event -> presenter.addTaskToDB(textFieldWhelp.getValue(), 3));

//------------------------------------------------------------------------------------------------------------------		
		
	}

	public void addToView(StatusModel model) {

		int nr = model.getLevel();
		switch (nr) {
		case 1:
			columnAWrapper.add(new Button(model.Gettask(), columnA));
			deleteSubMenu01.addItem(model.Gettask(), event ->  presenter.deleteStatusFromDB(model));
			moveSubMenu01.addItem(model.Gettask());
			textFieldDep.clear();
			break;

		case 2:
			columnBWrapper.add(new Button(model.Gettask(), columnB));
			deleteSubMenu02.addItem(model.Gettask(), event ->  presenter.deleteStatusFromDB(model));
			moveSubMenu02.addItem(model.Gettask());
			textFieldIndep.clear();
			break;

		case 3:
			columnCWrapper.add(new Button(model.Gettask(), columnC));
			deleteSubMenu03.addItem(model.Gettask(), event ->  presenter.deleteStatusFromDB(model));
			moveSubMenu03.addItem(model.Gettask());
			textFieldWhelp.clear();
			break;

		default:
			break;

		}
	}
	
}