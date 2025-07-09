package com.StockManager.Services;

import com.StockManager.Exceptions.InsufficientQuantityException;
import com.StockManager.Exceptions.MovementNotFound;
import com.StockManager.Exceptions.ProdutNotFoudException;
import com.StockManager.Model.DTO.MovementDTO;
import com.StockManager.Model.DTO.ProductDTO;
import com.StockManager.Model.HandlingType;
import com.StockManager.Model.Movements;
import com.StockManager.Model.Product;
import com.StockManager.Repositories.MovementsRepository;
import com.StockManager.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import  static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static io.restassured.RestAssured.when;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
public class MovementsServiceTest {

    @Mock
    private ProductRepository pRepository;

    @Mock
    private MovementsRepository mRepository;

    @InjectMocks
    private MovementsService service;

    @Test
    void createMovement_whenValidInputInputType_shouldReturnDTOAndUpdateStock() {

        MovementDTO dto = new MovementDTO(1L, 12L, HandlingType.INPUT, 10);
        Product existingProduct = new Product(12L, "Produto", "desc", 20, 123456789L);
        Movements movementSaved = new Movements(null, 12L, HandlingType.INPUT, 10);

        when(pRepository.findById(12L)).thenReturn(Optional.of(existingProduct));
        when(mRepository.save(any(Movements.class))).thenReturn(movementSaved);


        MovementDTO result = service.create(dto);


        assertNotNull(result);
        assertEquals(12L, result.getProductId());
        assertEquals(HandlingType.INPUT, result.getType());
        assertEquals(10, result.getAmount());


        verify(pRepository).save(argThat(prod -> prod.getAmount() == 30));
    }

    @Test
    void createMovement_whenInsufficientStock_shouldThrowException() {

        MovementDTO dto = new MovementDTO(1L, 12L, HandlingType.OUTPUT, 50);
        Product existingProduct = new Product(12L, "Produto", "desc", 20, 123456789L);

        when(pRepository.findById(12L)).thenReturn(Optional.of(existingProduct));


        assertThrows(InsufficientQuantityException.class, () -> service.create(dto));
    }

    @Test
    void createMovement_whenProductNotFound_shouldThrowException() {

        MovementDTO dto = new MovementDTO(1L, 99L, HandlingType.INPUT, 10);

        when(pRepository.findById(99L)).thenReturn(Optional.empty());


        assertThrows(ProdutNotFoudException.class, () -> service.create(dto));
    }

    @Test
    void findByIdMovements_whenMovementsExists_shouldReturnMovements() {

        Movements movements = new Movements(5L, 5L, HandlingType.INPUT, 32 );
        when(mRepository.findById(5L)).thenReturn(Optional.of(movements));
        MovementDTO result = service.findById(5L);

        assertEquals(movements.getAmount(), result.getAmount());

        assertNotNull(result);
        assertEquals(5L, result.getId());
        assertEquals(HandlingType.INPUT, result.getType());
        assertEquals(32, result.getAmount());
    }

    @Test
    void findByIdMovements_whenMovementsNotFound_shouldThrowMovementsNotFound(){
        when(mRepository.findById(3L)).thenReturn(Optional.empty());

        assertThrows(MovementNotFound.class, () -> service.findById(3L));
    }

    @Test
    void deleteByIdMovements_whenMovementsExists_shouldReturnDelete() {
        service.delete(5L);

        verify(mRepository).deleteById(5L);

    }

    @Test
    void deleteByIdMovements_whenMovementsNotFound_shouldThrowException() {
        Long id = 66L;

        doThrow(new MovementNotFound("Movimentação não encontrada!!")).when(mRepository).deleteById(id);

        assertThrows(MovementNotFound.class , () -> service.delete(id));
        verify(mRepository).deleteById(id);

    }

}
