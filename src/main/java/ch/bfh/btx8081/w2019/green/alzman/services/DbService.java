package ch.bfh.btx8081.w2019.green.alzman.services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * The dbService is used to execute statements on the database
 * 
 * @author Roman
 *
 */
public class DbService {

	private static final String PERSISTENCE_UNIT_NAME = "alzman";
	public static EntityManager em;

	public static void init() {

		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

	}
	
}
