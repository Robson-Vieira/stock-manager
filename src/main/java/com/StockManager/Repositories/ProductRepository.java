package com.StockManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StockManager.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//pesquisar pelo nome do produto

}
