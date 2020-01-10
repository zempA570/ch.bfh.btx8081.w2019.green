package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
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

import ch.bfh.btx8081.w2019.green.alzman.model.StatusLevel;
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

public class StatusViewImpl extends TemplateView implements StatusView {

	private List<StatusListener> listeners = new ArrayList<StatusListener>();

	HorizontalLayout hlIndepContent;
	HorizontalLayout hlDepContent;
	HorizontalLayout hlWhelpContent;

	HorizontalLayout hlIndepWrapper;
	HorizontalLayout hlDepWrapper;
	HorizontalLayout hlWhelpWrapper;

	SubMenu sbmnuIndepDelete;
	SubMenu sbmnuDepDelete;
	SubMenu sbmnuWhelpDelete;

	SubMenu sbmnuIndepMove;
	SubMenu sbmnuWhelpMove;
	SubMenu sbmnuDepMove;

	TextField tfDep;
	TextField tfIndep;
	TextField tfWhelp;

	public StatusViewImpl() {

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

		super.addContent(textLayout04);

//---------------------------------------------------------------------------------
		/**
		 * In this form layout, three icons with a check symbol are added. The size of
		 * these icons is determined, as is the color. At the beginning these icons are
		 * not visible, because the user must first unlock the text field with the plus
		 * icon and enter a text.
		 * 
		 */
		Icon icnCheckIndep = new Icon(VaadinIcon.CHECK_CIRCLE);
		icnCheckIndep.setSize("25px");
		icnCheckIndep.setColor("blue");
		icnCheckIndep.setVisible(false);

		Icon icnCheckWhelp = new Icon(VaadinIcon.CHECK_CIRCLE);
		icnCheckWhelp.setSize("25px");
		icnCheckWhelp.setColor("blue");
		icnCheckWhelp.setVisible(false);

		Icon icnCheckDep = new Icon(VaadinIcon.CHECK_CIRCLE);
		icnCheckDep.setSize("25px");
		icnCheckDep.setColor("blue");
		icnCheckDep.setVisible(false);
//-----------------------------------------------------------------------------------------------------	

		FormLayout textLayout05 = new FormLayout();

		textLayout05.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		tfIndep = new TextField();
		tfIndep.addClassName("wrapperField");
		tfIndep.setEnabled(false);
		tfIndep.setVisible(false);

		tfWhelp = new TextField();
		tfWhelp.addClassName("wrapperField");
		tfWhelp.setEnabled(false);
		tfWhelp.setVisible(false);

		tfDep = new TextField();
		tfDep.addClassName("wrapperField");
		tfDep.setEnabled(false);
		tfDep.setVisible(false);

		textLayout05.add(tfIndep, icnCheckIndep, tfWhelp, icnCheckWhelp, tfDep, icnCheckDep);

		super.addContent(textLayout05);
//----------------------------------------------------------------------------------		

		plusButton.addClickListener(event -> tfDep.setVisible(true));
		plusButton.addClickListener(event -> tfDep.setEnabled(true));
		plusButton.addClickListener(event -> icnCheckDep.setVisible(true));

		plusButton.addClickListener(event -> tfIndep.setVisible(true));
		plusButton.addClickListener(event -> tfIndep.setEnabled(true));
		plusButton.addClickListener(event -> icnCheckIndep.setVisible(true));

		plusButton.addClickListener(event -> tfWhelp.setVisible(true));
		plusButton.addClickListener(event -> tfWhelp.setEnabled(true));
		plusButton.addClickListener(event -> icnCheckWhelp.setVisible(true));

//----------------------------------------------------------------------------------
		MenuBar mnubrIndep = new MenuBar();
		MenuItem mnuitmIndepDelete = mnubrIndep.addItem("Delete");
		MenuItem mnuitmIndepMove = mnubrIndep.addItem("Move down");
		sbmnuIndepDelete = mnuitmIndepDelete.getSubMenu();
		sbmnuIndepMove = mnuitmIndepMove.getSubMenu();
		
		MenuBar mnubrWhelp = new MenuBar();
		MenuItem mnuitmWhelpDelete = mnubrWhelp.addItem("Delete");
		MenuItem mnuitmWhelpMove = mnubrWhelp.addItem("Move down");
		sbmnuWhelpDelete = mnuitmWhelpDelete.getSubMenu();
		sbmnuWhelpMove = mnuitmWhelpMove.getSubMenu();

		MenuBar mnubrDep = new MenuBar();
		MenuItem mnuitmDepDelete = mnubrDep.addItem("Delete");
		MenuItem mnuitmDepMove = mnubrDep.addItem("Move up");
		sbmnuDepDelete = mnuitmDepDelete.getSubMenu();
		sbmnuDepMove = mnuitmDepMove.getSubMenu();

//----------------------------------------------------------------------------------		

		hlIndepWrapper = new HorizontalLayout();
		hlIndepWrapper.addClassName("wrapper");
		hlIndepContent = new HorizontalLayout();
		hlIndepContent.addClassNames("column", "column-a");
		hlIndepWrapper.add(new Label("Independent"), mnubrIndep, hlIndepContent);

		hlWhelpWrapper = new HorizontalLayout();
		hlWhelpWrapper.addClassName("wrapper");
		hlWhelpContent = new HorizontalLayout();
		hlWhelpContent.addClassNames("column", "column-b");
		hlWhelpWrapper.add(new Label("With help"), mnubrWhelp, hlWhelpContent);

		hlDepWrapper = new HorizontalLayout();
		hlDepWrapper.addClassName("wrapper");
		hlDepContent = new HorizontalLayout();
		hlDepContent.addClassNames("column", "column-c");
		hlDepWrapper.add(new Label("Dependent"), mnubrDep, hlDepContent);

		super.addContent(hlIndepWrapper);
		super.addContent(hlWhelpWrapper);
		super.addContent(hlDepWrapper);

//----------------------------------------------------------------------------------------------------------------
		
		icnCheckIndep.addClickListener(event -> {
			for (StatusListener listener : listeners)
				listener.iconClick();
		});
		icnCheckWhelp.addClickListener(event -> {
			for (StatusListener listener : listeners)
				listener.iconClick();
		});
		icnCheckDep.addClickListener(event -> {
			for (StatusListener listener : listeners)
				listener.iconClick();
		});

//------------------------------------------------------------------------------------------------------------------		

		new StatusPresenter(this);
		
	}

	public void addToView(StatusModel model) {

		StatusLevel targetLevel = StatusLevel.valueOf(model.getLevel());
		
		Button btnNew = new Button(model.Gettask());
		btnNew.setId(Integer.toString(model.getId()));
		
		switch (targetLevel) {
		case INDEPENDENT:
			hlIndepContent.add(btnNew);
			sbmnuIndepDelete.addItem(model.Gettask(), event -> {
				for (StatusListener listener : listeners)
					listener.buttonClick(btnNew);
			});
//			sbmnuIndepMove.addItem(model.Gettask());
			break;

		case DEPENDENT:
			hlDepContent.add(new Button(model.Gettask()));
			sbmnuDepDelete.addItem(model.Gettask(), event -> {
				for (StatusListener listener : listeners)
					listener.buttonClick(btnNew);
			});
//			sbmnuWhelpMove.addItem(model.Gettask());
			break;

		case WITHHELP:
			hlWhelpContent.add(new Button(model.Gettask()));
			sbmnuWhelpDelete.addItem(model.Gettask(), event -> {
				for (StatusListener listener : listeners)
					listener.buttonClick(btnNew);
			});
//			sbmnuDepMove.addItem(model.Gettask());
			break;

		default:
			break;

		}
		
	}

	@Override
	public void addListener(StatusListener listener) {
		listeners.add(listener);
	}

	@Override
	public String getIndepTfValue() {
		return tfIndep.getValue();
	}

	@Override
	public String getWhelpTfValue() {
		return tfWhelp.getValue();
	}

	@Override
	public String getDepTfValue() {
		return tfDep.getValue();
	}

	@Override
	public void clearTextfields() {
		tfIndep.clear();
		tfWhelp.clear();
		tfDep.clear();
	}

	@Override
	public void clearContent() {
		hlIndepContent.removeAll();
		hlWhelpContent.removeAll();
		hlDepContent.removeAll();
		
		sbmnuDepDelete.removeAll();
		sbmnuIndepDelete.removeAll();
		sbmnuWhelpDelete.removeAll();
		
		sbmnuDepMove.removeAll();
		sbmnuIndepMove.removeAll();
		sbmnuWhelpMove.removeAll();
	}

}