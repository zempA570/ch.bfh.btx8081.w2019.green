package ch.bfh.btx8081.w2019.green.alzman.presenter;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.Icon;

import ch.bfh.btx8081.w2019.green.alzman.view.CalendarViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.DashboardView;
import ch.bfh.btx8081.w2019.green.alzman.view.DiaryViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.InfoboxViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.NotesViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.StatusViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.ToDoListViewImpl;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementViewImpl;

public class DashboardPresenter implements DashboardView.DashboardViewListener {

	private DashboardView view;

	public DashboardPresenter(DashboardView dashboardView) {
		view = dashboardView;
		view.addListener(this);
	}

	@Override
	public void iconClick(Icon icon) {

		String idIcon = icon.getId().get();

		switch (idIcon) {
		case "User":
			UI.getCurrent().navigate(UserManagementViewImpl.class);
			break;
		case "Calendar":
			UI.getCurrent().navigate(CalendarViewImpl.class);
			break;
		case "Status":
			UI.getCurrent().navigate(StatusViewImpl.class);
			break;
		case "Notes":
			UI.getCurrent().navigate(NotesViewImpl.class);
			break;
		case "Diary":
			UI.getCurrent().navigate(DiaryViewImpl.class);
			break;
		case "Todo":
			UI.getCurrent().navigate(ToDoListViewImpl.class);
			break;
		case "Infobox":
			UI.getCurrent().navigate(InfoboxViewImpl.class);
			break;
		default:
			// TODO
			break;
		}

	}

}
