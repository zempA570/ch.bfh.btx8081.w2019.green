package ch.bfh.btx8081.w2019.green.alzman.presenter;

import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.StatusView;

public class StatusPresenter {

	private StatusView view;

	public StatusPresenter(StatusView view) {
		this.view = view;

	}

	public void addTaskToDB(String str, int level) {
		StatusModel sm = new StatusModel(level, str);

		DbService.init();
		DbService.em.getTransaction().begin();
		DbService.em.persist(sm);
		DbService.em.getTransaction().commit();
	}

}
