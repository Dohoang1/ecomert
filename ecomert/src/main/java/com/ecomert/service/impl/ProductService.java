package com.ecomert.service.impl;

import com.ecomert.model.Product;
import com.ecomert.repo.IProductRepo;
import com.ecomert.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void remove(Long id) {
        iProductRepo.deleteById(id);
    }
}
