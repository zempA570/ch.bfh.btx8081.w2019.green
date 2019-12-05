package ch.bfh.btx8081.w2019.green.alzman.view;


import java.security.Provider.Service;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;


@Route("Kalender")

public class CalendarView extends VerticalLayout implements BeforeEnterObserver {

	
	private static final long serialVersionUID = 1L;

	private Label month;

	
	private Calendar calendar;

	
	public CalendarView() {
		this.initView();
		this.initCal();
	}
	
	private void initView() {

		VerticalLayout verticallay = new VerticalLayout();
		verticallay.setWidth("350px");

		HorizontalLayout hl1 = new HorizontalLayout();
		hl1.setWidth("100%");
		hl1.setHeight("100%");
		

		this.add(hl1);

	}


	private void initCal() {
		this.calendar = new GregorianCalendar();
		this.calendar.set(Calendar.DAY_OF_MONTH, 1);
		this.month.setText(this.parseMonth(this.calendar.get(Calendar.MONTH)));
		
		while (!this.calendar.getTime().toString().substring(0, 3).equals("Mon")) {
			this.theDayBefore();
		}

	}

	private String parseMonth(int i) {
		String[] months = { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		return months[i];
	}

	
	private void theDayBefore() {
		this.calendar.set(Calendar.DATE, this.calendar.get(Calendar.DATE) - 1);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub
		
	}

}