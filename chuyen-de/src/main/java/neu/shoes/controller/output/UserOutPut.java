/**
 * 
 */
package neu.shoes.controller.output;

import java.util.ArrayList;
import java.util.List;

import neu.shoes.dto.UserDTO;

/**
 * @author TienBV
 *
 */
public class UserOutPut {
	private int page;
	private int totalPage;
	private List<UserDTO> listResult = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the listResult
	 */
	public List<UserDTO> getListResult() {
		return listResult;
	}

	/**
	 * @param listResult the listResult to set
	 */
	public void setListResult(List<UserDTO> listResult) {
		this.listResult = listResult;
	}

}
