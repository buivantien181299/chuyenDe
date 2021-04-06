/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */
public class BrandShoesDTO extends AbstractDTO<BrandShoesDTO> {

	// Thương hiệu giày
	private String brand;

	// Kiểu thiết kế.
	private String design;

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

}
