/**
 * 
 */
package neu.shoes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.shoes.converter.TranConverter;
import neu.shoes.dto.TransactionDTO;
import neu.shoes.entity.TrasactionEntity;
import neu.shoes.repository.TransactionRepository;
import neu.shoes.service.ITransactionService;

/**
 * @author TienBV
 *
 */

@Service
@Transactional
public class TransactionService implements ITransactionService {
	
	private static final Logger LOGGER = Logger.getLogger(TransactionService.class);

	
	@Autowired
	private TranConverter tranConverter;
	
	@Autowired
	private TransactionRepository transactionRepository;

	/*
	* @see neu.shoes.service.ITransactionService#getListTransaction()
	*/
	@Override
	public List<TransactionDTO> getListTransaction() {
		
		LOGGER.info("List transaction type");
		
		List<TransactionDTO> result = new ArrayList<>();
		List<TrasactionEntity> trasactionEntity = transactionRepository.findAll();
		for (TrasactionEntity trasactionEntity2 : trasactionEntity) {
			TransactionDTO transactionDTO = tranConverter.toDTO(trasactionEntity2);
			result.add(transactionDTO);
		}
		return result;
	}

	/*
	* @see neu.shoes.service.ITransactionService#saveNewTran(neu.shoes.dto.TransactionDTO)
	*/
	@Override
	public TransactionDTO saveNewTran(TransactionDTO transactionDTO) {
		TrasactionEntity trasactionEntity =  new TrasactionEntity();
		if(transactionDTO.getId() != null) {
			LOGGER.info("update tran by id");
			TrasactionEntity oldTrasactionEntity = transactionRepository.findOne(transactionDTO.getId());
			trasactionEntity = tranConverter.toEntity(transactionDTO, oldTrasactionEntity);
		}
		else {
			LOGGER.info("create new tran");
			trasactionEntity = tranConverter.toEntity(transactionDTO);
		}
		
		trasactionEntity = transactionRepository.save(trasactionEntity);
		return tranConverter.toDTO(trasactionEntity);
	}

	/*
	* @see neu.shoes.service.ITransactionService#deleteTran(long)
	*/
	@Override
	public void deleteTran(long id) {
		LOGGER.info("delete tran by id");
		transactionRepository.delete(id);
	}

}
