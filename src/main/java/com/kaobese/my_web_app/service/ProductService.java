package com.kaobese.my_web_app.service;

import com.kaobese.my_web_app.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>(Arrays.asList(
            new Product(100, "iPhone", 999),
            new Product(101, "Macbook air", 1000),
            new Product(102, "Macbook pro", 1500),
            new Product(103, "iPad pro", 1500),
            new Product(104, "iPad air", 600)
    ));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int id){
        return products.stream().filter(product -> product.getProdId() == id)
                .findFirst()
                .orElse(new Product(0, "No Item", 0));
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int id = 0;
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getProdId() == prod.getProdId())
                id = i;
        }
        products.set(id, prod);
    }

    public void deleteProductbyId(int prodId) {
        int id = 0;
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getProdId() == prodId)
                id = i;
        }
        products.remove(id);
    }
}
