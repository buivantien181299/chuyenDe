/**
 * 
 */
package neu.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import neu.shoes.dto.DetailDTO;
import neu.shoes.service.impl.OrderDetailService;

/**
 * @author TienBV
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/detail")
public class DetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	
	// Get list order detail
	@GetMapping()
	public ResponseEntity<?> getList() {
		return new ResponseEntity<>(orderDetailService.getListOrderDetail(),HttpStatus.OK);
	}
	
	// Thêm order
		@PostMapping
		public ResponseEntity<?> createOrder(@RequestBody DetailDTO model) {	
			return new ResponseEntity<>(orderDetailService.saveNewDetail(model), HttpStatus.OK);
		}
}
