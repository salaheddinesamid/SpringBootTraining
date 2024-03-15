package com.spring.training.controller;

import com.spring.training.exception.ProductNotFoundException;
import com.spring.training.model.Product;
import com.spring.training.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("products")
public class ProductsController {
    @Autowired
    ProductRepository productRepository;
    @PostMapping("/add")
    Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @GetMapping("")
    List<Product> getAll(){
        return productRepository.findAll();
    }
    @PostMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException();
        }
        return new ResponseEntity<>("Product Found", HttpStatus.OK);
    }


}

