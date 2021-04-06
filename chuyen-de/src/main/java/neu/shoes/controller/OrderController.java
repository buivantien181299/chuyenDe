/**
 * 
 */
package neu.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import neu.shoes.controller.output.OrderOutPut;
import neu.shoes.dto.OrderDTO;
import neu.shoes.service.impl.OrderService;

/**
 * @author TienBV
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// Lấy toàn bộ danh sách order.
	@GetMapping
	public OrderOutPut showListOrder(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		OrderOutPut result = new OrderOutPut();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(orderService.getListOrder(pageable));
		result.setTotalPage((int) Math.ceil((double) (orderService.totalItem()) / limit));
		return result;
	}

	// Get order don't paging
	@GetMapping(value = "/getListOrder")
	public ResponseEntity<?> getOrderById() {
		return new ResponseEntity<>(orderService.getListOrder(), HttpStatus.OK);
	}

	/*
	 * // Lấy order theo id
	 * 
	 * @GetMapping(value = "/{id}") public OrderDTO getShoes(@PathVariable(name =
	 * "id") long id) { return orderService.getOrderById(id); }
	 */

	// Lấy order theo id
//		@GetMapping(value = "/getListOrder")
//		public ResponseEntity<List<OrderDTO>> getOrderById() {
//			List<OrderDTO> results = orderService.getListOrder();
//			return new ResponseEntity<>(results ,HttpStatus.OK);
//		}
	// Thêm order
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody OrderDTO model) {

		return new ResponseEntity<>(orderService.saveNewOrder(model), HttpStatus.OK);
	}

	// Xóa order
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable(name = "id") long id) {

		return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);

	}

}
