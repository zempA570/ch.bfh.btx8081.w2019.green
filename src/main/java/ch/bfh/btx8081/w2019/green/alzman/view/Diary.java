package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
	private VerticalLayout vert;
	private VerticalLayout vert2;

	public Diary() {

		super.setHeaderTitle("Diary");

		// Add a new Diarymodel
		Button button = new Button("Add new Diarymodel", new Icon(VaadinIcon.PLUS));
		button.addClickListener(e -> UI.getCurrent().navigate(EntryRecordDiary.class));

		// Adding components to content space

		vert = new VerticalLayout(button);
		vert2 = new VerticalLayout(button);
		presenter = new DiaryPresenter(this);
		super.add(vert,vert2);

	}

	public void addEntryToView(AddDiaryModel model) {

		TextArea textarea = new TextArea();
		textarea.setValue(model.getEntry());
		textarea.setLabel(model.getAuthor() + "" + model.getDate());
		super.addContent(textarea);

		Button button = new Button("Delete", new Icon(VaadinIcon.TRASH));
		button.setId(Integer.toString(model.getId()));
		button.addClickListener(e -> presenter.deleteEntry(e.getSource().getId()));

		HorizontalLayout horizon = new HorizontalLayout();
		horizon.add(textarea, button);
		

		vert.add(vert2,horizon);

	}

	public void clearEntries() {

		vert.removeAll();
	}

}
