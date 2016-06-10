package jpa2poc.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jpa2poc.domain.animals.Dog;
import jpa2poc.domain.animals.Cat;
import jpa2poc.domain.animals.Mammal;

public class InheritanceTest {
	
	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	private static final Logger LOGGER = LogManager.getLogger(InheritanceTest.class); 
	
	@BeforeClass
	public static void beforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("pocPu");
	}
	
	@Before
	public void before() {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	@After
	public void after() {
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@AfterClass
	public static void afterClass() {
		entityManagerFactory.close();
	}

	@Test
	public void test() {
		Dog cachorro1 = new Dog("Baleia", "curto");
		Dog cachorro2 = new Dog("Bolinha", "médio");
		Cat gato1 = new Cat("Faísca", "peixe");
		Cat gato2 = new Cat("Xanim", "carne");
		
		entityManager.persist(cachorro1);
		entityManager.persist(cachorro2);
		entityManager.persist(gato1);
		entityManager.persist(gato2);
		
		List<Mammal> mammals = entityManager.createQuery("select m from Mammal m", Mammal.class).getResultList();
		for (Mammal mammal : mammals) {
			LOGGER.info(mammal);
		}
	}
}
