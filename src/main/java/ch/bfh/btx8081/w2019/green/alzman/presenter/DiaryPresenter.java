package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddDiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.Diary;
import ch.bfh.btx8081.w2019.green.alzman.view.TemplateView;

public class DiaryPresenter extends TemplateView {

	private List<AddDiaryModel> diarys;
	private Diary view;

	public DiaryPresenter(Diary diary) {
		this.view = diary;

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

	public void deleteEntry(Optional<String> id) {

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
}
