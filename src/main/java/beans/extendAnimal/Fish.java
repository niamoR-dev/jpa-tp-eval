package beans.extendAnimal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import beans.Animal;
import beans.PetStore;
import enums.FishLivEnv;

@Entity
public class Fish extends Animal{

	
	@Enumerated(EnumType.STRING)
	private FishLivEnv livingEnv;
	
////////////////////////////////////////////////////////////////////////////////

	public Fish(Date birth, String color, FishLivEnv livingEnv) {
		super(birth, color);
		this.livingEnv = livingEnv;
	}

	
	
	public Fish( Date birth, String color, FishLivEnv livingEnv ,PetStore petStore ) {
		super( birth, color, petStore);
		this.livingEnv = livingEnv;
	}



	public Fish() {
	}
	
////////////////////////////////////////////////////////////////////////////////

	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Fish [livingEnv = " + livingEnv + " , birth = " + birth + ", color = " + color + "]";
	}

	
	
	
	
}
