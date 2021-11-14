package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PETSTORE")
public class PetStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "MANAGERNAME", nullable = false)
	private String managerName;

////////////////////////////////////////////////////////////////////////////////

	@ManyToMany
	@JoinTable(name = "PETSTORE_PRODUCT", joinColumns = @JoinColumn(name = "ID_PETSTORE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID"))
	private Set<Product> products = new HashSet<Product>();

	@OneToMany(mappedBy = "petStore")
	private Set<Animal> animals;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
	private Address address;

////////////////////////////////////////////////////////////////////////////////

	public PetStore(String name, String managerName) {
		this.name = name;
		this.managerName = managerName;
	}


	public PetStore() {
		super();
	}

////////////////////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getId() {
		return id;
	}

	
	
	
////////////////////////////////////////////////////////////////////////////////

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Product product) {
		this.products.add(product);
	}
	
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "PetStore [ id =" + id + ", name = " + name + ", managerName = " + managerName + " ]";
	}

	

}
