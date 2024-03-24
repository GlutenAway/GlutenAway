package com.glutenaway.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterRequest {
    private Long code;
    private Long product_type_id;
    private Long brand_id;
    private String product;
    private Long unit_id;
    private BigDecimal price_from;
    private BigDecimal price_to;
    private Integer stock;
    private Boolean is_deleted = false;
}
