/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */
public class UserDTO extends AbstractDTO<UserDTO> {

	// Tên người dùng
	private String userName;

	// Giới tính người dùng
	private String gender;

	// Số điện thoại người dùng
	private String phone;

	// Email người dùng
	private String email;

	// Địa chỉ người dùng
	private String address;

	// Mật khẩus
	private String password;

	// Mã pin thẻ
	private String pin;

	// Mã quyền truy cập

	private String code;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
