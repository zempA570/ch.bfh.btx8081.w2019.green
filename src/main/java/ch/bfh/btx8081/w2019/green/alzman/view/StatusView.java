package ch.bfh.btx8081.w2019.green.alzman.view;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("")
//@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
@CssImport(value = "./styles/statusStyle.css", include = "common-styles")

public class StatusView extends TemplateView{



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
		
		detailsLayout.add(infocomponent01, infocomponent02, infocomponent03);
		super.addContent(detailsLayout);
		
//---------------------------------------------------------------------------------
		FormLayout textLayout04 = new FormLayout();
		
		textLayout04.setResponsiveSteps(
		        new ResponsiveStep("20em", 1),
		        new ResponsiveStep("25em", 2),
		        new ResponsiveStep("30em", 3));
		
		Icon plus01 = new Icon(VaadinIcon.PLUS);
		plus01.setSize("30px");
		plus01.setColor("lightgreen");
		
		Icon plus02 = new Icon(VaadinIcon.PLUS);
		plus02.setSize("30px");
		plus02.setColor("lightgreen");
		
		Icon plus03 = new Icon(VaadinIcon.PLUS);
		plus03.setSize("30px");
		plus03.setColor("lightgreen");
		
		textLayout04.add(plus01, plus02, plus03 );
		
		super.add(textLayout04);

//---------------------------------------------------------------------------------
		
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
		
		textLayout05.setResponsiveSteps(
		        new ResponsiveStep("20em", 1),
		        new ResponsiveStep("25em", 2),
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
		
		
textLayout05.add( textFieldDep, check01, textFieldIndep, check02, textFieldWhelp, check03);
		
		super.add(textLayout05);
		
//----------------------------------------------------------------------------------		
		plus01.addClickListener( event -> textFieldDep.setVisible(true));	
		plus01.addClickListener( event -> textFieldDep.setEnabled(true));
		plus01.addClickListener( event -> check01.setVisible(true));
		
		plus02.addClickListener( event -> textFieldIndep.setVisible(true));	
		plus02.addClickListener( event -> textFieldIndep.setEnabled(true));
		plus02.addClickListener( event -> check02.setVisible(true));
		
		plus03.addClickListener( event -> textFieldWhelp.setVisible(true));	
		plus03.addClickListener( event -> textFieldWhelp.setEnabled(true));
		plus03.addClickListener( event -> check03.setVisible(true));
		
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
		check01.addClickListener( event -> columnAWrapper
				.add(new Button(textFieldDep.getValue()), columnA));
		check01.addClickListener( event -> textFieldDep.clear());
		
		check02.addClickListener( event -> columnBWrapper
				.add(new Button(textFieldIndep.getValue()), columnB));
		check02.addClickListener( event -> textFieldIndep.clear());
		
		check03.addClickListener( event -> columnCWrapper
				.add(new Button(textFieldWhelp.getValue()), columnB));
		check03.addClickListener( event -> textFieldWhelp.clear());
//--------------------------------------------------------------------------------------		
		
	}
	
}