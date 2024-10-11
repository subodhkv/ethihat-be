package com.ethihats.Ethihats.Store.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private int quantityInStock;

    private List<String> categories;

    private String brand;

    private List<String> images;

    private double rating;
}
