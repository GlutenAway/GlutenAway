package com.glutenaway.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {

    private Long product_type_id;
    @NotNull
    @NotEmpty(message = "Ingresar un nombre de tipo de producto válido")
    private String product_type;
}
