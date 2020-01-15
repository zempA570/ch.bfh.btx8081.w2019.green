package ch.bfh.btx8081.w2019.green.alzman.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.green.alzman.presenter.DiaryAddPresenter;

/**
 * 
 * @author Mootaas
 *
 *         New Records shall be added to the database by clicking the add button
 *
 */

@Route("diaryadd")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DiaryAddViewImpl extends TemplateView implements DiaryAddView {

	private List<DiaryAddViewListener> lstListeners = new ArrayList<DiaryAddViewListener>();
	private TextArea txtaAuthor;
	private TextArea txtaEntry;
	private DatePicker dpDiary;
	private Button btnAddEntry;

	public DiaryAddViewImpl() {

		super.setHeaderTitle("Add new entry to diary");

		// Creating a new Datepicker.
		dpDiary = new DatePicker();
		dpDiary.setValue(LocalDate.now());

		// Creating a new Textarea
		txtaAuthor = new TextArea();
		txtaAuthor.setLabel("Author");

		// Creating a new Textarea
		txtaEntry = new TextArea();
		txtaEntry.setLabel("entry");

		// Creating a new Button
		btnAddEntry = new Button("Add new Record", new Icon(VaadinIcon.PLUS));
		btnAddEntry.addClickListener(e -> {
			for (DiaryAddViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});

		// Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.add(dpDiary, txtaAuthor, txtaEntry, btnAddEntry);

		// Adding components to content space
		super.addContent(verticalLayout);

		new DiaryAddPresenter(this);
	}

	@Override
	public String getEntry() {
		return txtaEntry.getValue();
	}

	@Override
	public LocalDate getDate() {
		return dpDiary.getValue();
	}

	@Override
	public String getAuthor() {
		return txtaAuthor.getValue();
	}

	@Override
	public void addListener(DiaryAddViewListener listener) {
		lstListeners.add(listener);
	}
}
