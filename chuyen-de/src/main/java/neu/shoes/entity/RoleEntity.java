/**
 * 
 */
package neu.shoes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author TienBV
 *
 */
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	/*
	 * @ManyToMany(mappedBy = "roles") private List<UserEntity> users = new
	 * ArrayList<>();
	 */

	@OneToMany(mappedBy = "roleEntity")
	private List<UserEntity> users = new ArrayList<>();

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public List<UserEntity> getUsers() { return users; }
	 * 
	 * public void setUsers(UserEntity user) { users.add(user); }
	 */

}
