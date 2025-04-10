package com.StockManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StockManager.Model.DTO.ProductDTO;
import com.StockManager.Services.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@GetMapping("/{id}")
	public ProductDTO findProduct(@RequestParam Long id) {
		return pService.findById(id);
	}
	
	@GetMapping()
	public List<ProductDTO> findAll() {
		return pService.findAll();
	}
	
	@PostMapping()
	public ProductDTO createProduct(@RequestBody ProductDTO dto) {
		
		return pService.create(dto);
	}
	
	@PutMapping()
	public ProductDTO updateProduct(@RequestBody ProductDTO dto) {
		
		return pService.update(dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete( @PathVariable Long id) {
		pService.delete(id);
	}
}
