/**
 * 
 */
package neu.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import neu.shoes.entity.OrderDetailEntity;

/**
 * @author TienBV
 *
 */
public interface DetailOrderRepository extends JpaRepository<OrderDetailEntity, Long> {

	@Query(
			  value = "SELECT od.* FROM order_detail od WHERE od.deleted = 'N'", 
			  nativeQuery = true)
	List<OrderDetailEntity> getListOrderDetail();
	
}
