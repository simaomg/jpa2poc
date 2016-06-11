package jpa2poc.domain.employees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phone {

	@Id
	@GeneratedValue
	@Column(name = "identifier")
	private Integer identifier;
	
	@Column(name = "number")
	private String number; 

	/**
	 * JPA required
	 */
	@SuppressWarnings("unused")
	private Phone() {
	}

	public Phone(String number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [identifier=" + identifier + ", number=" + number + "]";
	}
}