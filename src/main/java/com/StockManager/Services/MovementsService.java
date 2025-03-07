package com.StockManager.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.StockManager.Model.Movements;
import com.StockManager.Repositories.MovementsRepository;

public class MovementsService {

	@Autowired
	private MovementsRepository mRepository; 
	
	public List<Movements> findAll() {
		return mRepository.findAll();
	}

	public Optional<Movements> findById(Long id) {
		return mRepository.findById(id); //Implementar excessao
	}

	public Movements create(Movements dto) {
		return mRepository.save(dto);
		
	}

	public Movements update(Movements dto) {
		return mRepository.save(dto);
	}
	
	public void delete (Long id) {
		mRepository.deleteById(id);
	}
}
