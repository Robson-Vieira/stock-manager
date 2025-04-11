package com.StockManager.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Exceptions.MovementNotFound;
import com.StockManager.Model.Movements;
import com.StockManager.Model.DTO.MovementDTO;
import com.StockManager.Repositories.MovementsRepository;
@Service
public class MovementsService {

	@Autowired
	private MovementsRepository mRepository; 
	
	
	
	public List<MovementDTO> findAll() {
		
		return ModelMapperConfig.parseList(mRepository.findAll(), MovementDTO.class) ;
	}

	public Optional<MovementDTO> findById(Long id) {
		Movements entity = mRepository.findById(id).orElseThrow(() ->new MovementNotFound("Movimentacão não encontrada!"));
		return Optional.of(ModelMapperConfig.parseObjects(entity, MovementDTO.class))  ; 
	}

	public MovementDTO create(MovementDTO dto) {
		mRepository.save(ModelMapperConfig.parseObjects(dto, Movements.class)) ;
		return dto;
		
	}

	public MovementDTO update(MovementDTO dto) {
		Movements entity = mRepository.findById(dto.getId()).orElseThrow();
		entity.setProduct(dto.getProduct());
		entity.setAmount(dto.getAmount());
		entity.setType(dto.getType());
		entity.setMoveDate(dto.getMoveDate());
		return ModelMapperConfig.parseObjects(mRepository.save(entity), MovementDTO.class);
	}
	
	public void delete (Long id) {
		mRepository.deleteById(id);
	}
}
