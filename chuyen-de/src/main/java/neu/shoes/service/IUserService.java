/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import neu.shoes.Respone.Response;
import neu.shoes.dto.UserDTO;

/**
 * @author TienBV
 *
 */
public interface IUserService {

	/*
	 * Lấy danh sách uers.
	 * 
	 * @return List<UserDTO>
	 * 
	 */
	List<UserDTO> getListUser(Pageable pageable);
	
	/*
	 * Lấy danh sách uers khong paging.
	 * 
	 * @return List<UserDTO>
	 * 
	 */
	Response<List<UserDTO>> getListUser();
	
	 /**
     * Lấy thông tin khách hàng theo id
     * @param id
     * @return user
     */
	UserDTO getUserById(long id);
	
	 /**
     * Lấy thông tin khách hàng theo số điện thoại
     * @param phone
     * @return user
     */
	Response<UserDTO> getUserByPhone(String phone);

	/*
	 * Lưu hoặc thêm user.
	 * 
	 * @param UserDTO.
	 * 
	 * @return UserDTO.
	 * 
	 */
	Response<UserDTO> saveNewUser(UserDTO userDTO);

	/**
	 * Xóa user.
	 * 
	 * @param id
	 */
	Response<UserDTO> deleteUser(long id);
		
	/**
	 * Tong so user.
	 * 
	 * @return totalUser
	 */
	int totalUser();

}
