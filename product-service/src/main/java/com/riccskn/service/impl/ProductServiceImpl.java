package com.riccskn.service.impl;

import com.riccskn.dto.ProductDTO;
import com.riccskn.exception.ResourceNotFoundException;
import com.riccskn.model.ProductModel;
import com.riccskn.repository.ProductRepository;
import com.riccskn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductModel getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Product with name: "+name+" not found"));
    }

    @Override
    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(ProductDTO dto) {
        if (productRepository.existsByName(dto.getName())) {

            throw new ResourceNotFoundException("Product with name: "+dto.getName()+" not found");

        }

        ProductModel account = new ProductModel(  dto.getName(),
                dto.getPrice());

        productRepository.save(account);
    }

    @Override
    public void deleteProduct(String name) {
        ProductModel account = productRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Product with name: "+name+" not found"));

        productRepository.delete(account);
    }
}
