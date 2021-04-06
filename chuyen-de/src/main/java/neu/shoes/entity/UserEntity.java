/**
 * 
 */
package neu.shoes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author TienBV
 *
 */
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "userName")
	private String userName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userID"),
	 * inverseJoinColumns = @JoinColumn(name = "roleID")) private List<RoleEntity>
	 * roles = new ArrayList<>();
	 */
	
	@ManyToOne
    @JoinColumn(name = "CardID")
    private CardEntity cardEntity;
	
	
	@OneToMany(mappedBy = "userOrder")
	private List<OrderEntity> order = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity roleEntity;

	public String getUserName() {
		return userName;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CardEntity getCardEntity() {
		return cardEntity;
	}

	public void setCardEntity(CardEntity cardEntity) {
		this.cardEntity = cardEntity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public List<RoleEntity> getRoles() { return roles; }
	 * 
	 * public void setRoles(RoleEntity role) { roles.add(role); }
	 */

	public List<OrderEntity> getOrders() {
		return order;
	}

	public void setOrders(List<OrderEntity> order) {
		this.order = order;
	}
	
	
}
