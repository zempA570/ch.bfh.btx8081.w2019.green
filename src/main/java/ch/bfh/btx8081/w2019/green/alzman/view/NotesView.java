package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.ironlist.IronList;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("Notes")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class NotesView extends TemplateView {
	
	/* Pop-up dialog with a detailed view of the clicked diary entry */
	public Dialog dialog = new Dialog();
	
	private Button suggestions;
	private TextArea diaryText = new TextArea();
	
	
	private Button deletePic;
	public Button saveDiaryEntry;
	
	

	public NotesView() {

		// Change title in header
		super.setHeaderTitle("Important Notes");
		
		

		// Creating elements
		IronList<String> lis = new IronList<>();
		lis.setItems("Eintrag von Ey","","Lorem ipsum dolor sit amet, "
				+ "consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et"
				+ " dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
				+ "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus "
				+ "est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing "
				+ "elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,"
				+ " sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita "
				+ "kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
				"Eintrag von Xy"
				,"", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor "
						+ "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero "
						+ "eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no "
						+ "sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, "
						+ "consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et "
						+ "dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo "
						+ "duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
						+ "Lorem ipsum dolor sit amet.");
		

	

		Button btnAddUser = new Button("Add Entry");

		// Creating horizontal layout
		HorizontalLayout hLAddUser = new HorizontalLayout();

		// Adding two components to horizontal layout
		hLAddUser.add(btnAddUser);

		// Adding components to content space
		super.addContent(lis);
		super.addContent(hLAddUser);
		
		

	}

}
