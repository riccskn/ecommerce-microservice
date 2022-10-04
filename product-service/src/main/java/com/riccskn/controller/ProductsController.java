package com.riccskn.controller;

import com.riccskn.dto.ProductDTO;
import com.riccskn.model.ProductModel;
import com.riccskn.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    private ProductServiceImpl service;

   @GetMapping
    public ResponseEntity<List<ProductModel>> getProducts() {
     return new ResponseEntity<List<ProductModel>>(service.getProducts(), HttpStatus.OK);
   }

   @GetMapping("/{name}")
    public ResponseEntity<ProductModel> getProductByName(@PathVariable String name) {
       return new ResponseEntity<ProductModel>(service.getProductByName(name), HttpStatus.OK);
   }

   @PostMapping
    public ResponseEntity<Void> saveProduct(@Valid @RequestBody ProductDTO dto) {
       service.saveProduct(dto);
          return new ResponseEntity<Void>(HttpStatus.OK);
   }

   @DeleteMapping
   public ResponseEntity<Void> deleteProductByName(@PathVariable String name) {
       service.deleteProduct(name);
       return new ResponseEntity<Void>(HttpStatus.OK);
   }


}
