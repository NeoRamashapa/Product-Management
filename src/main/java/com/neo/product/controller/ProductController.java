package com.neo.product.controller;

import com.neo.product.dto.ProductDTO;
import com.neo.product.mapper.ProductMapper;
import com.neo.product.model.Product;
import com.neo.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

//    public ProductController(ProductService productService, ProductMapper productMapper) {
//        this.productService = productService;
//        this.productMapper = productMapper;
//    }

    @PostMapping("")
    public ProductDTO addProduct(@RequestBody Product product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());

        return productService.addProduct(productDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public Optional<Product> findProductById(@PathVariable Long productId){
        return productService.getOne(productId);
    }


    @PutMapping("/{productId}")
    public ProductDTO updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());

        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{productId}")
    public Void deleteProduct(@PathVariable Long productId){
        return  productService.deleteProduct(productId);
    }
}