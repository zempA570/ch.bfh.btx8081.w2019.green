package ch.bfh.btx8081.w2019.green.alzman.view;

import com.vaadin.flow.component.icon.Icon;

public interface DashboardView {

	interface DashboardViewListener {
		void iconClick(Icon icon);
	}

	public void addListener(DashboardViewListener listener);
	
}
