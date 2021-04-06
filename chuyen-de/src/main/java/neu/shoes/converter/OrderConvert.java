/**
 * 
 */
package neu.shoes.converter;

import org.springframework.stereotype.Component;

import neu.shoes.dto.OrderDTO;
import neu.shoes.entity.OrderEntity;

/**
 * @author TienBV
 *
 */

@Component
public class OrderConvert {

	/**
	 * This method convert order from DTO to Entity .
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
	public OrderEntity toEntity(OrderDTO orderDTO) {

		OrderEntity orderEntity = new OrderEntity();

		orderEntity.setAddress(orderDTO.getAddress());
		orderEntity.setEmail(orderDTO.getEmail());
		orderEntity.setPhone(orderDTO.getPhone());
		orderEntity.setUserName(orderDTO.getUserName());
		orderEntity.setTotalMoney(orderDTO.getTotalMoney()); 
		orderEntity.setTotalQuantity(orderDTO.getTotalQuantity());
		orderEntity.setStatus(orderDTO.getStatus());
		orderEntity.setDeleted(orderDTO.getDeleted());
		return orderEntity;
	}

	/**
	 * This method convert order from DTO to Entity .
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
	public OrderEntity toEntity(OrderDTO orderDTO, OrderEntity orderEntity) {

		orderEntity.setAddress(orderDTO.getAddress());
		orderEntity.setEmail(orderDTO.getEmail());
		orderEntity.setPhone(orderDTO.getPhone());
		orderEntity.setUserName(orderDTO.getUserName());
		orderEntity.setTotalMoney(orderDTO.getTotalMoney());
		orderEntity.setTotalQuantity(orderDTO.getTotalQuantity());
		orderEntity.setStatus(orderDTO.getStatus());
		
		return orderEntity;
	}

	/**
	 * This method convert order from Entity to DTO.
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
	public OrderDTO toDTO(OrderEntity orderEntity) {

		OrderDTO orderDTO = new OrderDTO();

		if (orderEntity.getId() != null) {
			orderDTO.setId(orderEntity.getId());
		}
		
		orderDTO.setAddress(orderEntity.getAddress());
		orderDTO.setEmail(orderEntity.getEmail());
		orderDTO.setPhone(orderEntity.getPhone());
		orderDTO.setUserName(orderEntity.getUserName());
		orderDTO.setTotalMoney(orderEntity.getTotalMoney());
		orderDTO.setTotalQuantity(orderEntity.getTotalQuantity());
		orderDTO.setStatus(orderEntity.getStatus());
		orderDTO.setTransactionType(orderEntity.getTransaction().getTransactionType());
		orderDTO.setCreatedBy(orderEntity.getCreatedBy());
		orderDTO.setCreatedDate(orderEntity.getCreatedDate());
		orderDTO.setModifiedBy(orderEntity.getModifiedBy());
		orderDTO.setModifiedDate(orderEntity.getModifiedDate());
		orderDTO.setDeleted(orderEntity.getDeleted());
		orderDTO.setStatus(orderEntity.getStatus());
		return orderDTO;
	}

}
