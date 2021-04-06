/**
 * 
 */
package neu.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import neu.shoes.entity.TrasactionEntity;

/**
 * @author TienBV
 *
 */
public interface TransactionRepository extends JpaRepository<TrasactionEntity, Long> {
	
	@Query(
			  value = "SELECT tr.* FROM transactions tr WHERE tr.transaction_type = ?1 and tr.deleted = 'N'", 
			  nativeQuery = true)
	TrasactionEntity findTransactionType(String transactionType);
}
