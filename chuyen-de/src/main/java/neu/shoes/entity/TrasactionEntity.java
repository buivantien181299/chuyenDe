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
@Table(name = "transactions")
public class TrasactionEntity extends BaseEntity {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "transactionType")
	private String transactionType;
	
	@Column(name = "transactionName")
	private String transactionName;


	@OneToMany(mappedBy = "transaction")
	private List<OrderEntity> order = new ArrayList<>();

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public List<OrderEntity> getOrders() {
		return order;
	}

	public void setOrders(List<OrderEntity> order) {
		this.order = order;
	}
	
	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	
	
}
