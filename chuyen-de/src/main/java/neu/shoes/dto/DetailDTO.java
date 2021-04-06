/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */
public class DetailDTO extends AbstractDTO<DetailDTO> {

	// Liên kết vs giày
	private Long shoesID;

	// Tên giày
	private String shoesName;

	// Số lượng giày.
	private Integer quantity;

	// Giá.
	private Integer price;

	public Long getShoesID() {
		return shoesID;
	}

	public void setShoesID(Long shoesID) {
		this.shoesID = shoesID;
	}


	public String getShoesName() {
		return shoesName;
	}

	public void setShoesName(String shoesName) {
		this.shoesName = shoesName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	

}
