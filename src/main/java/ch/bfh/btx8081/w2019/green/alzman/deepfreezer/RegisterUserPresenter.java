package ch.bfh.btx8081.w2019.green.alzman.deepfreezer;
//package ch.bfh.btx8081.w2019.green.alzman.trash;
//
//import com.vaadin.flow.component.UI;
//
//import ch.bfh.btx8081.w2019.green.alzman.model.UserModel;
//import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
//import ch.bfh.btx8081.w2019.green.alzman.view.DashboardViewImpl;
//
//public class RegisterUserPresenter {
//
//	private RegisterPatientView view;
//
//	public RegisterUserPresenter(RegisterPatientView view) {
//		this.view = view;
//	}
//
//	public void addPatientAndUser(String firstnameUser, String lastnameUser, String firstnamePatient,
//			String lastnamePatient, String passwordPatient) {
//
//		// TODO validation all fields filled in view
//		// TODO validation passwords the same
//		
//		UserModel newUser = new UserModel(firstnameUser, lastnameUser);
//		PatientModel newPatient = new PatientModel(passwordPatient, firstnamePatient, lastnamePatient);
//
//		// DB stuff
//		DbService.persist(newUser);
//		DbService.persist(newPatient);
//		
//		UI.getCurrent().navigate(DashboardViewImpl.class);
//
//	}
//
//}
