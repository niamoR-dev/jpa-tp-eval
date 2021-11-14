package test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import beans.Address;
import beans.Animal;
import beans.PetStore;
import beans.Product;
import beans.extendAnimal.Cat;
import beans.extendAnimal.Fish;
import enums.FishLivEnv;
import enums.ProdType;

public class TestPetStore {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tp-eval");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

////////////////////////////////////////////////////////////////////////////////
		
		// creation Shop
		PetStore petStore1 = new PetStore("Au bon toutou - Nantes", "Richard");
		PetStore petStore2 = new PetStore("Au bon toutou - Rezé", "Séga");
		PetStore petStore3 = new PetStore("Au bon toutou - Saint Herblain", "Alain");
		em.persist(petStore1);
		em.persist(petStore2);
		em.persist(petStore3);

		// creation cat
		Animal foxy = new Cat(new Date(12, 9, 2016), "Roux", "LEA32FG");
		Animal indi = new Cat(new Date(31, 12, 2014), "Tigre", "FET56TY");
		Animal pueblo = new Cat(new Date(24, 6, 2015), "Gris", "POI47TY");
		em.persist(foxy);
		em.persist(indi);
		em.persist(pueblo);

		// creation Fish
		Animal bubulle = new Fish(new Date(24, 6, 2021), "Jaune", FishLivEnv.FRESH_WATER , petStore1);
		Animal bidouille = new Fish(new Date(24, 6, 2015), "Rouge", FishLivEnv.SEA_WATER, petStore3);
		Animal poisscaille = new Fish(new Date(24, 6, 2015), "Vert", FishLivEnv.FRESH_WATER, petStore2);
		em.persist(bubulle);
		em.persist(bidouille);
		em.persist(poisscaille);

		// Create product
		Product accessoirePoisscaille = new Product("465gs1f22", "Du Bon Manger", ProdType.ACCESSORY, 25.20);
		Product litiereChat = new Product("fds6fd4fs", "Du Bon Manger", ProdType.CLEANING, 10.36);
		Product BouffeFish = new Product("fdd4f5ds45", "Du Bon Manger", ProdType.FOOD, 32.65);
		em.persist(accessoirePoisscaille);
		em.persist(litiereChat);
		em.persist(BouffeFish);

		// creation address
		Address nantes = new Address(32, "rue de Nantes", 44000, "Nantes");
		Address reze = new Address(152, "Boulevard de Rezé", 44652, "Rezé");
		Address saintHerblain = new Address(24, "rue de Saint Herblain", 44600, "Saint Herblain");
		em.persist(nantes);
		em.persist(reze);
		em.persist(saintHerblain);


////////////////////////////////////////////////////////////////////////////////		
		
		petStore1.setAddress(nantes);
		petStore2.setAddress(saintHerblain);
		petStore3.setAddress(reze);
		
		indi.setPetStore(petStore1);
		foxy.setPetStore(petStore2);
		pueblo.setPetStore(petStore3);
		
		
////////////////////////////////////////////////////////////////////////////////
		
//		ArrayList<Animal> list = new ArrayList<Animal>(Arrays.asList(foxy, indi));
//		
//		System.out.println(list);
		
		
		petStore1.setProducts(accessoirePoisscaille);
		petStore1.setProducts(litiereChat);
		petStore1.setProducts(BouffeFish);
		
		
		
		petStore2.setProducts(litiereChat);
		petStore2.setProducts(accessoirePoisscaille);
		
		petStore3.setProducts(accessoirePoisscaille);
		petStore3.setProducts(BouffeFish);
		
		
//		
//		petStore2.setAnimals(new ArrayList<Animal>(Arrays.asList(indi, bidouille)));
//		em.persist(petStore2);
		
////////////////////////////////////////////////////////////////////////////////
		
		// Request SQL
		Query query = em.createQuery("SELECT a FROM Animal a JOIN a.petStore p WHERE p.managerName = 'Richard'");
		List<Animal> animal = query.getResultList();

		
		for (Animal animals : animal) {
			System.out.println(animals);
		}

		et.commit();
		em.close();
		emf.close();
	}

}
