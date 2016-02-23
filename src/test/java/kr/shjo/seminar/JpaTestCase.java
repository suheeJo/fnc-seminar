package kr.shjo.seminar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JpaTestCase {
	
	private EntityManagerFactory emf = null;

	@Before
	public void init() throws Exception {
		System.out.println("before start...");
		emf = Persistence.createEntityManagerFactory("jpa-test");
	}
	
	@After
	public void destory() throws Exception {
		System.out.println("after start...");
		emf.close();
	}
	
	@Test
	public void connectTest() throws Exception {
		control(emf, new Logic() {
			@Override
			public void logic(EntityManager em) {
				System.out.println("connection test");
			}
		});
	}
	
	interface Logic {
		void logic(EntityManager em);
	}
	
	private void control(EntityManagerFactory emf, Logic logic) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			if(logic != null) {
				logic.logic(em);
			}
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
	}
}
