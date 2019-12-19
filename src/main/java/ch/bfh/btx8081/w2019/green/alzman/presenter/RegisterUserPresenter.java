package ch.bfh.btx8081.w2019.green.alzman.presenter;

import ch.bfh.btx8081.w2019.green.alzman.model.Patient;
import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.RegisterPatientView;

public class RegisterUserPresenter {

	private RegisterPatientView view;

	public RegisterUserPresenter(RegisterPatientView view) {
		this.view = view;
	}

	public void addPatientAndUser(String firstnameUser, String lastnameUser, String firstnamePatient,
			String lastnamePatient, String passwordPatient) {

		User newUser = new User(firstnameUser, lastnameUser);
		Patient newPatient = new Patient(passwordPatient, firstnamePatient, lastnamePatient);

		// DB stuff
		DbService.init();
		DbService.em.getTransaction().begin();
		DbService.em.persist(newUser);
		DbService.em.persist(newPatient);
		DbService.em.getTransaction().commit();

	}

}
