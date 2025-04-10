package com.StockManager.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Exceptions.ProdutNotFoudException;
import com.StockManager.Model.Product;
import com.StockManager.Model.DTO.ProductDTO;
import com.StockManager.Repositories.ProductRepository;

public class ProductService {

	@Autowired
	private ProductRepository pRepository;

	public ProductDTO findById(Long id) {
		Product entity = pRepository.findById(id).orElseThrow(() -> new ProdutNotFoudException("Produto não encontrado!"));
		return ModelMapperConfig.parseObjects(entity, ProductDTO.class) ;
	}

	public List<ProductDTO> findAll() {
		return ModelMapperConfig.parseList(pRepository.findAll(), ProductDTO.class);
	}

	public ProductDTO create(ProductDTO dto) {
		Product entity = ModelMapperConfig.parseObjects(dto, Product.class);
		return ModelMapperConfig.parseObjects(pRepository.save(entity), ProductDTO.class);
	}

	public ProductDTO update(ProductDTO dto) {
		Product entity = pRepository.findById(dto.getId()).orElseThrow(() -> new ProdutNotFoudException("Produto não encontrado!"));
		entity.setName(dto.getName());
		entity.setAmount(dto.getAmount());
		entity.setDescription(dto.getDescription());
		entity.setHeritage(dto.getHeritage());
		
		return ModelMapperConfig.parseObjects(pRepository.save(entity), ProductDTO.class) ;
	}

	public void delete(Long id) {
		 pRepository.deleteById(id);
	}
}
