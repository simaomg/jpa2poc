package jpa2poc.domain.animals;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("cat")
@Table(name="cats")
public class Cat extends Mammal {

	@Column(name = "ration")
	public String ration;

	public Cat(String name, String ration) {
		super(name);
		this.ration = ration;
	}

	@Override
	public String toString() {
		return "Cat [ration=" + ration + ", name=" + name + "]";
	}
}
