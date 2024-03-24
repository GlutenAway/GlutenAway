package com.glutenaway.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long code;
    private ProductType product_type;
    private String image;
    private Brand brand;
    private String product;
    private Integer quantity;
    private Integer unit;
    private BigDecimal price;
    private Integer stock;
    private Boolean is_deleted;
}
