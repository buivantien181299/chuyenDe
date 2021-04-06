/**
 * 
 */
package neu.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.shoes.entity.BrandShoesEntity;
import neu.shoes.entity.ShoesEntity;

/**
 * @author TienBV
 *
 */
public interface BrandShoesRepository extends JpaRepository<BrandShoesEntity, Long> {
	BrandShoesEntity findOneByBrand(String brand);
	
	BrandShoesEntity findByShoes(ShoesEntity shoesEntity);
}
