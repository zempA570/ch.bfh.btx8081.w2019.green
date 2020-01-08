package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;

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
public class DiaryViewImpl extends TemplateView implements DiaryView {

	private List<DiaryViewListener> listeners = new ArrayList<DiaryViewListener>();
	private VerticalLayout vert;
	private VerticalLayout vert2;

	public DiaryViewImpl() {

		super.setHeaderTitle("Diary");

		// Add a new Diarymodel
		Button button = new Button("Add new Diarymodel", new Icon(VaadinIcon.PLUS));
		button.addClickListener(e -> {
			for (DiaryViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		// Adding components to content space

		vert = new VerticalLayout(button);
		vert2 = new VerticalLayout();
		super.addContent(vert);
		super.addContent(vert2);
		
		new DiaryPresenter(this);
	}

	public void addEntryToView(AddDiaryModel model) {

		TextArea textarea = new TextArea();
		textarea.setValue(model.getEntry());
		textarea.setLabel(model.getAuthor() + " " + model.getDate());

		Button button = new Button("Delete", new Icon(VaadinIcon.TRASH));
		button.setId(Integer.toString(model.getId()));
		button.addClickListener(e -> {
			for (DiaryViewListener listener : listeners)
				listener.buttonClick(e.getSource());
		});

		HorizontalLayout horizon = new HorizontalLayout();
		horizon.add(textarea, button);

		vert2.add(horizon);

	}

	public void clearEntries() {
		vert2.removeAll();
	}

	@Override
	public void addListener(DiaryViewListener listener) {
		listeners.add(listener);
	}

}
