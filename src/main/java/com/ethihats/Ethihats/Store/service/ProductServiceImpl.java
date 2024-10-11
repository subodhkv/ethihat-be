package com.ethihats.Ethihats.Store.service;

import com.ethihats.Ethihats.Store.exception.ProductNotFoundException;
import com.ethihats.Ethihats.Store.model.Product;
import com.ethihats.Ethihats.Store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public Product updateProduct(String id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setDiscountPrice(productDetails.getDiscountPrice());
        product.setQuantityInStock(productDetails.getQuantityInStock());
        product.setCategories(productDetails.getCategories());
        product.setBrand(productDetails.getBrand());
        product.setImages(productDetails.getImages());
        product.setRating(productDetails.getRating());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
