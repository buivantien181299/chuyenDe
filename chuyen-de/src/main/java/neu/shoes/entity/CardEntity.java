	/**
 * 
 */
package neu.shoes.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "card")
public class CardEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "pin")
	private String pin;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "expiredDate")
	private Date expiredDate;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "cardEntity")
	private List<UserEntity> user = new ArrayList<>();


	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserEntity> getUser() {
		return user;
	}

	public void setUser(List<UserEntity> user) {
		this.user = user;
	}

	
	
	
}
