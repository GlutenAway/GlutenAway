package com.glutenaway.controllers.products;

import com.glutenaway.models.ProductType;
import com.glutenaway.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-types")
public class ProductTypeController {
    @Autowired
    private IProductService productService;
    @GetMapping()
    public ResponseEntity<List<ProductType>> getProductTypes(){
        return ResponseEntity.ok(productService.getProductTypes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductTypeById(id));
    }
    @PostMapping()
    public ResponseEntity<ProductType> createProductType(@RequestBody @Valid ProductType productType){
        return ResponseEntity.ok(productService.createProductType(productType));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductType> updateProductType(@PathVariable Long id, @RequestBody @Valid ProductType productType){
        productType.setProduct_type_id(id);
        return ResponseEntity.ok(productService.updateProductType(productType));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProductType(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProductType(id));
    }
}
