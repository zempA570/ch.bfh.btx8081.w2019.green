package ch.bfh.btx8081.w2019.green.alzman.view;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.green.alzman.model.DiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.DiaryPresenter;

/**
 * 
 * @author Mootaas
 * 
 *         The whole view of the diary will be created
 *
 */
@Route("diary")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DiaryViewImpl extends TemplateView implements DiaryView {

	private List<DiaryViewListener> lstListeners = new ArrayList<DiaryViewListener>();
	private VerticalLayout vlButton;
	private VerticalLayout vlDiaryEntries;

	public DiaryViewImpl() {
		super.setHeaderTitle("Diary");
		Button btnAddDiary = new Button("Add new Diarymodel", new Icon(VaadinIcon.PLUS));
		btnAddDiary.addClickListener(e -> {
			for (DiaryViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});

		vlButton = new VerticalLayout(btnAddDiary);
		vlDiaryEntries = new VerticalLayout();
		super.addContent(vlButton);
		super.addContent(vlDiaryEntries);
		new DiaryPresenter(this);
	}

	public void addEntryToView(DiaryModel model) {
		TextArea txtaEntry = new TextArea();
		txtaEntry.setValue(model.getEntry());
		txtaEntry.setLabel(model.getAuthor() + " " + model.getDate());
		Button btnDelete = new Button("Delete", new Icon(VaadinIcon.TRASH));
		btnDelete.setId(Integer.toString(model.getId()));
		btnDelete.addClickListener(e -> {
			for (DiaryViewListener listener : lstListeners)
				listener.buttonClick(e.getSource());
		});
		HorizontalLayout hlWrapper = new HorizontalLayout();
		hlWrapper.add(txtaEntry, btnDelete);
		vlDiaryEntries.add(hlWrapper);
	}

	public void clearEntries() {
		vlDiaryEntries.removeAll();
	}

	@Override
	public void addListener(DiaryViewListener listener) {
		lstListeners.add(listener);
	}

}
