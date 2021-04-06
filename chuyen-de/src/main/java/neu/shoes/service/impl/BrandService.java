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

import neu.shoes.converter.BrandConver;
import neu.shoes.dto.BrandShoesDTO;
import neu.shoes.entity.BrandShoesEntity;
import neu.shoes.repository.BrandShoesRepository;
import neu.shoes.service.IBrandShoesService;

/**
 * @author TienBV
 *
 */

@Service
@Transactional
public class BrandService implements IBrandShoesService {

	private static final Logger LOGGER = Logger.getLogger(BrandService.class);


	@Autowired
	private BrandConver brandConver;

	@Autowired
	private BrandShoesRepository brandShoesRepository;

	/*
	 * @see neu.shoes.service.IBrandShoes#getListBrandShoes()
	 */
	@Override
	public List<BrandShoesDTO> getListBrandShoes() {
		LOGGER.info("List brand shoes");
		List<BrandShoesDTO> results = new ArrayList<>();
		List<BrandShoesEntity> brandEntites = brandShoesRepository.findAll();
		for (BrandShoesEntity brandShoesEntity : brandEntites) {
			BrandShoesDTO branSDTO = brandConver.toDTO(brandShoesEntity);
			results.add(branSDTO);
		}
		return  results;
	}

	/*
	 * @see neu.shoes.service.IBrandShoes#getBrandShoesById(long)
	 */
	@Override
	public BrandShoesDTO getBrandShoesById(long id) {
		LOGGER.info("get brand shoes by id");
		return brandConver.toDTO(brandShoesRepository.findOne(id));
	}

	/*
	 * @see
	 * neu.shoes.service.IBrandShoes#saveNewBrandShoes(neu.shoes.dto.BrandShoesDTO)
	 */
	@Override
	public BrandShoesDTO saveNewBrandShoes(BrandShoesDTO brandShoesDTO) {
		BrandShoesEntity brandShoesEntity =  new BrandShoesEntity();
		if(brandShoesDTO.getId() != null) {
			LOGGER.info("update brand by id");
			BrandShoesEntity oldBrandShoesEntity = brandShoesRepository.findOne(brandShoesDTO.getId());
			brandShoesEntity = brandConver.toEntity(brandShoesDTO, oldBrandShoesEntity);
		}
		else {
			LOGGER.info("create new brand");
			brandShoesEntity = brandConver.toEntity(brandShoesDTO);
		}
		
		brandShoesEntity = brandShoesRepository.save(brandShoesEntity);
		return brandConver.toDTO(brandShoesEntity);
	}

	/*
	 * @see neu.shoes.service.IBrandShoes#deleteShoes(long)
	 */
	@Override
	public void deleteShoes(long id) {
		LOGGER.info("delete shoes by id");
		brandShoesRepository.delete(id);
	}

	/*
	 * @see neu.shoes.service.IBrandShoes#totalItem()
	 */
	@Override
	public int totalItem() {
		
		return (int) brandShoesRepository.count() ;
	}

}
