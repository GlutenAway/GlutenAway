package com.glutenaway.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity product_type;
    private String image;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;
    private String product;
    private Integer quantity;
    /*@ManyToOne
    @JoinColumn(name = "unit_id")*/
    private Integer unit;
    private BigDecimal price;
    private Integer stock;
    private Boolean is_deleted;

}
