package com.ethihats.Ethihats.Store.service;
import com.ethihats.Ethihats.Store.model.Product;
import java.util.List;
public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product updateProduct(String id, Product productDetails);
    void deleteProduct(String id);
}
