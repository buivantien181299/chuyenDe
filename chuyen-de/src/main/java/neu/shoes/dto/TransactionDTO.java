/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */
public class TransactionDTO extends AbstractDTO<TransactionDTO> {

	private String transactionType;
	private String transactionName;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionName
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * @param transactionName the transactionName to set
	 */
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

}
