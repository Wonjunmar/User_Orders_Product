package com.example.demo.product.service;

import com.example.demo.orders.model.Orders;
import com.example.demo.orders.model.OrdersDto;
import com.example.demo.ordersproduct.model.OrdersProduct;
import com.example.demo.ordersproduct.model.OrdersProductDto;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductDto;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.user.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(ProductDto productDto) {

        productRepository.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build());
    }

    public List<ProductDto> list() {
        List<Product> result = productRepository.findAll();

        List<ProductDto> userDtos = new ArrayList<>();
        for (Product product : result) {

            ProductDto productDto = ProductDto.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .build();
            userDtos.add(productDto);
        }
        return userDtos;
    }


    public void update(ProductDto productDto) {
        productRepository.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build());
    }

    public void delete(String name) {
        productRepository.delete(Product.builder().name(name).build());
    }
}
