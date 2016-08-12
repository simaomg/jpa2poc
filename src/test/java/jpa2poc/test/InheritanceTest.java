package jpa2poc.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import jpa2poc.domain.animals.Cat;
import jpa2poc.domain.animals.Dog;
import jpa2poc.domain.animals.Mammal;
import jpa2poc.test.arquitetura.BaseTest;

public class InheritanceTest extends BaseTest {
	
	private static final Logger LOGGER = LogManager.getLogger(InheritanceTest.class); 

	@Test
	public void test() {
		Dog cachorro1 = new Dog("Baleia", "curto");
		Dog cachorro2 = new Dog("Bolinha", "médio");
		Cat gato1 = new Cat("Faísca", "peixe");
		Cat gato2 = new Cat("Xanim", "carne");
		
		entityManager.getTransaction().begin();
		entityManager.persist(cachorro1);
		entityManager.persist(cachorro2);
		entityManager.persist(gato1);
		entityManager.persist(gato2);
		entityManager.getTransaction().commit();
		
		List<Mammal> mammals = entityManager.createQuery("select m from Mammal m", Mammal.class).getResultList();
		for (Mammal mammal : mammals) {
			LOGGER.info(mammal);
		}
	}
}
