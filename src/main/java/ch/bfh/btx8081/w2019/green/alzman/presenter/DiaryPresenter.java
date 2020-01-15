package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import ch.bfh.btx8081.w2019.green.alzman.model.DiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryView;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryAddViewImpl;

/**
 * 
 * @author Mootaas
 * 
 * This is the presenter of the diary. All the logic of the diary is controlled by this class
 *
 */

public class DiaryPresenter implements DiaryView.DiaryViewListener {

	private DiaryView view;
	private List<DiaryModel> lstdiarys;

	public DiaryPresenter(DiaryView diary) {
		this.view = diary;
		view.addListener(this);
		getallDiarys();
	}

	@Override
	public void buttonClick(Button button) {
		String btnText = button.getText();
		switch (btnText) {
		case "Add new Diarymodel":
			openAddDiaryView();
			break;
		default:
			deleteEntry(button.getId());
			break;
		}
	}

	private void getallDiarys() {
		lstdiarys = DbService.getAllDiarys();
		for (DiaryModel model : lstdiarys) {
			view.addEntryToView(model);
		}
	}

	private void deleteEntry(Optional<String> id) {
		String tempId = id.get();
		int idtodelete = Integer.parseInt(tempId);
		for (DiaryModel model : lstdiarys) {
			if (Objects.equals(idtodelete, model.getId())) {
				DbService.remove(model);
			}
			view.clearEntries();
			getallDiarys();
		}
	}

	private void openAddDiaryView() {
		System.out.println("take me");
		UI.getCurrent().navigate(DiaryAddViewImpl.class);
	}
}
