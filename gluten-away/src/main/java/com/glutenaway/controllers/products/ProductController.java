package com.glutenaway.controllers.products;

import com.glutenaway.dtos.requests.ProductFilterRequest;
import com.glutenaway.dtos.requests.ProductRequestDTO;
import com.glutenaway.models.Product;
import com.glutenaway.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductByCode(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(name = "id",required = false) Long id,
            @RequestParam(name = "product_type_id",required = false) Long product_type_id,
            @RequestParam(name = "brand_id",required = false) Long brand_id,
            @RequestParam(name = "product",required = false) String product,
            @RequestParam(name = "unit_id",required = false) Long unit_id,
            @RequestParam(name = "price_from",required = false) BigDecimal price_from,
            @RequestParam(name = "price_to",required = false) BigDecimal price_to,
            @RequestParam(name = "stock",required = false) Integer stock,
            @RequestParam(name = "is_deleted",required = false) Boolean is_deleted

    ){
        return ResponseEntity.ok(productService.getProducts(
                new ProductFilterRequest(
                        id,
                        product_type_id,
                        brand_id,
                        product,
                        unit_id,
                        price_from,
                        price_to,
                        stock,
                        is_deleted)
        ));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequestDTO product){
        return ResponseEntity.ok(productService.createProduct(product));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRequestDTO product){
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

}
