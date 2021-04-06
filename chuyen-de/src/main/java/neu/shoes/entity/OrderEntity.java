/**
 * 
 */
package neu.shoes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author TienBV
 *
 */
@Entity
@Table(name = "`order`")
public class OrderEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "userName")
	private String userName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "totalQuantity")
	private Integer totalQuantity;

	@Column(name = "totalMoney")
	private Integer totalMoney;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "transID")
	private TrasactionEntity transaction;

	@ManyToOne
	@JoinColumn(name = "userID")
	private UserEntity userOrder;

	@OneToMany(mappedBy = "orderEntity",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetailEntity> orderShoes = new ArrayList<>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public TrasactionEntity getTransaction() {
		return transaction;
	}

	public void setTransaction(TrasactionEntity transaction) {
		this.transaction = transaction;
	}

	public UserEntity getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserEntity userOrder) {
		this.userOrder = userOrder;
	}

	public List<OrderDetailEntity> getOrderShoes() {
		return orderShoes;
	}

	public void setOrderShoes(List<OrderDetailEntity> orderShoes) {
		this.orderShoes = orderShoes;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
