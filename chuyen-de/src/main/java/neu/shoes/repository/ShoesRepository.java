/**
 * 
 */
package neu.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import neu.shoes.entity.BrandShoesEntity;
import neu.shoes.entity.ShoesEntity;

/**
 * @author TienBV
 *
 */
public interface ShoesRepository extends JpaRepository<ShoesEntity, Long> {

	List<ShoesEntity> findBybrandShoes(BrandShoesEntity brandShoesEntity);
	
	@Query(value = "select s.*, od.id, o.id from shoes s join order_detail od on s.id = od.shoesid  join `order` o on o.id = od.orderid where s.deleted = 'N' order by total_quantity desc limit 8",
			nativeQuery = true)
	List<ShoesEntity> listBestShowShoes();
	
	ShoesEntity findByShoesName(String shoesName);
	
	// Lấy toàn bộ giày trong data.
	@Query(
			  value = "SELECT s.* FROM shoes s WHERE s.deleted = 'N'", 
			  nativeQuery = true)
	List<ShoesEntity> findAllListShoes();
	
	
	// Xóa giày
	@Modifying
	@Query(
			value = "update shoes s set s.deleted = 'Y' where s.id = ?1 " , 
			nativeQuery = true)
	void deletedShoes(Long id);
	
	// Lấy shoes theo id
	@Query(
			  value = "SELECT s.* FROM shoes s WHERE s.deleted = 'N' and s.id = ?1", 
			  nativeQuery = true)
	ShoesEntity getShoesById(Long id);
	
	// Lấy shoes theo color
	
	@Query(
			  value = "SELECT s.* FROM shoes s WHERE s.deleted = 'N' and s.color like %?1% ", 
			  nativeQuery = true)
	List<ShoesEntity> getShoesByColor(String color);
		
}
