package com.ecomert.repo;

import com.ecomert.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingOrBrandContaining(String name, String brand, Pageable pageable); 
}
