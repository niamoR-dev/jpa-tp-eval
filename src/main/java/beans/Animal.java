package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ANIMAL")
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "BIRTH", nullable = false)
	protected Date birth;

	@Column(name = "COLOR", nullable = false)
	protected String color;

////////////////////////////////////////////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "ID_PETSTORE")
	protected PetStore petStore;

////////////////////////////////////////////////////////////////////////////////

	public Animal(Date birth, String couleur) {
		this.birth = birth;
		this.color = couleur;
	}
	
	

	public Animal(Date birth, String color, PetStore petStore) {
		this.birth = birth;
		this.color = color;
		this.petStore = petStore;
	}



	public Animal() {
	}

////////////////////////////////////////////////////////////////////////////////

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCouleur() {
		return color;
	}

	public void setCouleur(String couleur) {
		this.color = couleur;
	}

	public Long getId() {
		return id;
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public PetStore getPetStore() {
		return petStore;
	}

	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	
	
////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Animal [ id = " + id + ", birth = " + birth + ", color = " + color + " ]";
	}

	

}
