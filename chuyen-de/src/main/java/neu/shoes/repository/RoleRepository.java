/**
 * 
 */
package neu.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.shoes.entity.RoleEntity;

/**
 * @author TienBV
 *
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneByCode(String code);
	RoleEntity findByUsers(RoleEntity roleEntity);
}
