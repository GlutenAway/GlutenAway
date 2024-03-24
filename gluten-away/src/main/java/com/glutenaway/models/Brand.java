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
public class Brand {

    private Long brand_id;
    @NotNull
    @NotEmpty(message = "Ingresar un nombre de marca válido")
    private String brand;
}
