package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMBER", nullable = false)
	private int number;

	@Column(name = "STREET", nullable = false)
	private String street;

	@Column(name = "ZIPCODE", nullable = false)
	private int zipCode;

	@Column(name = "CITY", nullable = false)
	private String city;

	////////////////////////////////////////////////////////////////////////////////

	@OneToOne(mappedBy = "address" )
	private PetStore petStore;

	////////////////////////////////////////////////////////////////////////////////

	public Address(int number, String street, int zipCode, String city) {
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;

	}

	public Address() {
	}

	////////////////////////////////////////////////////////////////////////////////

	public PetStore getPetStore() {
		return petStore;
	}

	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}

	public int getNumber() {
		return number;
	}

	

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}
	
	
////////////////////////////////////////////////////////////////////////////////
	
	

	@Override
	public String toString() {
		return "Address [ id = " + id + ", number = " + number + ", street = " + street + ", zipCode = " + zipCode
				+ ", city = " + city + " ]";
	}

}
