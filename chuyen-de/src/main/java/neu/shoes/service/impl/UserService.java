/**
 * 
 */
package neu.shoes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.shoes.Respone.Response;
import neu.shoes.constant.Constant;
import neu.shoes.converter.UserConverter;
import neu.shoes.dto.UserDTO;
import neu.shoes.entity.CardEntity;
import neu.shoes.entity.RoleEntity;
import neu.shoes.entity.UserEntity;
import neu.shoes.repository.CardRepository;
import neu.shoes.repository.RoleRepository;
import neu.shoes.repository.UserRepository;
import neu.shoes.service.IUserService;

/**
 * @author TienBV
 *
 */
@Service
@Transactional
public class UserService implements IUserService {

	private static final Logger LOGGER = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private RoleRepository roleRepository;

	/*
	 * @see
	 * neu.shoes.service.IUserService#getListUser(org.springframework.data.domain.
	 * Pageable)
	 */
	@Override
	public List<UserDTO> getListUser(Pageable pageable) {
		LOGGER.info("list user " + pageable);
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> userEntities = userRepository.findAll(pageable).getContent();
		for (UserEntity userEntity : userEntities) {
			UserDTO userDTO = userConverter.toDTO(userEntity);
			results.add(userDTO);
		}
		return results;
	}

	/*
	 * @see neu.shoes.service.IUserService#saveNewUser(neu.shoes.dto.UserDTO)
	 */
	@Override
	public Response<UserDTO> saveNewUser(UserDTO userDTO) {
		Response<UserDTO> respone = new Response<>();
		UserEntity userEntity = new UserEntity();

		if (userDTO.getId() != null) {
			LOGGER.info("update user by " + userDTO.getId());

			long idUser = userRepository.selectIdPhone(userDTO.getPhone());
			if (idUser != userDTO.getId()) {
				respone.accountExists();

			} else {
				respone.success();
				UserEntity oldUserEntity = userRepository.findOne(userDTO.getId());
				userEntity = userConverter.toEntity(userDTO, oldUserEntity);
			}
		} else {
			int countPhone = userRepository.countPhoneExists(userDTO.getPhone());
			LOGGER.info("create new user");
			if (countPhone != Constant.zero) {
				respone.accountExists();
			} else {
				respone.success();
				userDTO.setDeleted(Constant.notDeleted);
				userEntity = userConverter.toEntity(userDTO);
			}
		}

		CardEntity cardEntity = cardRepository.findOneByPin(userDTO.getPin());
		if (cardEntity != null) {
			userEntity.setCardEntity(cardEntity);
		}
		RoleEntity roleEntity = roleRepository.findOneByCode(userDTO.getCode());
		if (roleEntity != null) {
			userEntity.setRoleEntity(roleEntity);
		}
		if (userEntity.getPhone() != null) {
			userRepository.save(userEntity);
		}
		respone.setItem(userConverter.toDTO(userEntity));

		return respone;

	}

	/*
	 * @see neu.shoes.service.IUserService#getUserById(long)
	 */
	@Override
	public UserDTO getUserById(long id) {
		LOGGER.info("get user by " + id);
		return userConverter.toDTO(userRepository.findOne(id));
	}

	/*
	 * @see neu.shoes.service.IUserService#totalUser()
	 */
	@Override
	public int totalUser() {
		return (int) userRepository.count();
	}

	/*
	 * @see neu.shoes.service.IUserService#deleteShoes(long)
	 */
	@Override
	public Response<UserDTO> deleteUser(long id) {
		LOGGER.info("delete user by id");
		Response<UserDTO> respone = new Response<>();
		userRepository.deletedUser(id);
		respone.deletedDone();
		return respone;
	}

	/*
	 * @see neu.shoes.service.IUserService#getUserByPhone(java.lang.String)
	 */
	@Override
	public Response<UserDTO> getUserByPhone(String phone) {
		Response<UserDTO> respone = new Response<>();
		LOGGER.info("get user by " + phone);
		int countPhone = userRepository.countPhoneExists(phone);
		if (countPhone == Constant.zero) {
			respone.accountNotFound();
		} else {
			UserEntity userEntity = userRepository.getUserByPhone(phone);
			Long id = userRepository.findByPhone(phone);
			UserDTO userDTO = userConverter.toDTO(userEntity);
			// Lấy role user
			RoleEntity roleEntity = roleRepository.findOne(id);
			if (roleEntity != null) {
				userDTO.setCode(roleEntity.getCode());
			}
			respone.success();
			respone.setItem(userDTO);
		}

		return respone;
	}

	/*
	 * @see neu.shoes.service.IUserService#getListUser()
	 */
	@Override
	public Response<List<UserDTO>> getListUser() {
		LOGGER.info("list user don't paging");
		Response<List<UserDTO>> respone = new Response<>();
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> userEntities = userRepository.findAllUserEntity();
		for (UserEntity userEntity : userEntities) {
			Long id = userRepository.findByPhone(userEntity.getPhone());
			RoleEntity roleEntity = roleRepository.findOne(id);
			UserDTO userDTO = userConverter.toDTO(userEntity);
			userDTO.setCode(roleEntity.getCode());
			results.add(userDTO);
		}
		respone.success();
		respone.setItem(results);
		return respone;
	}

}
