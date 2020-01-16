package ch.bfh.btx8081.w2019.green.alzman.services;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import ch.bfh.btx8081.w2019.green.alzman.model.AppointmentModel;

/**
 * Tests the db service. Will only work if in BFH network or connected via VPN.
 * First an entry is added, then it is deleted. To make sure the right order is
 * kept the test are run in order of their name ascending.
 * 
 * @author Adrian
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DbServiceTest_Appointment {

	private final String AUTHOR = "uecccccccccccccccccccccc&uifJLO24b";

	@Test
	public void addAppointment() {

		// given
		Date date = Date.valueOf(LocalDate.now());
		Time time = Time.valueOf(LocalTime.now());
		String entry = "whatever you have to do, do it";

		AppointmentModel newAppoint = new AppointmentModel(date, time, AUTHOR, entry);

		// when
		DbService.persist(newAppoint);

		// then
		List<AppointmentModel> lstAppoint = DbService.getAllAppointments();
		AppointmentModel appointmentFromDb = null;

		for (AppointmentModel appointment : lstAppoint) {
			if (AUTHOR == appointment.getAuthor()) {
				appointmentFromDb = appointment;
			}
		}

		assertTrue(appointmentFromDb.getDate() == date);
		assertTrue(appointmentFromDb.getTime() == time);
		assertTrue(appointmentFromDb.getEntry() == entry);

	}

	@Test
	public void deleteAppointment() {

		// given
		List<AppointmentModel> lstAppointBefore = DbService.getAllAppointments();
		int amountOfEntriesBefore = lstAppointBefore.size();
		AppointmentModel appointmentToDelete = null;

		for (AppointmentModel appointment : lstAppointBefore) {
			if (AUTHOR == appointment.getAuthor()) {
				appointmentToDelete = appointment;
			}
		}

		// when
		DbService.remove(appointmentToDelete);

		// then
		List<AppointmentModel> lstAppointAfter = DbService.getAllAppointments();
		int amountOfEntriesAfter = lstAppointAfter.size();

		assertTrue(amountOfEntriesAfter == amountOfEntriesBefore - 1);

		for (AppointmentModel appointment : lstAppointAfter) {
			assertTrue(AUTHOR != appointment.getAuthor());
		}

	}

}
