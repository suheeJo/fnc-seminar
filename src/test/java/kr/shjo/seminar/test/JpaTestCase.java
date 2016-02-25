package kr.shjo.seminar.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.shjo.seminar.model.Member;

public class JpaTestCase {
	
	private EntityManagerFactory emf = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("###### before start");
		emf = Persistence.createEntityManagerFactory("jpa-test");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("###### after start");
		emf.close();
	}
	
	@Test
	public void deleteTeest() throws Exception {
		control(emf, (em) -> {
			long memberId = 5;
			Member member = em.find(Member.class, memberId);
			em.remove(member);			
		});
	}
	
	@Test
	public void updateTest() throws Exception {
		control(emf, (em) -> {
			long memberId = 1;
			Member member = em.find(Member.class, memberId);
			member.setEmail("suhee@mail.co.kr");
			
			Member updateMember = em.find(Member.class, memberId);
			System.out.println(updateMember.getId() + ". " + updateMember.getName() + ": " + updateMember.getEmail());			
		});
	}
	
	@Test
	public void getTest() throws Exception {
		control(emf, (em) -> {
			long memberId = 1;
			Member member = em.find(Member.class, memberId);
			System.out.println(member.getId() + ". " + member.getName() + ": " + member.getEmail());			
		});
	}
	
	@Test
	public void inserTest() throws Exception {
		control(emf, (em) -> {
			Member member = new Member();
			member.setName("조수희3");
			member.setEmail("test3@test.co.kr");
			em.persist(member);
		});
	}
	
	@Test
	public void connectTest() throws Exception {
		control(emf, new Logic() {
			
			@Override
			public void logic(EntityManager em) {
				System.out.println("###### connection test");
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
				System.out.println("###### logic");
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
