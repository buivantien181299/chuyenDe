/**
 * 
 */
package neu.shoes.converter;

import org.springframework.stereotype.Component;

import neu.shoes.dto.BrandShoesDTO;
import neu.shoes.entity.BrandShoesEntity;

/**
 * @author TienBV
 *
 */
@Component
public class BrandConver {
	
	/**
	* This method convert brand from DTO to Entity .
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
	public BrandShoesEntity toEntity (BrandShoesDTO brandShoesDTO) {
		
		BrandShoesEntity brandShoesEntity = new BrandShoesEntity();
		
		brandShoesEntity.setBrand(brandShoesDTO.getBrand());
		brandShoesEntity.setDesign(brandShoesDTO.getDesign());
		brandShoesEntity.setDeleted(brandShoesDTO.getDeleted());
		
		return brandShoesEntity;
	}
	
	

	/**
	* This method convert brand from DTO to Entity .
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
	public BrandShoesEntity toEntity (BrandShoesDTO brandShoesDTO,BrandShoesEntity brandShoesEntity) {
		
		brandShoesEntity.setBrand(brandShoesDTO.getBrand());
		brandShoesEntity.setDesign(brandShoesDTO.getDesign());

		return brandShoesEntity;
	}
	
	/**
	* This method convert brand from Entity to DTO.
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
	public BrandShoesDTO toDTO(BrandShoesEntity brandShoesEntity) {
		
		BrandShoesDTO brandShoesDTO = new BrandShoesDTO();
		
		if(brandShoesEntity.getId() != null) {
			brandShoesDTO.setId(brandShoesEntity.getId());
		}
		brandShoesDTO.setBrand(brandShoesEntity.getBrand());
		brandShoesDTO.setDesign(brandShoesEntity.getDesign());
		brandShoesDTO.setCreatedBy(brandShoesEntity.getCreatedBy());
		brandShoesDTO.setCreatedDate(brandShoesEntity.getCreatedDate());
		brandShoesDTO.setModifiedBy(brandShoesEntity.getModifiedBy());
		brandShoesDTO.setModifiedDate(brandShoesEntity.getModifiedDate());
		brandShoesDTO.setDeleted(brandShoesEntity.getDeleted());	
		return brandShoesDTO;
	}
	

}
