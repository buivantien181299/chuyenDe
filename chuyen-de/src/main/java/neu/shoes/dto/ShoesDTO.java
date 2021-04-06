/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */
public class ShoesDTO extends AbstractDTO<ShoesDTO> {

	// Tên giày
	private String shoesName;

	// Hình ảnh minh họa
	private String image;

	// Thương hiệu giày
	private String brand;

	// Mô tả giày.
	private String description;

	// Giá giày
	private Integer price;

	// Nguồn gốc giày
	private String origin;

	// Kích thước giày
	private Integer size;

	// Màu giày
	private String color;

	// Số lượng giày.
	private Integer quantity;

	// Trạng thái của giày
	private String status;

	public String getShoesName() {
		return shoesName;
	}

	public void setShoesName(String shoesName) {
		this.shoesName = shoesName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
