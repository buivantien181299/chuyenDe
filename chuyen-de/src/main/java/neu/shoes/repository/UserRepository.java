/**
 * 
 */
package neu.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import neu.shoes.entity.UserEntity;

/**
 * @author TienBV
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	//UserEntity findOneByUserName(String userName);
	
	@Query(
			  value = "SELECT u.* FROM user u WHERE u.phone = ?1 and u.deleted = 'N'", 
			  nativeQuery = true)
	UserEntity getUserByPhone(String phone);
	
	@Query(
			  value = "SELECT u.role_id FROM user u WHERE u.phone = ?1 and u.deleted = 'N'", 
			  nativeQuery = true)
	Long findByPhone(String phone);
	
	
	// Lấy tất cả danh sách user
	@Query(
			  value = "SELECT u.* FROM user u WHERE u.deleted = 'N'", 
			  nativeQuery = true)
	List<UserEntity> findAllUserEntity();
	
	
	// xem số điện thoại đã có trong database chưa?
	@Query(
			value = "select count(u.id) as tong  from user u where u.phone = ?1 and u.deleted = 'N'" , 
			  nativeQuery = true)
	int countPhoneExists(String phone);
	
	// xem số điện thoại đã có trong database chưa?
		@Query(
				value = "select u.id  from user u where u.phone = ?1  and u.deleted = 'N'" , 
				  nativeQuery = true)
	long selectIdPhone(String phone);
	// update 
	@Modifying
	@Query(
			value = "update user u set u.deleted = 'Y' where u.id = ?1 " , 
			nativeQuery = true)
	void deletedUser(Long id);

}
