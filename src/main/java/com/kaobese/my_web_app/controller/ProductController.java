package com.kaobese.my_web_app.controller;


import com.kaobese.my_web_app.model.Product;
import com.kaobese.my_web_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductByID (@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping( "/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProductbyId(prodId);
    }
}
