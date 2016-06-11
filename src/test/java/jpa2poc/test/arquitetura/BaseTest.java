package jpa2poc.test.arquitetura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import jpa2poc.test.InheritanceTest;

public abstract class BaseTest {
	
private static EntityManagerFactory entityManagerFactory;
	
	protected EntityManager entityManager;
	
	protected static final Logger LOGGER = LogManager.getLogger(InheritanceTest.class); 
	
	@BeforeClass
	public static void beforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("pocPu");
	}
	
	@Before
	public void before() {
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	
	@After
	public void after() {
		entityManager.close();
	}
	
	@AfterClass
	public static void afterClass() {
		entityManagerFactory.close();
	}
}
