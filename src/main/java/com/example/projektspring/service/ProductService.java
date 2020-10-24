package com.example.projektspring.service;

import com.example.projektspring.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private final Map<Integer, Product> data = new HashMap<>();

    ProductService() {
        data.put(1, new Product("marchewka", 9.99));
        data.put(2, new Product("kapusta kiszona", 5.50));
        data.put(3, new Product("Czosnek", 5.50));
        data.put(4, new Product("jablko", 1.50));
        data.put(5, new Product("cebula", 0.99));
    }

    public Map<Integer, Product> findAll() {
        return data;
    }

    public Product findById(Integer id) {
        return data.get(id);
    }

    public List<Product> findByName(String name) {
        return data.entrySet()
                .stream()
                .filter(e -> e.getValue().getName().contains(name))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Map<Integer, Product> getData() {
        return data;
    }
}
