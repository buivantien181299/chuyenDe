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
import neu.shoes.converter.ShoesConverter;
import neu.shoes.dto.ShoesDTO;
import neu.shoes.entity.BrandShoesEntity;
import neu.shoes.entity.ShoesEntity;
import neu.shoes.repository.BrandShoesRepository;
import neu.shoes.repository.ShoesRepository;
import neu.shoes.service.IShoesService;

/**
 * @author TienBV
 *
 */
@Service
@Transactional
public class ShoesService implements IShoesService {

	private static final Logger LOGGER = Logger.getLogger(ShoesService.class);

	@Autowired
	private ShoesRepository shoesRepository;

	@Autowired
	private ShoesConverter shoesConverter;

	@Autowired
	private BrandShoesRepository brandShoesRepository;

	/*
	 * @see neu.shoes.service.IShoesService#getListShoes()
	 */
	@Override
	public List<ShoesDTO> getListShoes(Pageable pageable) {
		LOGGER.info("get list shoes");
		List<ShoesDTO> results = new ArrayList<>();
		List<ShoesEntity> shoesEntities = shoesRepository.findAll(pageable).getContent();
		for (ShoesEntity shoesEntity : shoesEntities) {
			BrandShoesEntity brandShoesEntity = brandShoesRepository.findByShoes(shoesEntity);
			ShoesDTO shoesDTO = shoesConverter.toDTO(shoesEntity);
			shoesDTO.setBrand(brandShoesEntity.getBrand());
			results.add(shoesDTO);
		}
		return results;
	}

	/*
	 * @see neu.shoes.service.IShoesService#createNewShoes(neu.shoes.dto.ShoesDTO)
	 */
	@Override
	public ShoesDTO saveNewShoes(ShoesDTO shoesDTO) {
		ShoesEntity shoesEntity = new ShoesEntity();
		if (shoesDTO.getId() != null) {
			LOGGER.info("update shoes by id");
			ShoesEntity oldShoesEntity = shoesRepository.findOne(shoesDTO.getId());
			shoesEntity = shoesConverter.toEntity(shoesDTO, oldShoesEntity);
		} else {
			LOGGER.info("create new shoes");
			shoesDTO.setDeleted(Constant.notDeleted);
			shoesEntity = shoesConverter.toEntity(shoesDTO);
		}

		BrandShoesEntity brandShoesEntity = brandShoesRepository.findOneByBrand(shoesDTO.getBrand());
		shoesEntity.setBrandShoes(brandShoesEntity);
		shoesEntity = shoesRepository.save(shoesEntity);
		
		return shoesConverter.toDTO(shoesEntity);
	}

	/*
	 * @see neu.shoes.service.IShoesService#getShoesById(java.lang.String)
	 */
	@Override
	public ShoesDTO getShoesById(long id) {
		LOGGER.info("get shoes by id");
		ShoesEntity shoesEntity = shoesRepository.findOne(id);
		BrandShoesEntity brandShoesEntity = brandShoesRepository.findByShoes(shoesEntity);
		ShoesDTO shoesDTO = shoesConverter.toDTO(shoesEntity);
		shoesDTO.setBrand(brandShoesEntity.getBrand());
		return shoesDTO;
	}

	/*
	 * @see neu.shoes.service.IShoesService#totalItem()
	 */
	@Override
	public int totalItem() {
		return (int) shoesRepository.count();
	}

	/*
	 * @see
	 * neu.shoes.service.IShoesService#getShoesByBrand(org.springframework.data.
	 * domain.Pageable)
	 */
	@Override
	public List<ShoesDTO> getShoesByBrand(Long id) {
		LOGGER.info("get list shoes by id");
		BrandShoesEntity brandShoesEntity = brandShoesRepository.findOne(id);
		List<ShoesDTO> results = new ArrayList<>();
		List<ShoesEntity> shoesEntities = shoesRepository.findBybrandShoes(brandShoesEntity);
		for (ShoesEntity shoesEntity : shoesEntities) {
			BrandShoesEntity brandEntity = brandShoesRepository.findByShoes(shoesEntity);		
			ShoesDTO shoesDTO = shoesConverter.toDTO(shoesEntity);
			shoesDTO.setBrand(brandEntity.getBrand());
			results.add(shoesDTO);
		}
		return results;
	}

	/*
	 * @see neu.shoes.service.IShoesService#getListShoesBestSell()
	 */
	@Override
	public List<ShoesDTO> getListShoesBestSell() {
		LOGGER.info("get list shoes best selling");
		List<ShoesDTO> results = new ArrayList<>();
		List<ShoesEntity> shoesEntities = shoesRepository.listBestShowShoes();

		for (ShoesEntity shoesEntity : shoesEntities) {
			BrandShoesEntity brandShoesEntity = brandShoesRepository.findByShoes(shoesEntity);
			ShoesDTO shoesDTO = shoesConverter.toDTO(shoesEntity);
			shoesDTO.setBrand(brandShoesEntity.getBrand());
			results.add(shoesDTO);
		}
		return results;
	}

	/*
	* @see neu.shoes.service.IShoesService#getListShoes()
	*/
	@Override
	public Response<List<ShoesDTO>> getListShoes() {
		Response<List<ShoesDTO>> response = new Response<>();
		LOGGER.info("get list shoes");
		List<ShoesDTO> results = new ArrayList<>();
		List<ShoesEntity> shoesEntities = shoesRepository.findAllListShoes();
		for (ShoesEntity shoesEntity : shoesEntities) {
			BrandShoesEntity brandShoesEntity = brandShoesRepository.findByShoes(shoesEntity);
			ShoesDTO shoesDTO = shoesConverter.toDTO(shoesEntity);
			shoesDTO.setBrand(brandShoesEntity.getBrand());
			results.add(shoesDTO);
		}
		response.success();
		response.setItem(results);
		return response;
	}

	/*
	* @see neu.shoes.service.IShoesService#deletedShoes(long)
	*/
	@Override
	public Response<ShoesDTO> deletedShoes(long id) {
		LOGGER.info("delete shoes by id");
		Response<ShoesDTO> respone = new Response<>();
		shoesRepository.deletedShoes(id);
		respone.deletedDone();
		return respone;
	}

	/*
	* @see neu.shoes.service.IShoesService#getShoesByColor(java.lang.String)
	*/
	@Override
	public Response<List<ShoesDTO>> getShoesByColor(String color) {
		LOGGER.info("delete shoes by color: " + color);
		Response<List<ShoesDTO>> respone = new Response<>();
		List<ShoesDTO> results = new ArrayList<>();
		List<ShoesEntity> shoesEnties = shoesRepository.getShoesByColor(color);
		if(shoesEnties.size() != Constant.zero) {
			respone.success();
			for (ShoesEntity shoesEntity : shoesEnties) {
				BrandShoesEntity brandShoesEntity = brandShoesRepository.findByShoes(shoesEntity);
				ShoesDTO shoesDTO = shoesConverter.toDTO(shoesEntity);
				shoesDTO.setBrand(brandShoesEntity.getBrand());
				results.add(shoesDTO);
			}
			respone.setItem(results);
		}else
		{
			respone.procductNotFound();
		}
		return respone;
	}

}
