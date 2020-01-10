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
 * The user management view will be used to add and remove users of the app
 */

@Route("EntryRecordDiary")

@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DiaryAddViewImpl extends TemplateView implements DiaryAddView {

	private List<DiaryAddViewListener> lstlisteners = new ArrayList<DiaryAddViewListener>();
	private TextArea txtauthor;
	private TextArea txtaentry;
	private DatePicker dpdiary;
	private Button btnnewRecord;

	public DiaryAddViewImpl() {

		super.setHeaderTitle("Entry Record Diarymodel");

		// Creating a new Datepicker.
		dpdiary = new DatePicker();
		dpdiary.setValue(LocalDate.now());

		// Creating a new Textarea
		txtauthor = new TextArea();
		txtauthor.setLabel("Author");

		// Creating a new Textarea

		txtaentry = new TextArea();
		txtaentry.setLabel("Entry");

		// Creating a new Button
		btnnewRecord = new Button("Add new Record", new Icon(VaadinIcon.PLUS));
		btnnewRecord.addClickListener(e -> {
			for (DiaryAddViewListener listener : lstlisteners)
				listener.buttonClick(e.getSource());
		});

		// Creating a new Vertical Layout
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.add(dpdiary, txtauthor, txtaentry, btnnewRecord);

		// Adding components to content space
		super.addContent(verticalLayout);

		new DiaryAddPresenter(this);
	}

	@Override
	public String getEntry() {
		return txtaentry.getValue();
	}

	@Override
	public LocalDate getDate() {
		return dpdiary.getValue();
	}

	@Override
	public String getAuthor() {
		return txtauthor.getValue();
	}

	@Override
	public void addListener(DiaryAddViewListener listener) {
		lstlisteners.add(listener);
	}
}
