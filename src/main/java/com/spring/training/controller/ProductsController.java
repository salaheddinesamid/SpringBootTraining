package com.spring.training.controller;

import com.spring.training.exception.ProductExistsException;
import com.spring.training.exception.ProductNotFoundException;
import com.spring.training.model.Product;
import com.spring.training.repository.ProductRepository;
import com.spring.training.services.ProductService;
import com.spring.training.services.ProductServiceImplementation;
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
    ProductService productService;
    @PostMapping("/add")
    ResponseEntity<Object> addProduct(@RequestBody Product product){
        return null;
    }
    @GetMapping("/all")
    ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productService.retrieveProducts(),HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException();
        }
        return new ResponseEntity<>("Product Found", HttpStatus.OK);
    }


}

