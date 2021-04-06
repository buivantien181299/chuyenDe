/**
 * 
 */
package neu.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import neu.shoes.entity.OrderEntity;

/**
 * @author TienBV
 *
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	// lay order moi
	@Query(value = " SELECT o.* FROM `order` o WHERE o.deleted = 'N' order by o.id desc limit 1", nativeQuery = true)
	OrderEntity getNewOrder();

	// update
	@Modifying
	@Query(value = "update `order` o set o.deleted = 'Y' where o.id = ?1 ", nativeQuery = true)
	void deleteOrder(Long id);

	// Lấy tất cả danh sách user
	@Query(value = "SELECT o.* FROM `order` o WHERE o.deleted = 'N'", nativeQuery = true)
	List<OrderEntity> getListOrder();

}
