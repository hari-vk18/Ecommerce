package com.mine.ecom_pro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mine.ecom_pro.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE  " + "LOWER(p.name) LIKE LOWER(CONcat('%', :keyword, '%')) OR "
			+ "LOWER(p.brand) LIKE LOWER(CONcat('%', :keyword, '%')) OR "
			+ "LOWER(p.description) LIKE LOWER(CONcat('%', :keyword, '%')) OR "
			+ "LOWER(p.category) LIKE LOWER(CONcat('%', :keyword, '%'))")
	public List<Product> searchProducts(String keyword);
}
