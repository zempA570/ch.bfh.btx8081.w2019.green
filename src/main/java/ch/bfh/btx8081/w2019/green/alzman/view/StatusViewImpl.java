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
	HorizontalLayout hlWhelpContent;

	HorizontalLayout hlDepContent;
	HorizontalLayout hlIndepWrapper;
	HorizontalLayout hlWhelpWrapper;

	HorizontalLayout hlDepWrapper;
	// SubMenu sbmnuIndependentMove;
	// SubMenu sbmnuWithHelpMove;
	// SubMenu sbmnuDependentMove;
	
	// SubMenu sbmnuIndependentMove;
	// SubMenu sbmnuWithHelpMove;
	// SubMenu sbmnuDependentMove;
	
	TextField tfIndependent;

	// SubMenu sbmnuIndependentMove;
	// SubMenu sbmnuWithHelpMove;
	// SubMenu sbmnuDependentMove;
	
	TextField tfWithHelp;

	TextField tfDependent;

	SubMenu sbmnuIndependentDelete;
	SubMenu sbmnuWithHelpDelete;

	SubMenu sbmnuDependentDelete;
	

	// SubMenu sbmnuIndependentMove;
	// SubMenu sbmnuWithHelpMove;
	// SubMenu sbmnuDependentMove;

	public StatusViewImpl() {

		super.setHeaderTitle("Status");
		setSizeFull();
		setAlignItems(Alignment.CENTER);

		// GUI Layout

//---------------------------------------------------------------------------------------------------------------		
		/**
		 * A Layout from Vaadin, with which you can align the elements vertically.
		 */

		FormLayout frmlytDetailsLayout = new FormLayout();
		/**
		 * Details is a component of Vaadin with which you can expand a text to get more
		 * information. infocomponent01 explains what is meant by "independent".
		 */
		Details dtlsDetailsIndependend = new Details("Independend", new Text("Here you can add activities and properties that "
				+ "your relative can practise independently and without " + "outside help."));

		/**
		 * infocomponent02 explains what is meant by "with help".
		 */

		Details dtllDetailsWithHelp = new Details("With Help", new Text(
				"Here you can add activities and properties that " + "your relative can perform with support."));

		/**
		 * infocomponent03 explains what is meant by "dependent".
		 */

		Details dtlsDetailsDependent = new Details("Dependend", new Text("Here you can add activities and features that your"
				+ " loved one can no longer perform " + "independently and needs full help.."));

		/**
		 * With this layout feature the Details components are displayed in a structured
		 * way.
		 */
		frmlytDetailsLayout.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		frmlytDetailsLayout.add(dtlsDetailsIndependend, dtllDetailsWithHelp, dtlsDetailsDependent);

		super.addContent(frmlytDetailsLayout);

//---------------------------------------------------------------------------------
		/**
		 * Below the Details components a new layout for the buttons will be created.
		 * The form layout of Vaadin allows to display the different components in an
		 * orderly way.
		 */

		FormLayout frmlyttextLayout04 = new FormLayout();

		frmlyttextLayout04.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
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

		Icon icnPlus01 = new Icon(VaadinIcon.PLUS);
		icnPlus01.setSize("60px");
		icnPlus01.setColor("lightgreen");

		Button btnPlusButton = new Button("Click here to add a new Task ", icnPlus01);

		frmlyttextLayout04.add(btnPlusButton);

		super.addContent(frmlyttextLayout04);

//---------------------------------------------------------------------------------
		/**
		 * In this form layout, three icons with a check symbol are added. The size of
		 * these icons is determined, as is the color. At the beginning these icons are
		 * not visible, because the user must first unlock the text field with the plus
		 * icon and enter a text.
		 * 
		 */
		Icon icnCheckIndependent = new Icon(VaadinIcon.CHECK_CIRCLE);
		icnCheckIndependent.setSize("25px");
		icnCheckIndependent.setColor("blue");
		icnCheckIndependent.setVisible(false);

		Icon icnCheckWithHelp = new Icon(VaadinIcon.CHECK_CIRCLE);
		icnCheckWithHelp.setSize("25px");
		icnCheckWithHelp.setColor("blue");
		icnCheckWithHelp.setVisible(false);

		Icon icnCheckDependent = new Icon(VaadinIcon.CHECK_CIRCLE);
		icnCheckDependent.setSize("25px");
		icnCheckDependent.setColor("blue");
		icnCheckDependent.setVisible(false);
//-----------------------------------------------------------------------------------------------------	

		FormLayout frmlytTextLayout05 = new FormLayout();

		frmlytTextLayout05.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		tfIndependent = new TextField();
		tfIndependent.addClassName("wrapperField");
		tfIndependent.setEnabled(false);
		tfIndependent.setVisible(false);

		tfWithHelp = new TextField();
		tfWithHelp.addClassName("wrapperField");
		tfWithHelp.setEnabled(false);
		tfWithHelp.setVisible(false);

		tfDependent = new TextField();
		tfDependent.addClassName("wrapperField");
		tfDependent.setEnabled(false);
		tfDependent.setVisible(false);

		frmlytTextLayout05.add(tfIndependent, icnCheckIndependent, tfWithHelp, icnCheckWithHelp, tfDependent, icnCheckDependent);

		super.addContent(frmlytTextLayout05);
//----------------------------------------------------------------------------------		

		btnPlusButton.addClickListener(event -> tfDependent.setVisible(true));
		btnPlusButton.addClickListener(event -> tfDependent.setEnabled(true));
		btnPlusButton.addClickListener(event -> icnCheckDependent.setVisible(true));

		btnPlusButton.addClickListener(event -> tfIndependent.setVisible(true));
		btnPlusButton.addClickListener(event -> tfIndependent.setEnabled(true));
		btnPlusButton.addClickListener(event -> icnCheckIndependent.setVisible(true));

		btnPlusButton.addClickListener(event -> tfWithHelp.setVisible(true));
		btnPlusButton.addClickListener(event -> tfWithHelp.setEnabled(true));
		btnPlusButton.addClickListener(event -> icnCheckWithHelp.setVisible(true));

//----------------------------------------------------------------------------------
		MenuBar mnubrIndependent = new MenuBar();
		MenuItem mnuitmIndepDelete = mnubrIndependent.addItem("Delete");
		MenuItem mnuitmIndepMove = mnubrIndependent.addItem("Move down");
		sbmnuIndependentDelete = mnuitmIndepDelete.getSubMenu();
		// sbmnuIndependentMove = mnuitmIndepMove.getSubMenu();
		
		MenuBar mnubrWithHelp = new MenuBar();
		MenuItem mnuitmWhelpDelete = mnubrWithHelp.addItem("Delete");
		MenuItem mnuitmWhelpMove = mnubrWithHelp.addItem("Move down");
		sbmnuWithHelpDelete = mnuitmWhelpDelete.getSubMenu();
		// sbmnuWithHelpMove = mnuitmWhelpMove.getSubMenu();

		MenuBar mnubrDependent = new MenuBar();
		MenuItem mnuitmDepDelete = mnubrDependent.addItem("Delete");
		MenuItem mnuitmDepMove = mnubrDependent.addItem("Move up");
		sbmnuDependentDelete = mnuitmDepDelete.getSubMenu();
		// sbmnuDependentMove = mnuitmDepMove.getSubMenu();

//----------------------------------------------------------------------------------		

		hlIndepWrapper = new HorizontalLayout();
		hlIndepWrapper.addClassName("wrapper");
		hlIndepContent = new HorizontalLayout();
		hlIndepContent.addClassNames("column", "column-a");
		hlIndepWrapper.add(new Label("Independent"), mnubrIndependent, hlIndepContent);

		hlWhelpWrapper = new HorizontalLayout();
		hlWhelpWrapper.addClassName("wrapper");
		hlWhelpContent = new HorizontalLayout();
		hlWhelpContent.addClassNames("column", "column-b");
		hlWhelpWrapper.add(new Label("With help"), mnubrWithHelp, hlWhelpContent);

		hlDepWrapper = new HorizontalLayout();
		hlDepWrapper.addClassName("wrapper");
		hlDepContent = new HorizontalLayout();
		hlDepContent.addClassNames("column", "column-c");
		hlDepWrapper.add(new Label("Dependent"), mnubrDependent, hlDepContent);

		super.addContent(hlIndepWrapper);
		super.addContent(hlWhelpWrapper);
		super.addContent(hlDepWrapper);

//----------------------------------------------------------------------------------------------------------------
		
		icnCheckIndependent.addClickListener(event -> {
			for (StatusListener listener : listeners)
				listener.iconClick();
		});
		icnCheckWithHelp.addClickListener(event -> {
			for (StatusListener listener : listeners)
				listener.iconClick();
		});
		icnCheckDependent.addClickListener(event -> {
			for (StatusListener listener : listeners)
				listener.iconClick();
		});

//------------------------------------------------------------------------------------------------------------------		

		new StatusPresenter(this);
		
	}

	public void addToView(StatusModel model) {

		StatusLevel targetLevel = StatusLevel.valueOf(model.getLevel());
		
		Button btnNew = new Button(model.getTask());
		btnNew.setId(Integer.toString(model.getId()));
		
		switch (targetLevel) {
		case INDEPENDENT:
			hlIndepContent.add(btnNew);
			sbmnuIndependentDelete.addItem(model.getTask(), event -> {
				for (StatusListener listener : listeners)
					listener.buttonClick(btnNew);
			});
//			sbmnuIndepMove.addItem(model.Gettask());
			break;

		case DEPENDENT:
			hlDepContent.add(new Button(model.getTask()));
			sbmnuDependentDelete.addItem(model.getTask(), event -> {
				for (StatusListener listener : listeners)
					listener.buttonClick(btnNew);
			});
//			sbmnuWhelpMove.addItem(model.Gettask());
			break;

		case WITHHELP:
			hlWhelpContent.add(new Button(model.getTask()));
			sbmnuWithHelpDelete.addItem(model.getTask(), event -> {
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
		return tfIndependent.getValue();
	}

	@Override
	public String getWhelpTfValue() {
		return tfWithHelp.getValue();
	}

	@Override
	public String getDepTfValue() {
		return tfDependent.getValue();
	}

	@Override
	public void clearTextfields() {
		tfIndependent.clear();
		tfWithHelp.clear();
		tfDependent.clear();
	}

	@Override
	public void clearContent() {
		hlIndepContent.removeAll();
		hlWhelpContent.removeAll();
		hlDepContent.removeAll();
		
		sbmnuDependentDelete.removeAll();
		sbmnuIndependentDelete.removeAll();
		sbmnuWithHelpDelete.removeAll();
		
		// sbmnuDependentMove.removeAll();
		// sbmnuIndependentMove.removeAll();
		// sbmnuWithHelpMove.removeAll();
	}

}