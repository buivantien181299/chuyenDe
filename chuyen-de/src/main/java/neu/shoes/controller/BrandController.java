/**
 * 
 */
package neu.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import neu.shoes.dto.BrandShoesDTO;
import neu.shoes.service.impl.BrandService;

/**
 * @author TienBV
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/brandshoes")
public class BrandController {

	@Autowired
	private BrandService brandService;

	// Lấy toàn bộ danh sách thương hiệu giày.
	@GetMapping()
	public ResponseEntity<List<BrandShoesDTO>> getList() {
		List<BrandShoesDTO> brandShoesDTO = brandService.getListBrandShoes();
		return new ResponseEntity<>(brandShoesDTO,HttpStatus.OK);
	}
	

	// Lấy thương hiệu giày theo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<BrandShoesDTO> getBrandShoes(@PathVariable(name = "id") long id) {
		BrandShoesDTO brandShoes = brandService.getBrandShoesById(id);
		return new ResponseEntity<>(brandShoes,HttpStatus.OK);
	}

	// Thêm thương hiệu giày
	@PostMapping
	public ResponseEntity<BrandShoesDTO> createBrandShoes(@RequestBody BrandShoesDTO model) {
		brandService.saveNewBrandShoes(model);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	// Sửa thương hiệu giày
	@PutMapping(value = "/{id}")
	public ResponseEntity<BrandShoesDTO> updateBrandShoes(@RequestBody BrandShoesDTO model, @PathVariable("id") long id) {

		BrandShoesDTO getBrandShoes = brandService.getBrandShoesById(id);
		if (getBrandShoes != null) {
			// model.setId(id);
			brandService.saveNewBrandShoes(model);
			return new ResponseEntity<>(model, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Xóa giày
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<BrandShoesDTO> deleteQuestion(@PathVariable(name = "id") long id) {
		BrandShoesDTO getBrandShoes = brandService.getBrandShoesById(id);
		if (getBrandShoes != null) {
			brandService.deleteShoes(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
