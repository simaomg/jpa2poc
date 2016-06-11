package jpa2poc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jpa2poc.domain.employees.Employee;
import jpa2poc.domain.employees.Phone;
import jpa2poc.test.arquitetura.BaseTest;

public class UnidirectionalOneToManyTest extends BaseTest {

	@Test
	public void test() {
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("5585987654321"));
		
		Employee e = new Employee("Simão", phones );
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();

		Employee selectedEmployee = entityManager.createQuery("select e from Employee e where e.name = :name", Employee.class).setParameter("name", e.getName()).getSingleResult();
		LOGGER.info(selectedEmployee);
	}
}
