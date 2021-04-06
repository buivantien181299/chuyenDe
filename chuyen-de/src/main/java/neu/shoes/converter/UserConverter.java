/**
 * 
 */
package neu.shoes.converter;

import org.springframework.stereotype.Component;

import neu.shoes.dto.UserDTO;
import neu.shoes.entity.UserEntity;

/**
 * @author TienBV
 *
 */

@Component
public class UserConverter {

	/**
	* This method convert user from DTO to Entity .
	*
	* @Description: .
	* @author: TienBV
	* @create_date: Mar 9, 2021
	* @version: 1.0
	* @modifer: TienBV
	* @modifer_date: Mar 9, 2021
	* @param useDTO
	* @return
	*/
	public UserEntity toEntity (UserDTO useDTO) {
		
		UserEntity userUnEntity = new UserEntity();
		
		userUnEntity.setUserName(useDTO.getUserName());
		userUnEntity.setAddress(useDTO.getAddress());
		userUnEntity.setEmail(useDTO.getEmail());
		userUnEntity.setGender(useDTO.getGender());
		userUnEntity.setPhone(useDTO.getPhone());
		userUnEntity.setPassword(useDTO.getPassword());
		userUnEntity.setDeleted(useDTO.getDeleted());

		return userUnEntity;
	}
	
	

	/**
	* This method convert user from DTO to Entity .
	*
	* @Description: .
	* @author: TienBV
	* @create_date: Mar 9, 2021
	* @version: 1.0
	* @modifer: TienBV
	* @modifer_date: Mar 9, 2021
	* @param useDTO
	* @return
	*/
	public UserEntity toEntity (UserDTO useDTO,UserEntity userUnEntity) {
		
		userUnEntity.setUserName(useDTO.getUserName());
		userUnEntity.setAddress(useDTO.getAddress());
		userUnEntity.setEmail(useDTO.getEmail());
		userUnEntity.setGender(useDTO.getGender());
		userUnEntity.setPhone(useDTO.getPhone());
		userUnEntity.setPassword(useDTO.getPassword());
		return userUnEntity;
	}
	
	/**
	* This method convert user from Entity to DTO.
	*
	* @Description: .
	* @author: TienBV
	* @create_date: Mar 9, 2021
	* @version: 1.0
	* @modifer: TienBV
	* @modifer_date: Mar 9, 2021
	* @param userEntity
	* @return
	*/
	public UserDTO toDTO(UserEntity userEntity) {
		
		UserDTO userDTO = new UserDTO();
		
		if(userEntity.getId() != null) {
			userDTO.setId(userEntity.getId());
		}
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setAddress(userEntity.getAddress());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setGender(userEntity.getGender());
		userDTO.setPhone(userEntity.getPhone());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setCreatedBy(userEntity.getCreatedBy());
		userDTO.setCreatedDate(userEntity.getCreatedDate());
		userDTO.setModifiedBy(userEntity.getModifiedBy());
		userDTO.setModifiedDate(userEntity.getModifiedDate());
		userDTO.setDeleted(userEntity.getDeleted());	
		return userDTO;
	}
	
}
