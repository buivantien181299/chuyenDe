/**
 * 
 */
package neu.shoes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.shoes.converter.RoleConver;
import neu.shoes.dto.RoleDTO;
import neu.shoes.entity.RoleEntity;
import neu.shoes.repository.RoleRepository;
import neu.shoes.service.IRoleService;

/**
 * @author TienBV
 *
 */
@Service
@Transactional
public class RoleService implements IRoleService {
	private static final Logger LOGGER = Logger.getLogger(BrandService.class);


	@Autowired
	private RoleConver roleConver;

	@Autowired
	private RoleRepository roleRepository;


	/*
	* @see neu.shoes.service.IRoleService#getListRole()
	*/
	@Override
	public List<RoleDTO> getListRole() {
		
		LOGGER.info("List role User");
		List<RoleDTO> results = new ArrayList<>();
		List<RoleEntity> listRoleE =  roleRepository.findAll();
		for (RoleEntity roleEntity : listRoleE) {
			RoleDTO roleDTO = roleConver.toDTO(roleEntity);
			results.add(roleDTO);
		}
		return results;
	}

}
