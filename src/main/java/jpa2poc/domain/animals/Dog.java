package jpa2poc.domain.animals;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("dog")
@Table(name="dogs")
public class Dog extends Mammal {

	@Column(name = "hair")
	private String hair;

	public Dog(String name, String hair) {
		super(name);
		this.hair = hair;
	}

	@Override
	public String toString() {
		return "Dog [hair=" + hair + ", name=" + name + "]";
	}
}
