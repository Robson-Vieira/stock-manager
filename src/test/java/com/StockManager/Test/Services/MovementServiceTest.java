package com.StockManager.Test.Services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.StockManager.Model.HandlingType;
import com.StockManager.Model.Movements;
import com.StockManager.Model.Product;
import com.StockManager.Model.DTO.MovementDTO;
import com.StockManager.Repositories.MovementsRepository;
import com.StockManager.Services.MovementsService;

@ExtendWith(MockitoExtension.class)
public class MovementServiceTest {

	@InjectMocks
	private MovementsService service;
	
	@Mock
	private MovementsRepository repository;
	
	@Test
	void retornaMovimentoQuandoExistirId() {
		Long id =1L;
		Product product = new Product(id,"Celular","Description",2,81292L);
		
		Movements moviment = new Movements(id,product,HandlingType.INPUT,10,new Date());
		
		when(repository.findById(id)).thenReturn(Optional.of(moviment));
		
		Optional<MovementDTO> result = service.findById(id);
		assertNotNull(result);
		assertEquals(id, result.get().getId());
		assertEquals("Celular", result.get().getProduct().getName());
	}
	
	
}
