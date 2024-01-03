package com.example.demo.product.repository;

import com.example.demo.product.model.Product;
import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Optional<Product> findByName(String name);

}
