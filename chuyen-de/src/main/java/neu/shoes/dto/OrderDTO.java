/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */

public class OrderDTO extends AbstractDTO<OrderDTO> {

	// Tên người dùng
	private String userName;

	// Số điện thoại người dùng
	private String phone;

	// Email người dùng
	private String email;

	// Địa chỉ người dùng
	private String address;

	// Tổng số lượng sản phẩm
	private Integer totalQuantity;

	// Tổng số tiền
	private Integer totalMoney;

	// Id giao dịch
	private String transactionType;
	
	// Trang thai
	private String status;


	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
