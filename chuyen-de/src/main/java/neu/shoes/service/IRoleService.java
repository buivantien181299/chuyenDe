/**
 * 
 */
package neu.shoes.service;

import java.util.List;

import neu.shoes.dto.RoleDTO;

/**
 * @author TienBV
 *
 */
public interface IRoleService {
	/*
	 * Lấy danh sách role.
	 * 
	 * @return List<RoleDTO>
	 * */
	List<RoleDTO> getListRole();
}
