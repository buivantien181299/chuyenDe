/**
 * 
 */
package neu.shoes.converter;

import org.springframework.stereotype.Component;

import neu.shoes.dto.RoleDTO;
import neu.shoes.entity.RoleEntity;

/**
 * @author TienBV
 *
 */

@Component
public class RoleConver {
	/**
	* This method convert role from DTO to Entity .
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
	public RoleEntity toEntity (RoleDTO roleDTO) {
		
		RoleEntity roleEntity = new RoleEntity();
		
		roleEntity.setCode(roleDTO.getCode());
		roleEntity.setName(roleDTO.getName());
		roleEntity.setDeleted(roleDTO.getDeleted());
		return roleEntity;
	}
	
	

	/**
	* This method convert role from DTO to Entity .
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
	public RoleEntity toEntity (RoleDTO roleDTO,RoleEntity roleEntity) {
		
		roleEntity.setCode(roleDTO.getCode());
		roleEntity.setName(roleDTO.getName());

		return roleEntity;
	}
	
	/**
	* This method convert role from Entity to DTO.
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
	public RoleDTO toDTO(RoleEntity roleEntity) {
		
		RoleDTO roleDTO = new RoleDTO();
		
		if(roleEntity.getId() != null) {
			roleDTO.setId(roleEntity.getId());
		}
		roleDTO.setCode(roleEntity.getCode());
		roleDTO.setName(roleEntity.getName());
		roleDTO.setCreatedBy(roleEntity.getCreatedBy());
		roleDTO.setCreatedDate(roleEntity.getCreatedDate());
		roleDTO.setModifiedBy(roleEntity.getModifiedBy());
		roleDTO.setModifiedDate(roleEntity.getModifiedDate());
		roleDTO.setDeleted(roleEntity.getDeleted());	
		return roleDTO;
	}
}
