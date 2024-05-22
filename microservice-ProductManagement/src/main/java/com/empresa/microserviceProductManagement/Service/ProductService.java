package com.empresa.microserviceProductManagement.Service;

import com.empresa.microserviceProductManagement.Entities.Products;
import com.empresa.microserviceProductManagement.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public Products save(Products products) {
        products.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return productsRepository.save(products);
    }

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Products findById(Long id) {
        return productsRepository.findById(id).orElseThrow(null);
    }

    public Products update(Long id, Products productsRequest) {
        Products existingProduct = productsRepository.findById(id).orElseThrow(null);
        existingProduct.setName(productsRequest.getName());
        existingProduct.setDescription(productsRequest.getDescription());
        existingProduct.setCategory(productsRequest.getCategory());
        existingProduct.setPrice(productsRequest.getPrice());
        return productsRepository.save(existingProduct);
    }

    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}
