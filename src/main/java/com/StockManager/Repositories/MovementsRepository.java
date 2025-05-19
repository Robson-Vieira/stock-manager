package com.StockManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StockManager.Model.Movements;

import java.util.List;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Long> {

	//pesquisa pelo produto
	//pesquisa por data(Intervalo de tempo)
	//pesquisa por tipo de movimentacão
     List<Movements> findByType(String type);
}
