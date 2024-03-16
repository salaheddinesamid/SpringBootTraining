package com.spring.training.services;

import com.spring.training.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public abstract void addNewProduct(Product product);
    public abstract List<Product> retrieveProducts();
}
