/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import neu.shoes.Respone.Response;
import neu.shoes.dto.DetailDTO;


/**
 * @author TienBV
 *
 */
public interface IOrderDetailService {
	/*
	 * Lấy danh sách detail order.
	 * 
	 * @return List<BrandShoesDTO>
	 * */
	Response<List<DetailDTO>> getListOrderDetail();
	
	/*
	 * Tạo mới order detail.
	 * 
	 * @param ShoesDTO.
	 * 
	 * @return ShoesDTO.
	 * 
	 */
	Response<DetailDTO> saveNewDetail(DetailDTO detailDTO);
}
