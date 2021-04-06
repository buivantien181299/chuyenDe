/**
 * 
 */
package neu.shoes.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import neu.shoes.dto.DetailDTO;
import neu.shoes.entity.OrderDetailEntity;
import neu.shoes.entity.ShoesEntity;
import neu.shoes.repository.ShoesRepository;

/**
 * @author TienBV
 *
 */
@Component
public class DetailConvert {
	
	@Autowired
	private ShoesRepository shoesRepository;
	

	

	/**
	* This method convert detail from DTO to Entity .
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
	public OrderDetailEntity toEntity (DetailDTO detailDTO) {
		
		OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
		ShoesEntity shoesEntity = shoesRepository.getShoesById(detailDTO.getShoesID());
		orderDetailEntity.setShoesEntity(shoesEntity);
		orderDetailEntity.setShoesName(shoesEntity.getShoesName());
		orderDetailEntity.setPrice(detailDTO.getPrice());
		orderDetailEntity.setQuantity(detailDTO.getQuantity());
		orderDetailEntity.setDeleted(detailDTO.getDeleted());
		
		return orderDetailEntity;
	}
	

	/**
	* This method convert detail from DTO to Entity .
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
	public OrderDetailEntity toEntity (DetailDTO detailDTO,OrderDetailEntity orderDetailEntity) {
		
		ShoesEntity shoesEntity = shoesRepository.findOne(detailDTO.getShoesID());
		orderDetailEntity.setShoesEntity(shoesEntity);
		orderDetailEntity.setShoesName(shoesEntity.getShoesName());
		orderDetailEntity.setPrice(detailDTO.getPrice());
		orderDetailEntity.setQuantity(detailDTO.getQuantity());
		return orderDetailEntity;
	}
	
	/**
	* This method convert detail from Entity to DTO.
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
	public DetailDTO toDTO(OrderDetailEntity orderDetailEntity) {
		
		DetailDTO detailDTO = new DetailDTO();
		
		if(orderDetailEntity.getId() != null) {
			detailDTO.setId(orderDetailEntity.getId());
		}
		detailDTO.setShoesID(orderDetailEntity.getShoesEntity().getId());
		detailDTO.setShoesName(orderDetailEntity.getShoesName());
		detailDTO.setPrice(orderDetailEntity.getPrice());
		detailDTO.setQuantity(orderDetailEntity.getQuantity());
		detailDTO.setCreatedBy(orderDetailEntity.getCreatedBy());
		detailDTO.setCreatedDate(orderDetailEntity.getCreatedDate());
		detailDTO.setModifiedBy(orderDetailEntity.getModifiedBy());
		detailDTO.setModifiedDate(orderDetailEntity.getModifiedDate());
		detailDTO.setDeleted(orderDetailEntity.getDeleted());	
		return detailDTO;
	}
}
