/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import neu.shoes.Respone.Response;
import neu.shoes.dto.ShoesDTO;

/**
 * @author TienBV
 *
 */
public interface  IShoesService {

	/*
	 * Lấy danh sách giày.
	 * 
	 * @return List<ShoesDTO>
	 * */
	List<ShoesDTO> getListShoes(Pageable pageable);
	
	/*
	 * Lấy danh sách giày không phân trang.
	 * 
	 * @return List<ShoesDTO>
	 * */
	Response<List<ShoesDTO>> getListShoes();
	
	 /**
     * Lấy thông tin giày theo id
     * @param id
     * @return Shoes
     */
	ShoesDTO getShoesById(long id);
	
	/*
	 * Tạo giày mới hoặc sửa.
	 * 
	 * @param ShoesDTO.
	 * @return ShoesDTO.
	 * 
	 */
	ShoesDTO saveNewShoes(ShoesDTO shoesDTO);
	
	
	/**
     * Xóa giày.
     * @param id
     */
	Response<ShoesDTO> deletedShoes(long id);
	
	/**
     * Tong so giay.
     * @return totalItem
     */
	int totalItem();
	
	 /**
     * Lấy thông tin giày theo brand
     * @param id
     * @return Shoes
     */
	List<ShoesDTO> getShoesByBrand(Long id);
	
	
	/* Lay thong tin giay ban chay nhat */
	List<ShoesDTO> getListShoesBestSell();
	
	/* Lấy danh sách shoes theo colr */
	Response<List<ShoesDTO>>getShoesByColor(String color);
	
}
