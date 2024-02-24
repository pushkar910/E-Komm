package com.pushkar.ekomm.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 3187148317787923993L;

    private String id;
    private String name;
    private String description;
    private String category;
    private double availableQuantity;
    private String uom;
    private double price;
    private String currency;
}
