package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import com.vaadin.flow.component.button.Button;
import ch.bfh.btx8081.w2019.green.alzman.model.StatusLevel;
import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.StatusView;

/**
 * @author Emily
 * 
 *         This class represents the presenter of the status function.
 *
 */

public class StatusPresenter implements StatusView.StatusListener {

	private StatusView view;
	private List<StatusModel> lstAllStatus;

	/**
	 * When the user accesses the web page, his inputs are loaded from the DB.
	 * 
	 * @param view
	 */
	public StatusPresenter(StatusView view) {
		this.view = view;
		view.addListener(this);

		fillGuiWithContent();
	}

	private void fillGuiWithContent() {

		// Get list of users out of the query
		lstAllStatus = DbService.getAllStatus();

		// for every user in our list
		for (StatusModel status : lstAllStatus) {
			view.addToView(status);
		}
	}

	/**
	 * This method is used to store the entries of the user in the DB.
	 */
	private void addTaskToDB(String str, int level) {
		StatusModel statusToSave = new StatusModel(level, str);

		DbService.persist(statusToSave);
	}

	/**
	 * @param idToDelete Using the identification number of the entry which the user
	 *                   wants to delete, the entry can also be removed in the DB.
	 */
	private void deleteStatusFromDB(int idToDelete) {
		StatusModel statusToDelete = null;

		for (StatusModel status : lstAllStatus) {
			if (Objects.equals(status.getId(), idToDelete)) {
				statusToDelete = status;
			}
		}

		DbService.remove(statusToDelete);
	}

	/**
	 * When the user deletes an entry on the web page, the web page is updated.
	 */
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

		/**
		 * The three different categories ("Independent", "With help", "Dependent") are
		 * solved in the DB with levels (1 to 3).
		 */

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
