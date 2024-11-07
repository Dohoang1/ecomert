package com.ecomert.service;

import com.ecomert.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGenerateService<Product>{
    Page<Product> findAll(Pageable pageable);
    Page<Product> searchByNameOrBrand(String keyword, Pageable pageable);
}
