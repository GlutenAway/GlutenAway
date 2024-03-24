package com.glutenaway.controllers.products;

import com.glutenaway.models.Brand;
import com.glutenaway.services.IBrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private IBrandService brandService;
    @GetMapping()
    public ResponseEntity<List<Brand>> getBrands(){
        return ResponseEntity.ok(brandService.getBrands());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id){
        return ResponseEntity.ok(brandService.getBrandById(id));
    }
    @PostMapping()
    public ResponseEntity<Brand> createBrand(@RequestBody @Valid Brand brand){
        return ResponseEntity.ok(brandService.createBrand(brand));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody @Valid Brand brand){
        brand.setBrand_id(id);
        return ResponseEntity.ok(brandService.updateBrand(brand));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBrand(@PathVariable Long id){
        return ResponseEntity.ok(brandService.deleteBrand(id));
    }
}
