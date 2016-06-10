package jpa2poc.domain.animals;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="specie")
@Table(name="mammals")
public abstract class Mammal {

	@Id
	@GeneratedValue
	@Column(name = "identifier")
	private Integer identifier;
	
	@Column(name ="name")
	protected String name;

	public Mammal(String name) {
		super();
		this.name = name;
	}
}
