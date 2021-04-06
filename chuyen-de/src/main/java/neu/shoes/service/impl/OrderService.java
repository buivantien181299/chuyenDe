/**
 * 
 */
package neu.shoes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.shoes.Respone.Response;
import neu.shoes.constant.Constant;
import neu.shoes.converter.OrderConvert;
import neu.shoes.dto.OrderDTO;
import neu.shoes.entity.OrderEntity;
import neu.shoes.entity.TrasactionEntity;
import neu.shoes.entity.UserEntity;
import neu.shoes.repository.OrderRepository;
import neu.shoes.repository.TransactionRepository;
import neu.shoes.repository.UserRepository;
import neu.shoes.service.IOrderService;

/**
 * @author TienBV
 *
 */

@Service
@Transactional
public class OrderService implements IOrderService {

	private static final Logger LOGGER = Logger.getLogger(ShoesService.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderConvert orderConvert;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	

	/*
	 * @see
	 * neu.shoes.service.IOrderService#getListOrder(org.springframework.data.domain.
	 * Pageable)
	 */
	@Override
	public List<OrderDTO> getListOrder(Pageable pageable) {
		LOGGER.info("get list order");
		List<OrderDTO> results = new ArrayList<>();
		List<OrderEntity> orderEntities = orderRepository.findAll(pageable).getContent();
		for (OrderEntity orderEntity : orderEntities) {
			OrderDTO orderDTO = orderConvert.toDTO(orderEntity);
			results.add(orderDTO);
		}
		return results;
	}

	/*
	 * @see neu.shoes.service.IOrderService#getOrderById(long)
	 */
	@Override
	public OrderDTO getOrderById(long id) {
		return orderConvert.toDTO(orderRepository.findOne(id));
	}

	/*
	 * @see neu.shoes.service.IOrderService#saveNewOrder(neu.shoes.dto.OrderDTO)
	 */
	@SuppressWarnings("null")
	@Override
	public Response<OrderDTO> saveNewOrder(OrderDTO orderDTO) {	
		LOGGER.info("create new order");
		Response<OrderDTO> response = new Response<>();
		OrderEntity orderEntity = new OrderEntity();	
		orderDTO.setDeleted(Constant.notDeleted);
		orderDTO.setStatus(Constant.confirm);
		orderEntity = orderConvert.toEntity(orderDTO);
		UserEntity userEntity = userRepository.getUserByPhone(orderDTO.getPhone());
		orderEntity.setUserOrder(userEntity);
		TrasactionEntity trasactionEntity =  transactionRepository.findTransactionType(orderDTO.getTransactionType());
		orderEntity.setTransaction(trasactionEntity);
		orderEntity = orderRepository.save(orderEntity);	
		response.success();
		response.setItem(orderConvert.toDTO(orderEntity));
		return response;
	}

	/*
	 * @see neu.shoes.service.IOrderService#totalItem()
	 */
	@Override
	public int totalItem() {
		return (int) orderRepository.count();
	}

	/*
	* @see neu.shoes.service.IOrderService#deleteOrder(long)
	*/
	@Override
	public Response<OrderDTO> deleteOrder(long id) {
		LOGGER.info("delete order by id");
		Response<OrderDTO> respone = new Response<>();
		orderRepository.deleteOrder(id);
		respone.deletedDone();
		return respone;
	}

	/*
	* @see neu.shoes.service.IOrderService#getListOrder()
	*/
	@Override
	public Response<List<OrderDTO>> getListOrder() {
		LOGGER.info("get list order");
		Response<List<OrderDTO>> response = new Response<>();
		List<OrderDTO> results = new ArrayList<>();
		List<OrderEntity> orderEntities = orderRepository.getListOrder();
		for (OrderEntity orderEntity : orderEntities) {
			OrderDTO orderDTO = orderConvert.toDTO(orderEntity);
			results.add(orderDTO);
		}
		response.success();
		response.setItem(results);
		return response;
	}

}
