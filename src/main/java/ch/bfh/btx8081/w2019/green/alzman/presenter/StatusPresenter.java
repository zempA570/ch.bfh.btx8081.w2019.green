package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.StatusView;

public class StatusPresenter {

	private StatusView view;
	private List<StatusModel> status;

	public StatusPresenter(StatusView view) {
		this.view = view;
		fillLayoutsfromUser();

	}
	private void fillLayoutsfromUser() {
		// DB stuff where we get all the users
				Query query = DbService.em.createNativeQuery("SELECT * FROM statusmodel", StatusModel.class);
				
				// get list of users out of the query
				status = query.getResultList();

				List<String> userStatus = new ArrayList<String>();
				// for every user in our list
				for (StatusModel status : status) {
					view.addToView(status);
				}
	}

	public void addTaskToDB(String str, int level) {
		StatusModel sm = new StatusModel(level, str);

		DbService.init();
		DbService.em.getTransaction().begin();
		DbService.em.persist(sm);
		DbService.em.getTransaction().commit();
	}

}
