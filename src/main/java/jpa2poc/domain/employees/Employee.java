package jpa2poc.domain.employees;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "identifier")
	private Integer identifier;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_identifier", referencedColumnName = "identifier")
	private List<Phone> phones;
	
	/**
	 * JPA required
	 */
	@SuppressWarnings("unused")
	private Employee() {
	}

	public Employee(String name, List<Phone> phones) {
		super();
		this.name = name;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [identifier=" + identifier + ", name=" + name + ", phones=" + phones + "]";
	}
}
