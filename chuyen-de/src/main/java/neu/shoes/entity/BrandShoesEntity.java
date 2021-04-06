 /**
 * 
 */
package neu.shoes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author TienBV
 *
 */
@Entity
@Table(name = "brand_shoes")
public class BrandShoesEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;


	@Column(name = "brand")
	private String brand;
	
	
	@Column(name = "design")
	private String design;
	
	@OneToMany(mappedBy = "brandShoes",  fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ShoesEntity> shoes = new ArrayList<>();
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public List<ShoesEntity> getShoes() {
		return shoes;
	}

	public void setShoes(List<ShoesEntity> shoes) {
		this.shoes = shoes;
	}


	
	
	
}
