package beans.extendAnimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import beans.Animal;
import beans.PetStore;

@Entity
public class Cat extends Animal {

	@Column(name = "CHIPID", nullable = false)
	private String chipId;

////////////////////////////////////////////////////////////////////////////////
	
	public Cat(Date birth, String color, String chipId) {
		super(birth, color);
		this.chipId = chipId;
	}
	


	public Cat(Date birth, String color, String chipId, PetStore petStore) {
		super(birth, color, petStore);
		this.chipId = chipId;
	}



	public Cat() {
	}
	
////////////////////////////////////////////////////////////////////////////////

	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}



	@Override
	public String toString() {
		return "Cat [chipId = " + chipId + ", birth = " + birth + ", color = " + color + ", petStore = " + petStore + " ]";
	}
	
////////////////////////////////////////////////////////////////////////////////

	

	
	
	
	
}
