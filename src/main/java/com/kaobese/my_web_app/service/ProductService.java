package com.kaobese.my_web_app.service;

import com.kaobese.my_web_app.model.Product;
import com.kaobese.my_web_app.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    private List<Product> products = new ArrayList<Product>(Arrays.asList(
//            new Product(100, "iPhone", 999),
//            new Product(101, "Macbook air", 1000),
//            new Product(102, "Macbook pro", 1500),
//            new Product(103, "iPad pro", 1500),
//            new Product(104, "iPad air", 600)
//    ));

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProductbyId(int prodId) {
        repo.deleteById(prodId);
    }
}
