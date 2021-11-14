package beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import enums.ProdType;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODE", nullable = false)
	private String code;

	@Column(name = "LABEL", nullable = false)
	private String label;

	@Enumerated(EnumType.STRING)
	private ProdType type;

	@Column(name = "PRICE", nullable = false)
	private double price;
	
////////////////////////////////////////////////////////////////////////////////

	@ManyToMany(mappedBy = "products")
	private Set<PetStore> petStores;
	
////////////////////////////////////////////////////////////////////////////////

	public Product(String code, String label, ProdType type, double price) {
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;

	}

	public Product() {
	}
	
////////////////////////////////////////////////////////////////////////////////

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ProdType getType() {
		return type;
	}

	public void setType(ProdType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Product [id = " + id + ", code = " + code + ", label = " + label + ", type = " + type + ", price = " + price
				+ " ]";
	}

}
