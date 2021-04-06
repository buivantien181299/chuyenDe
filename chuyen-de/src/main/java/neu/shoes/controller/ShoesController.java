/**
 * 
 */
package neu.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import neu.shoes.Respone.Response;
import neu.shoes.controller.output.ShoesOutPut;
import neu.shoes.dto.ShoesDTO;
import neu.shoes.service.impl.ShoesService;

/**
 * @author TienBV
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/shoes")
public class ShoesController {

	@Autowired
	private ShoesService shoesService;

	// Lấy toàn bộ danh sách giầy.
	@GetMapping
	public ShoesOutPut showShoes(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		ShoesOutPut result = new ShoesOutPut();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(shoesService.getListShoes(pageable));
		result.setTotalPage((int) Math.ceil((double) (shoesService.totalItem()) / limit));
		return result;
	}

	// Lấy giày theo thương hiệu 
	@GetMapping(value = "/getShoesByID/{id}")
	public List<ShoesDTO> getShoesByID(@PathVariable(name = "id") long id) {
		return shoesService.getShoesByBrand(id);
	}
	
	// Lấy giày đang bán chạy
	@GetMapping(value = "/getShoesBestSell")
	public ResponseEntity<List<ShoesDTO>> getShoesBestSell() { 
		return new ResponseEntity<List<ShoesDTO>>(shoesService.getListShoesBestSell(), HttpStatus.OK); }
	
	
	// Lấy giày không phân trang
		@GetMapping(value = "/getListShoes")
		public ResponseEntity<Response<List<ShoesDTO>>> getListShoes() { 
			return new ResponseEntity<Response<List<ShoesDTO>>>(shoesService.getListShoes(), HttpStatus.OK); }
 


	// Lấy giày theo id
	@GetMapping(value = "/{id}")
	public ShoesDTO getShoes(@PathVariable(name = "id") long id) {
		return shoesService.getShoesById(id);
	}

	// Thêm giày
	@PostMapping
	public ResponseEntity<ShoesDTO> createShoes(@RequestBody ShoesDTO model) {
		shoesService.saveNewShoes(model);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	// Sửa giày
	@PutMapping(value = "/{id}")
	public ResponseEntity<ShoesDTO> updateNew(@RequestBody ShoesDTO model, @PathVariable("id") long id) {
			model.setId(id);
			shoesService.saveNewShoes(model);
			return new ResponseEntity<>(model, HttpStatus.OK);
	}

	// Xóa giày
	@PutMapping(value = "/deleted/{id}")
	public ResponseEntity<?> deletedShoes(@PathVariable("id") long id){
		return new ResponseEntity<>(shoesService.deletedShoes(id), HttpStatus.OK);
	}
	
	//Lấy shoes by color
	
	@GetMapping(value = "/getShoesByColor/{color}")
	public ResponseEntity<?> getShoesBestSell(@PathVariable("color") String color) { 
		return new ResponseEntity<>(shoesService.getShoesByColor(color), HttpStatus.OK); }
}
