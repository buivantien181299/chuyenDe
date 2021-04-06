/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import neu.shoes.Respone.Response;
import neu.shoes.dto.OrderDTO;

/**
 * @author TienBV
 *
 */
public interface IOrderService {

	/*
	 * Lấy danh sách order.
	 * 
	 * @return List<ShoesDTO>
	 */
	List<OrderDTO> getListOrder(Pageable pageable);
	
	/*
	 * Lấy danh sách order.
	 * 
	 * @return List<ShoesDTO>
	 */
	Response<List<OrderDTO>> getListOrder();

	/**
	 * Lấy thông tin order theo id
	 * 
	 * @param id
	 * @return Shoes
	 */
	OrderDTO getOrderById(long id);

	/*
	 * Tạo mới order.
	 * 
	 * @param ShoesDTO.
	 * 
	 * @return ShoesDTO.
	 * 
	 */
	Response<OrderDTO> saveNewOrder(OrderDTO orderDTO);

	/**
	 * Xóa order.
	 * 
	 * @param id
	 */
	Response<OrderDTO> deleteOrder(long id);

	/**
	 * Tong so order.
	 * 
	 * @return totalItem
	 */
	int totalItem();

}
