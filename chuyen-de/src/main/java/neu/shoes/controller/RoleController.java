/**
 * 
 */
package neu.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import neu.shoes.dto.RoleDTO;
import neu.shoes.service.impl.RoleService;

/**
 * @author TienBV
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	// Lấy .
		@GetMapping()
		public ResponseEntity<List<RoleDTO>> getListRole() {
			List<RoleDTO> roleDTOs = roleService.getListRole();
			return new ResponseEntity<>(roleDTOs,HttpStatus.OK);
		}

}
