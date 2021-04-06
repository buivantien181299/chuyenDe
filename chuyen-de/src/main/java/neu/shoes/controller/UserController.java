/**
 * 
 */
package neu.shoes.controller;

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

import neu.shoes.controller.output.UserOutPut;
import neu.shoes.dto.UserDTO;
import neu.shoes.service.impl.UserService;

/**
 * @author TienBV
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	// Lấy toàn bộ danh sách user.
	@GetMapping
	public UserOutPut showUsers(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		UserOutPut result = new UserOutPut();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(userService.getListUser(pageable));
		result.setTotalPage((int) Math.ceil((double) (userService.totalUser()) / limit));
		return result;
	}

	// Lấy user theo id
	@GetMapping(value = "/{id}")
	public UserDTO getUser(@PathVariable(name = "id") long id) {
		return userService.getUserById(id);
	}
	
	// Lấy user ko paging
	@GetMapping(value = "/getListUser")
	public ResponseEntity<?> getUser() {
		return new ResponseEntity<>(userService.getListUser(), HttpStatus.OK);
	}
	
	// Login user
	@GetMapping(value="/getUserByPhone/{phone}")
	public ResponseEntity<?> getUserByPhone(@PathVariable(name="phone") String phone) {
		return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	}
	
	
	// Thêm user
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDTO model) {
		return new ResponseEntity<>(userService.saveNewUser(model), HttpStatus.OK); 
	}
	
	
	// Sửa user
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		
        model.setId(id);      	
        return new ResponseEntity<>(userService.saveNewUser(model), HttpStatus.OK);
        
	}
   
	
	
	// Xóa giày
	@PutMapping(value="/deletedUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name="id") long id) {
           return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

}
