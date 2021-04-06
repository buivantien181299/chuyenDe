/**
 * 
 */
package neu.shoes.Respone;

import neu.shoes.constant.Constant;

/**
 * @author TienBV
 *
 */
public class Response<T> {

	private String message;
	private T item;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	// Tài khoản không được tìm thấy
	public void accountNotFound(){
		this.message = Constant.errorAccountNotExists;
	}
	
	// Tài khoản đã tồn tại
	public void accountExists() {
		this.message = Constant.errorAccountExists;
	}
	
	// Thông báo thành công
	public void success() {
		this.message = Constant.success;
	}
	
	// Thông báo xóa thành công
	public void deletedDone() {
		this.message = Constant.deletedDone;
	}
	
	//Không có sản phẩm nào
	
	public void procductNotFound(){
		this.message = Constant.productNotExists;
	}
}
