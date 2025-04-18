package com.StockManager.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StockManager.Model.DTO.MovementDTO;
import com.StockManager.Services.MovementsService;



@RestController
@RequestMapping("/moviments")
public class MovementsController {

	@Autowired
	private MovementsService mService;
	
	@GetMapping()
	public List<MovementDTO> findAllMoviments() {
		return mService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<MovementDTO> findMovement(@RequestParam Long id) {
		return mService.findById(id);
	}
	
	@PostMapping()
	public MovementDTO createMovement(@RequestBody MovementDTO dto) {
		return mService.create(dto);
	}
	
	
	@PutMapping()
	public MovementDTO putMovement(MovementDTO dto) {
		return mService.update(dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovement(@RequestParam Long id){
		mService.delete(id);
	}
}
