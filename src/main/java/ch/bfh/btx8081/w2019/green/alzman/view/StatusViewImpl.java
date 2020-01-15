package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
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
 * The functionality of the Status View is implemented in this class. The user
 * receives important information about the application in the Components
 * details. The user can create a task in the text fields. The user can then add
 * this task to one of the three FormLayouts. The user can also remove the added
 * task afterwards.
 * 
 * The commented part could be further developed in a continuation of this
 * project. The idea is that the user can move his entry from one section to
 * another.
 * 
 * @author Emily Torresan
 */

@Route("statusview")
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

	// SubMenu sbmnuIndependentMove;
	// SubMenu sbmnuWithHelpMove;
	// SubMenu sbmnuDependentMove;

	TextField tfIndependent;

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

		/**
		 * A Layout from Vaadin, with which you can align the elements vertically.
		 */

		FormLayout frmlytDetailsLayout = new FormLayout();

		/**
		 * Details is a component of Vaadin with which you can expand a text to get more
		 * information.
		 * 
		 * The dtlsDetailsIndependend Details Component explains what is meant by
		 * "independent".
		 */

		Details dtlsDetailsIndependend = new Details("Independend",
				new Text("Here you can add activities and properties that "
						+ "your relative can practise independently and without " + "outside help."));

		/**
		 * The dtllDetailsWithHelp Details Component explains what is meant by
		 * "independent".
		 */

		Details dtllDetailsWithHelp = new Details("With Help", new Text(
				"Here you can add activities and properties that " + "your relative can perform with support."));

		/**
		 * The ddtlsDetailsDependent Details Component explains what is meant by
		 * "independent".
		 */

		Details dtlsDetailsDependent = new Details("Dependend",
				new Text("Here you can add activities and features that your" + " loved one can no longer perform "
						+ "independently and needs full help.."));

		/**
		 * The method setResponsiveSteps structures the Detail Layout
		 */

		frmlytDetailsLayout.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		frmlytDetailsLayout.add(dtlsDetailsIndependend, dtllDetailsWithHelp, dtlsDetailsDependent);

		super.addContent(frmlytDetailsLayout);

		/**
		 * Below the Details components a new layout for the buttons will be created.
		 * The form layout of Vaadin allows to display the different components in an
		 * orderly way.
		 */

		FormLayout frmlyttextLayout04 = new FormLayout();

		frmlyttextLayout04.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		/**
		 * @icnplus01 Is a Icon from Vaadin with the plus symbol. It will be added in
		 *            the btnPlusButton.
		 */

		Icon icnPlus01 = new Icon(VaadinIcon.PLUS);
		icnPlus01.setSize("60px");
		icnPlus01.setColor("lightgreen");

		/**
		 * @btnPlusButton If this button is clicked by the user, three text fields
		 *                become visible.
		 */

		Button btnPlusButton = new Button("Click here to add a new Task ", icnPlus01);

		frmlyttextLayout04.add(btnPlusButton);

		super.addContent(frmlyttextLayout04);

		/**
		 * Three Icons from Vaadin with the check symbol. Each text field receives the
		 * corresponding icon. They are added next to each text field
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
		
		
		/**
		 * @frmlyTextLayout05 is needet for the three textfield.
		 */
		
		FormLayout frmlytTextLayout05 = new FormLayout();

		frmlytTextLayout05.setResponsiveSteps(new ResponsiveStep("20em", 1), new ResponsiveStep("25em", 2),
				new ResponsiveStep("30em", 3));

		/**
		 * @tfIndependent is a text field where the user can enter a task that his
		 *                relative can do independently.
		 */

		tfIndependent = new TextField();
		tfIndependent.addClassName("wrapperField");
		tfIndependent.setEnabled(false);
		tfIndependent.setVisible(false);

		/**
		 * @tfWithHelp is a text field where the user can enter a task that his relative
		 *             can only do with help.
		 */

		tfWithHelp = new TextField();
		tfWithHelp.addClassName("wrapperField");
		tfWithHelp.setEnabled(false);
		tfWithHelp.setVisible(false);

		/**
		 * @tfDependent is a text field where the user can enter a task that his
		 *              relative can't do independently.
		 */

		tfDependent = new TextField();
		tfDependent.addClassName("wrapperField");
		tfDependent.setEnabled(false);
		tfDependent.setVisible(false);

		frmlytTextLayout05.add(tfIndependent, icnCheckIndependent, tfWithHelp, icnCheckWithHelp, tfDependent,
				icnCheckDependent);

		super.addContent(frmlytTextLayout05);
		
		
		/**
		 * When the user clicks this button, all three text fields become visible and
		 * enabled. In addition, the icons with the Check symbol become visible.
		 */
		
		btnPlusButton.addClickListener(event -> tfDependent.setVisible(true));
		btnPlusButton.addClickListener(event -> tfDependent.setEnabled(true));
		btnPlusButton.addClickListener(event -> icnCheckDependent.setVisible(true));

		btnPlusButton.addClickListener(event -> tfIndependent.setVisible(true));
		btnPlusButton.addClickListener(event -> tfIndependent.setEnabled(true));
		btnPlusButton.addClickListener(event -> icnCheckIndependent.setVisible(true));

		btnPlusButton.addClickListener(event -> tfWithHelp.setVisible(true));
		btnPlusButton.addClickListener(event -> tfWithHelp.setEnabled(true));
		btnPlusButton.addClickListener(event -> icnCheckWithHelp.setVisible(true));

		/**
		 * For all three horizontal layouts ("Independent", "With Help", "Dependent") a
		 * menu component with only one submenu "Delete" is created. When the user adds
		 * a new task to the three HorizontalLayouts, it is added to the submenu at the
		 * same time. With the help of the submenu "Delete" the user can select the
		 * entry he wants to delete.
		 */

		MenuBar mnubrIndependent = new MenuBar();
		MenuItem mnuitmIndepDelete = mnubrIndependent.addItem("Delete");
		sbmnuIndependentDelete = mnuitmIndepDelete.getSubMenu();
		
		// MenuItem mnuitmIndepMove = mnubrIndependent.addItem("Move down");
		// sbmnuIndependentMove = mnuitmIndepMove.getSubMenu();

		MenuBar mnubrWithHelp = new MenuBar();
		MenuItem mnuitmWhelpDelete = mnubrWithHelp.addItem("Delete");
		sbmnuWithHelpDelete = mnuitmWhelpDelete.getSubMenu();
		
		// MenuItem mnuitmWhelpMove = mnubrWithHelp.addItem("Move down");
		// sbmnuWithHelpMove = mnuitmWhelpMove.getSubMenu();

		MenuBar mnubrDependent = new MenuBar();
		MenuItem mnuitmDepDelete = mnubrDependent.addItem("Delete");
		sbmnuDependentDelete = mnuitmDepDelete.getSubMenu();
		
		// MenuItem mnuitmDepMove = mnubrDependent.addItem("Move up");
		// sbmnuDependentMove = mnuitmDepMove.getSubMenu();

		/**
		 * This layout represents the column for the tasks that a relative of the user
		 * can do independently.
		 */

		hlIndepWrapper = new HorizontalLayout();
		hlIndepWrapper.addClassName("wrapper");
		hlIndepContent = new HorizontalLayout();
		hlIndepContent.addClassNames("column", "column-a");
		hlIndepWrapper.add(new Label("Independent"), mnubrIndependent, hlIndepContent);
		super.addContent(hlIndepWrapper);

		/**
		 * This layout represents the column for the tasks that a relative of the user
		 * can only do with help.
		 */

		hlWhelpWrapper = new HorizontalLayout();
		hlWhelpWrapper.addClassName("wrapper");
		hlWhelpContent = new HorizontalLayout();
		hlWhelpContent.addClassNames("column", "column-b");
		hlWhelpWrapper.add(new Label("With help"), mnubrWithHelp, hlWhelpContent);
		super.addContent(hlWhelpWrapper);

		/**
		 * This layout represents the column for the tasks that a relative of the user
		 * can't do independently.
		 */

		hlDepWrapper = new HorizontalLayout();
		hlDepWrapper.addClassName("wrapper");
		hlDepContent = new HorizontalLayout();
		hlDepContent.addClassNames("column", "column-c");
		hlDepWrapper.add(new Label("Dependent"), mnubrDependent, hlDepContent);
		super.addContent(hlDepWrapper);
		

		/**
		 * If the user has entered a text in one of the three text fields and clicks on
		 * the check icon next to the text field, the entry is added to the
		 * corresponding category.
		 */
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

		
		// !!! Bitte hier den Kommentar prüfen !!! Stimmt das so???
		/**
		 * The logic of this class is passed to the presenter class.
		 */
		new StatusPresenter(this);

	}

	/**
	 * When the user writes a task in the first text field and clicks on the check
	 * icon, a new button is created with the text from the text field and added to
	 * the corresponding HorizontalLayout and its menu.
	 */

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

	/**
	 * @return the Value from the tfIndependent textField
	 */

	@Override
	public String getIndepTfValue() {
		return tfIndependent.getValue();
	}

	/**
	 * @return the Value from the tfWithHelp textField
	 */

	@Override
	public String getWhelpTfValue() {
		return tfWithHelp.getValue();
	}

	/**
	 * @return the Value from the tfDependent textField
	 */

	@Override
	public String getDepTfValue() {
		return tfDependent.getValue();
	}

	/**
	 * If the user has added a task to the appropriate category ("Independent",
	 * "With help", " Dependent") via the corresponding text field, the text of the
	 * text field is deleted again.
	 */
	
	@Override
	public void clearTextfields() {
		tfIndependent.clear();
		tfWithHelp.clear();
		tfDependent.clear();
	}

	
	/**
	 * This method removes all user entries. These are added later, when the web
	 * page is loaded from the DB.
	 */

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