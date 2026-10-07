package br.edu.ifsuldeminas.mch.productsapi.controller;

import br.edu.ifsuldeminas.mch.productsapi.dtos.ProductRecordDto;
import br.edu.ifsuldeminas.mch.productsapi.models.ProductModel;
import br.edu.ifsuldeminas.mch.productsapi.repository.ProductsRepository;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> createProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        var product = productsRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productModel);

    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<ProductModel>> getAllProducts() {
        var products = productsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable UUID id, @RequestBody ProductRecordDto productRecordDto) {
        var optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var productModel = optionalProduct.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        var updatedproduct = productsRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedproduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable UUID id) {
        var optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productsRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(optionalProduct.get());

    }
}

