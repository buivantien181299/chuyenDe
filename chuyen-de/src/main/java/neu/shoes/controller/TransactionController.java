/**
 * 
 */
package neu.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import neu.shoes.dto.TransactionDTO;
import neu.shoes.service.impl.TransactionService;

/**
 * @author TienBV
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	// Lấy danh sách giao dịch
		@GetMapping
		public List<TransactionDTO> getUser() {
			return transactionService.getListTransaction();
		}
}
