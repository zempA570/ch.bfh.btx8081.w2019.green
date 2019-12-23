package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.model.AddDiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.DiaryPresenter;

/**
 * The user management view will be used to add and remove users of the app
 */
@Route("Diary")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class Diary extends TemplateView {

	private DiaryPresenter presenter;

	public Diary() {

		super.setHeaderTitle("Diary");

		// Creating a new Textarea
		TextArea textArea = new TextArea("");
		textArea.setPlaceholder("");

		// Add a new Diarymodel
		Button button = new Button("Add new Diarymodel", new Icon(VaadinIcon.PLUS));
		button.addClickListener(e -> UI.getCurrent().navigate(EntryRecordDiary.class));

		// Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout(textArea, button);

		// Adding components to content space
		super.addContent(verticalLayout);

		presenter = new DiaryPresenter(this);

	}

	public void addEntryToView(AddDiaryModel model) {

		TextArea textarea = new TextArea();
		textarea.setValue(model.getEntry());
		textarea.setLabel(model.getAuthor() + "" + model.getDate());
		super.addContent(textarea);
		;

	}

}
