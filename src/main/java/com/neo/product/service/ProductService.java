package com.neo.product.service;

import com.neo.product.dto.ProductDTO;
import com.neo.product.mapper.ProductMapper;
import com.neo.product.model.Product;
import com.neo.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        Product savedProduct = productRepository.save(product);

        ProductDTO savedDTO = new ProductDTO();
        savedDTO.setId(savedProduct.getId());
        savedDTO.setName(savedProduct.getName());
        savedDTO.setDescription(savedProduct.getDescription());
        savedDTO.setPrice(savedProduct.getPrice());

        return savedDTO;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public ProductDTO updateProduct(ProductDTO productDTO){

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        Product updatedProduct = productRepository.save(product);
        ProductDTO updatedProductDTO = new ProductDTO();

        updatedProductDTO.setId(updatedProduct.getId());
        updatedProductDTO.setName(updatedProduct.getName());
        updatedProductDTO.setDescription(updatedProduct.getDescription());
        updatedProductDTO.setPrice(updatedProduct.getPrice());

        return updatedProductDTO;
    }

    public Void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return  null;
    }

    public Optional<Product> getOne(Long productId) {
        return Optional.of(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found" + productId)));
//        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found" + productId));
//        return productRepository.findById(product.getId());
    }
}
