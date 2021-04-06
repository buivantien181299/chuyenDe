/**
 * 
 */
package neu.shoes.converter;

import org.springframework.stereotype.Component;

import neu.shoes.dto.TransactionDTO;
import neu.shoes.entity.TrasactionEntity;

/**
 * @author TienBV
 *
 */

@Component
public class TranConverter {
	
	/**
	* This method convert tran from DTO to Entity .
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
	public TrasactionEntity toEntity (TransactionDTO transactionDTO) {
		
		TrasactionEntity trasactionEntity = new TrasactionEntity();
		
		trasactionEntity.setTransactionType(transactionDTO.getTransactionType());
		trasactionEntity.setTransactionName(transactionDTO.getTransactionName());
		trasactionEntity.setDeleted(transactionDTO.getDeleted());
		return trasactionEntity;
	}
	
	

	/**
	* This method convert tran from DTO to Entity .
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
	public TrasactionEntity toEntity (TransactionDTO transactionDTO,TrasactionEntity trasactionEntity) {
		

		trasactionEntity.setTransactionType(transactionDTO.getTransactionType());
		trasactionEntity.setTransactionName(transactionDTO.getTransactionName());
		
		return trasactionEntity;
	}
	
	/**
	* This method convert tran from Entity to DTO.
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
	public TransactionDTO toDTO(TrasactionEntity trasactionEntity) {
		
		TransactionDTO transactionDTO = new TransactionDTO();
		
		if(trasactionEntity.getId() != null) {
			transactionDTO.setId(trasactionEntity.getId());
		}
		
		transactionDTO.setTransactionType(trasactionEntity.getTransactionType());
		transactionDTO.setTransactionName(trasactionEntity.getTransactionName());
		transactionDTO.setCreatedBy(trasactionEntity.getCreatedBy());
		transactionDTO.setCreatedDate(trasactionEntity.getCreatedDate());
		transactionDTO.setModifiedBy(trasactionEntity.getModifiedBy());
		transactionDTO.setModifiedDate(trasactionEntity.getModifiedDate());
		transactionDTO.setDeleted(trasactionEntity.getDeleted());	
		return transactionDTO;
	}
	

}
