package ch.bfh.btx8081.w2019.green.alzman.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.StatusModel;

/**
 * The dbService is used to execute statements on the database
 * 
 * @author Adrian
 *
 */
public class DbService {

	private static final String PERSISTENCE_UNIT_NAME = "alzman";
	public static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	
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
	
	public static List<StatusModel> getAllStatus() {
		Query query = DbService.em.createNativeQuery("SELECT * FROM status",
		StatusModel.class);
		return query.getResultList();
	}
	
}
