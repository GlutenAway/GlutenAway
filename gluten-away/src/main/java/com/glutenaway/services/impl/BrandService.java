package com.glutenaway.services.impl;

import com.glutenaway.entities.BrandEntity;
import com.glutenaway.models.Brand;
import com.glutenaway.repositories.products.BrandsRepository;
import com.glutenaway.services.IBrandService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BrandsRepository brandsRepository;

    @Override
    public List<Brand> getBrands() {
        List<BrandEntity> brandsEntities = brandsRepository.findAll();
        if(brandsEntities.isEmpty()){
            throw new EntityNotFoundException("No existen marcas registradas");
        }
        List<Brand> brands = new ArrayList<>();
        for (BrandEntity b:brandsEntities) {
            brands.add(modelMapper.map(b, Brand.class));
        }
        return brands;
    }

    @Override
    public Brand getBrandById(Long id) {
        BrandEntity brandEntity = brandsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca con id "+ id +" no encontrada"));
        return modelMapper.map(brandEntity, Brand.class);
    }

    @Override
    public Brand createBrand(Brand brand) {
        BrandEntity be = new BrandEntity();
        be.setBrand(brand.getBrand());
        BrandEntity brandEntitySaved = brandsRepository.save(be);
        return modelMapper.map(brandEntitySaved, Brand.class);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand b = getBrandById(brand.getBrand_id());
        b.setBrand(brand.getBrand());

        BrandEntity beSaved = brandsRepository.save(modelMapper.map(b, BrandEntity.class));
        return modelMapper.map(beSaved, Brand.class);
    }

    @Override
    public Boolean deleteBrand(Long id) {
        try{
            BrandEntity be = modelMapper.map(getBrandById(id),BrandEntity.class);
            brandsRepository.delete(be);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
}
