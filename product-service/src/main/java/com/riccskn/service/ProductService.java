package com.riccskn.service;

import com.riccskn.dto.ProductDTO;
import com.riccskn.model.ProductModel;

import java.util.List;

public interface ProductService {

    ProductModel getProductByName(String name);

    List<ProductModel> getProducts();

    void saveProduct(ProductDTO dto);

    void deleteProduct(String name);

}
