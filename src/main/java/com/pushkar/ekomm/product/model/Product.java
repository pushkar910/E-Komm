package com.pushkar.ekomm.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product")
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private String category;
    private double availableQuantity;
    private String uom;
    private double price;
    private String currency;

}
