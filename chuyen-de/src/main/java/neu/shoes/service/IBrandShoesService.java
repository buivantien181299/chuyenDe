/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import neu.shoes.dto.BrandShoesDTO;

/**
 * @author TienBV
 *
 */
public interface IBrandShoesService {

	/*
	 * Lấy danh sách thương hiệu giày.
	 * 
	 * @return List<BrandShoesDTO>
	 * */
	List<BrandShoesDTO> getListBrandShoes();
	
	 /**
     * Lấy thông tin thương hiệu giày theo id
     * @param id
     * @return Shoes
     */
	BrandShoesDTO getBrandShoesById(long id);
	
	/*
	 * Tạo thương hiệu giày mới hoặc sửa.
	 * 
	 * @param ShoesDTO.
	 * @return ShoesDTO.
	 * 
	 */
	BrandShoesDTO saveNewBrandShoes(BrandShoesDTO brandShoesDTO);
	
	
	/**
     * Xóa giày.
     * @param id
     */
	void deleteShoes(long id);
	
	/**
     * Tong so giay.
     * @return totalItem
     */
	int totalItem();
}
