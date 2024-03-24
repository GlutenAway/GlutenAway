package com.glutenaway.services;

import com.glutenaway.models.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBrandService {
    List<Brand> getBrands();

    Brand getBrandById(Long id);

    Brand createBrand(Brand brand);

    Brand updateBrand(Brand brand);

    Boolean deleteBrand(Long id);
}
