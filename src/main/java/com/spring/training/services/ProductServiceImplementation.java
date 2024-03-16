package com.spring.training.services;

import com.spring.training.model.Product;
import com.spring.training.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public void addNewProduct(Product product) {
         productRepository.save(product);
    }

    @Override
    public List<Product> retrieveProducts() {
        return productRepository.findAll();
    }
}
