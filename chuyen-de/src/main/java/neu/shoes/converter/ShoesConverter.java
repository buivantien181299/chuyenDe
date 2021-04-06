/**
 * 
 */
package neu.shoes.converter;

import org.springframework.stereotype.Component;

import neu.shoes.dto.ShoesDTO;
import neu.shoes.entity.ShoesEntity;

/**
 * @author TienBV
 *
 */
@Component
public class ShoesConverter {
	
	/**
	* This method convert shoes from DTO to Entity.
	*
	* @Description: .
	* @author: TienBV
	* @create_date: Mar 7, 2021
	* @version: 1.0
	* @modifer: TienBV
	* @modifer_date: Mar 7, 2021
	* @param shoesDTO
	* @return
	*/
	public ShoesEntity toEntity(ShoesDTO shoesDTO) {
		
		ShoesEntity shoesEntity = new ShoesEntity();
		
		shoesEntity.setShoesName(shoesDTO.getShoesName());
		shoesEntity.setColor(shoesDTO.getColor());
		shoesEntity.setDescription(shoesDTO.getDescription());
		shoesEntity.setImage(shoesDTO.getImage());
		shoesEntity.setPrice(shoesDTO.getPrice());
		shoesEntity.setOrigin(shoesDTO.getOrigin());
		shoesEntity.setQuantity(shoesDTO.getQuantity());
		shoesEntity.setSize(shoesDTO.getSize());
		shoesEntity.setStatus(shoesDTO.getStatus());
		shoesEntity.setDeleted(shoesDTO.getDeleted());
		
		return 	shoesEntity;
	}
	
	/**
	* This method convert shoes from DTO to Entity.
	*
	* @Description: .
	* @author: TienBV
	* @create_date: Mar 7, 2021
	* @version: 1.0
	* @modifer: TienBV
	* @modifer_date: Mar 7, 2021
	* @param shoesDTO
	* @return
	*/
	public ShoesEntity toEntity(ShoesDTO shoesDTO, ShoesEntity shoesEntity) {
	
		shoesEntity.setShoesName(shoesDTO.getShoesName());
		shoesEntity.setColor(shoesDTO.getColor());
		shoesEntity.setDescription(shoesDTO.getDescription());
		shoesEntity.setImage(shoesDTO.getImage());
		shoesEntity.setPrice(shoesDTO.getPrice());
		shoesEntity.setOrigin(shoesDTO.getOrigin());
		shoesEntity.setQuantity(shoesDTO.getQuantity());
		shoesEntity.setSize(shoesDTO.getSize());
		shoesEntity.setStatus(shoesDTO.getStatus());
		
		return 	shoesEntity;
	}
	
	
	/**
	* This method convert shoes from Entity to DTO .
	*
	* @Description: .
	* @author: TienBV
	* @create_date: Mar 7, 2021
	* @version: 1.0
	* @modifer: TienBV
	* @modifer_date: Mar 7, 2021
	* @param shoesEntity
	* @return
	*/
	public ShoesDTO toDTO(ShoesEntity shoesEntity) {
		
		ShoesDTO shoesDTO = new ShoesDTO();
		
		if(shoesEntity.getId() != null) {
			shoesDTO.setId(shoesEntity.getId());
		}
		shoesDTO.setShoesName(shoesEntity.getShoesName());
		shoesDTO.setDescription(shoesEntity.getDescription());
		shoesDTO.setColor(shoesEntity.getColor());
		shoesDTO.setSize(shoesEntity.getSize());
		shoesDTO.setImage(shoesEntity.getImage());	
		shoesDTO.setOrigin(shoesEntity.getOrigin());
		shoesDTO.setPrice(shoesEntity.getPrice());
		shoesDTO.setQuantity(shoesEntity.getQuantity());
		shoesDTO.setStatus(shoesEntity.getStatus());
		shoesDTO.setCreatedBy(shoesEntity.getCreatedBy());
		shoesDTO.setCreatedDate(shoesEntity.getCreatedDate());
		shoesDTO.setModifiedBy(shoesEntity.getModifiedBy());
		shoesDTO.setModifiedDate(shoesEntity.getModifiedDate());
		shoesDTO.setDeleted(shoesEntity.getDeleted());	
		
		return shoesDTO;
		
	}
	
	

}
