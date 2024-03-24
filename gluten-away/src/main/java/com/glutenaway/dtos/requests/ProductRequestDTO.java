package com.glutenaway.dtos.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    @NotNull
    @Min(value = 1, message = "El id del tipo de producto debe ser positivo")
    private Long product_type_id;

    private String image;

    private Long brand_id;
    @NotNull
    @NotEmpty(message = "Ingresar un nombre de producto")
    private String product;
    @NotNull
    @Min(value = 1, message = "Ingresar una cantidad del producto válida")
    private Integer quantity;
    @NotNull
    @Min(value = 1, message = "La unidad de la cantidad del producto debe ser 1(Gr) o 2(Lts)")
    @Max(value = 2, message = "La unidad de la cantidad del producto debe ser 1(Gr) o 2(Lts)")
    private Integer unit;
    @NotNull
    @Min(value = 1, message = "Ingresar un precio de producto válido")
    private BigDecimal price;
    @NotNull
    @Min(value = 1, message = "Ingresar un stock de producto válido")
    private Integer stock;
}
