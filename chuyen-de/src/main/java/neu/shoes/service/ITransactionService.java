/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import neu.shoes.dto.TransactionDTO;

/**
 * @author TienBV
 *
 */
public interface ITransactionService {
	/*
	 * Lấy danh sách loại giao dịch.
	 * 
	 * @return List<ShoesDTO>
	 * */
	List<TransactionDTO> getListTransaction();
	
	/*
	 * Thêm hoặc sửa loại  giao dịch
	 */
	TransactionDTO saveNewTran(TransactionDTO transactionDTO);
	
	void deleteTran (long id);
}
