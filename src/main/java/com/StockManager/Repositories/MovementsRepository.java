package com.StockManager.Repositories;

import com.StockManager.Model.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Long>{

    List<Movements> findByType(String type);
}
