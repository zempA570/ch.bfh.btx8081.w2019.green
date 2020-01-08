package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Query;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.AddDiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryView;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryAddViewImpl;

public class DiaryPresenter implements DiaryView.DiaryViewListener {

	private DiaryView view;
	private List<AddDiaryModel> diarys;

	public DiaryPresenter(DiaryView diary) {
		this.view = diary;
		view.addListener(this);

		getallDiarys();
	}

	private void getallDiarys() {

		Query query = DbService.em.createNativeQuery("SELECT * FROM adddiarymodel", AddDiaryModel.class);

		// get list of users out of the query
		diarys = query.getResultList();

		for (AddDiaryModel model : diarys) {
			view.addEntryToView(model);

		}

	}

	private void deleteEntry(Optional<String> id) {

		String tempId = id.get();

		int idtodelete = Integer.parseInt(tempId);

		for (AddDiaryModel model : diarys) {

			if (Objects.equals(idtodelete, model.getId())) {

				DbService.em.getTransaction().begin();
				DbService.em.remove(model);
				DbService.em.getTransaction().commit();
			}

			view.clearEntries();
			getallDiarys();

		}

	}

	private void openAddDiaryView() {
		System.out.println("take me");
		UI.getCurrent().navigate(DiaryAddViewImpl.class);
	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add new Diarymodel":
			openAddDiaryView();
			break;
		default:
			deleteEntry(button.getId());
			break;
		}

	}
}
