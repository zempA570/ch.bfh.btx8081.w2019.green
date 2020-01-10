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

import ch.bfh.btx8081.w2019.green.alzman.model.DiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.presenter.DiaryPresenter;


/**
 * The user management view will be used to add and remove users of the app
 */
@Route("Diary")
@CssImport(value = "./styles/shared-styles.css", include = "common-styles")
public class DiaryViewImpl extends TemplateView implements DiaryView {

	private List<DiaryViewListener> lstlisteners = new ArrayList<DiaryViewListener>();
	private VerticalLayout vl1;
	private VerticalLayout vl2;

	public DiaryViewImpl() {

		super.setHeaderTitle("Diary");

		// Add a new Diarymodel
		Button btnAddDiary = new Button("Add new Diarymodel", new Icon(VaadinIcon.PLUS));
		btnAddDiary.addClickListener(e -> {
			for (DiaryViewListener listener : lstlisteners)
				listener.buttonClick(e.getSource());
		});

		// Adding components to content space

		vl1 = new VerticalLayout(btnAddDiary);
		vl2 = new VerticalLayout();
		super.addContent(vl1);
		super.addContent(vl2);
		
		new DiaryPresenter(this);
	}

	public void addEntryToView(DiaryModel model) {

		TextArea txta1 = new TextArea();
		txta1.setValue(model.getEntry());
		txta1.setLabel(model.getAuthor() + " " + model.getDate());

		Button btndelete = new Button("Delete", new Icon(VaadinIcon.TRASH));
		btndelete.setId(Integer.toString(model.getId()));
		btndelete.addClickListener(e -> {
			for (DiaryViewListener listener : lstlisteners)
				listener.buttonClick(e.getSource());
		});

		HorizontalLayout hl = new HorizontalLayout();
		hl.add(txta1, btndelete);

		vl2.add(hl);

	}

	public void clearEntries() {
		vl2.removeAll();
	}

	@Override
	public void addListener(DiaryViewListener listener) {
		lstlisteners.add(listener);
	}

}
