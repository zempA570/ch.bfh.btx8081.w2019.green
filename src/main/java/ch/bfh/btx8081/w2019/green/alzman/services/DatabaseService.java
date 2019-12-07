package ch.bfh.btx8081.w2019.green.alzman.services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseService {

	private static final String PERSISTENCE_UNIT_NAME = "alzman";
	private static EntityManager entityManager;

	public static void main(String[] args) {

		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

	}

}
