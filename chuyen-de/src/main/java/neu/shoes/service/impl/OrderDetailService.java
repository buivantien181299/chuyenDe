/**
 * 
 */
package neu.shoes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.shoes.Respone.Response;
import neu.shoes.constant.Constant;
import neu.shoes.converter.DetailConvert;
import neu.shoes.dto.DetailDTO;
import neu.shoes.entity.OrderDetailEntity;
import neu.shoes.entity.OrderEntity;
import neu.shoes.repository.DetailOrderRepository;
import neu.shoes.repository.OrderRepository;
import neu.shoes.service.IOrderDetailService;

/**
 * @author TienBV
 *
 */

@Service
@Transactional
public class OrderDetailService implements IOrderDetailService {
	
	@Autowired
	private DetailOrderRepository detailOrderRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
//	@Autowired
//	private ShoesRepository shoesRepository;
	
	@Autowired
	private DetailConvert detailConvert;

	/*
	* @see neu.shoes.service.IOrderDetailService#getListOrderDetail()
	*/
	@Override
	public Response<List<DetailDTO>> getListOrderDetail() {
		Response<List<DetailDTO>> response = new Response<>();
		List<DetailDTO> results = new ArrayList<>();
		List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
		orderDetailEntities = detailOrderRepository.getListOrderDetail();	
		for (OrderDetailEntity x : orderDetailEntities) {
			DetailDTO detailDTO = detailConvert.toDTO(x);
			results.add(detailDTO);
		}
		response.success();
		response.setItem(results);
		return response;
	}

	/*
	* @see neu.shoes.service.IOrderDetailService#saveNewOrder(neu.shoes.dto.DetailDTO)
	*/
	@SuppressWarnings("null")
	@Override
	public Response<DetailDTO> saveNewDetail(DetailDTO model) {
		Response<DetailDTO> response = new Response<>();
		model.setDeleted(Constant.notDeleted);
		//ShoesEntity shoesEntity = shoesRepository.getShoesById(model.getShoesID());
		OrderDetailEntity orderDetailEntity  = detailConvert.toEntity(model);
		OrderEntity orderEntity =  orderRepository.getNewOrder();
		orderDetailEntity.setOrderEntity(orderEntity);
		detailOrderRepository.save(orderDetailEntity);
		response.success();
		response.setItem(detailConvert.toDTO(orderDetailEntity));
		return response;
	}

}
