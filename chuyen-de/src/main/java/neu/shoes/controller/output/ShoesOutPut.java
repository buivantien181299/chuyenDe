/**
 * 
 */
package neu.shoes.controller.output;

import java.util.ArrayList;
import java.util.List;

import neu.shoes.dto.ShoesDTO;

/**
 * @author TienBV
 *
 */
public class ShoesOutPut {
	private int page;
	private int totalPage;
	private List<ShoesDTO> listResult = new ArrayList<>();

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
	public List<ShoesDTO> getListResult() {
		return listResult;
	}

	/**
	 * @param listResult the listResult to set
	 */
	public void setListResult(List<ShoesDTO> listResult) {
		this.listResult = listResult;
	}

}
