package ch.bfh.btx8081.w2019.green.alzman.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.TaskModel;

/**
 * The dbService is used to execute statements on the database
 * 
 * @author Adrian
 *
 */
public class DbService {

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
	
}
