/**
 * 
 */
package neu.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.shoes.entity.CardEntity;

/**
 * @author TienBV
 *
 */
public interface CardRepository extends JpaRepository<CardEntity, Long> {
	CardEntity findOneByPin(String Pin);
}
