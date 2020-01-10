package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import com.vaadin.flow.component.button.Button;
import ch.bfh.btx8081.w2019.green.alzman.model.StatusLevel;
import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.StatusView;

public class StatusPresenter implements StatusView.StatusListener {

	private StatusView view;
	private List<StatusModel> listAllStatus;

	public StatusPresenter(StatusView view) {
		this.view = view;
		view.addListener(this);

		fillGuiWithContent();

	}

	private void fillGuiWithContent() {

		// get list of users out of the query
		listAllStatus = DbService.getAllStatus();

		// for every user in our list
		for (StatusModel status : listAllStatus) {
			view.addToView(status);
		}
	}

	private void addTaskToDB(String str, int level) {

		StatusModel statusToSave = new StatusModel(level, str);

		DbService.persist(statusToSave);
	}

	private void deleteStatusFromDB(int idToDelete) {

		StatusModel statusToDelete = null;

		for (StatusModel status : listAllStatus) {
			if (Objects.equals(status.getId(), idToDelete)) {
				statusToDelete = status;
			}
		}

		DbService.remove(statusToDelete);

	}

	private void reloadContent() {
		view.clearContent();
		fillGuiWithContent();
	}

	@Override
	public void buttonClick(Button button) {

		// TODO move functionality would be differentiated here

		deleteStatusFromDB(Integer.parseInt(button.getId().get()));
		reloadContent();

	}

	@Override
	public void iconClick() {

		String tfIndep = view.getIndepTfValue().trim();
		String tfWhelp = view.getWhelpTfValue().trim();
		String tfDep = view.getDepTfValue().trim();

		if (!tfIndep.isEmpty()) {
			addTaskToDB(tfIndep, StatusLevel.INDEPENDENT.getLevel());
		}
		if (!tfWhelp.isEmpty()) {
			addTaskToDB(tfWhelp, StatusLevel.WITHHELP.getLevel());
		}
		if (!tfDep.isEmpty()) {
			addTaskToDB(tfDep, StatusLevel.DEPENDENT.getLevel());
		}

		view.clearTextfields();
		view.clearContent();
		fillGuiWithContent();

	}

}
