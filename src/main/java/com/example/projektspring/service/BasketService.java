package com.example.projektspring.service;

import com.example.projektspring.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BasketService {
    private final ProductService productService;

    private final Map<Integer, Product> basket = new HashMap<>();

    public BasketService(ProductService productService) {
        this.productService = productService;
    }

    public void addToBasket(Integer id) {
        Product chosenProduct = productService.findById(id);
        basket.put(getBasketSize() + 1, chosenProduct);
    }

    public Integer getBasketSize() {
        return basket.size();
    }

    public Map<Integer, Product> getBasket() {
        return basket;
    }
}
