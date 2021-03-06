package ch.bfh.btx8081.w2019.green.alzman.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.AddressModel;
import ch.bfh.btx8081.w2019.green.alzman.model.PersonModel;
import ch.bfh.btx8081.w2019.green.alzman.model.AppointmentModel;
import ch.bfh.btx8081.w2019.green.alzman.model.NotesModel;
import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;
import ch.bfh.btx8081.w2019.green.alzman.model.DiaryModel;
import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;
import ch.bfh.btx8081.w2019.green.alzman.model.UserModel;

/**
 * The dbService is used to execute statements on the database
 * 
 * @author Adrian
 *
 */

public class DbService{

	private static final String PERSISTENCE_UNIT_NAME = "alzman";
	private static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

	public static void persist(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public static void remove(Object entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
	
	public static void update(Object entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public static List<TaskModel> getAllTasks() {
		Query query = em.createNativeQuery("SELECT * FROM task", TaskModel.class);
		List<TaskModel> lstTasks = query.getResultList();
		
		return lstTasks;
	}

	public static List<DiaryModel> getAllDiarys() {
		Query query = DbService.em.createNativeQuery("SELECT * FROM Diary", DiaryModel.class);
		return query.getResultList();
	}

	public static List<PersonModel> getAllPerson() {

		Query query = DbService.em.createNativeQuery("SELECT * FROM Person", PersonModel.class);

		return query.getResultList();
	}

	public static List<AddressModel> getAllAddress() {

		Query query = DbService.em.createNativeQuery("SELECT * FROM Address", AddressModel.class);

		return query.getResultList();
	}

	public static List<AppointmentModel> getAllAppointments() {
		Query query = DbService.em.createNativeQuery("SELECT * FROM Appointment", AppointmentModel.class);

		return query.getResultList();
	}

	public static List<NotesModel> getAllNotes() {
		Query query = DbService.em.createNativeQuery("SELECT * FROM Notes", NotesModel.class);
		return query.getResultList();
	}

	/**
	 * 
	 * @return the complete content of the row named "status" in the database.
	 */
	public static List<StatusModel> getAllStatus() {
		Query query = DbService.em.createNativeQuery("SELECT * FROM status", StatusModel.class);
		return query.getResultList();
	}

	public static List<UserModel> getAllUsers() {
		
		Query query = DbService.em.createNativeQuery("SELECT * FROM Relative", UserModel.class);
		return query.getResultList();
	}

}
