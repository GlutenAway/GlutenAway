package com.glutenaway.services.impl;

import com.glutenaway.dtos.requests.ProductFilterRequest;
import com.glutenaway.dtos.requests.ProductRequestDTO;
import com.glutenaway.entities.BrandEntity;
import com.glutenaway.entities.ProductEntity;
import com.glutenaway.entities.ProductTypeEntity;
import com.glutenaway.models.Product;
import com.glutenaway.models.ProductType;
import com.glutenaway.repositories.products.ProductTypesRepository;
import com.glutenaway.repositories.products.ProductsRepository;
import com.glutenaway.services.IBrandService;
import com.glutenaway.services.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private ProductTypesRepository productTypesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product getProductByCode(Long code) {
        Optional<ProductEntity> productEntity = productsRepository.findById(code);
        if(productEntity.isEmpty()){
            throw new EntityNotFoundException("Producto con código: "+code+" no encontrado");
        }
        return modelMapper.map(productEntity,Product.class);
    }

    @Override
    public List<Product> getProducts(ProductFilterRequest request) {
        List<ProductEntity> productEntities = productsRepository.findProductsByFilters(
                request.getCode(),
                request.getProduct_type_id(),
                request.getBrand_id(),
                request.getProduct(),
                request.getUnit_id(),
                request.getPrice_from(),
                request.getPrice_to(),
                request.getStock(),
                request.getIs_deleted()

        ).orElseThrow( () -> new EntityNotFoundException("No se encontraron productos"));
        if(productEntities.isEmpty()) throw new EntityNotFoundException("No se encontraron productos");
        List<Product> products = new ArrayList<>();
        for (ProductEntity p:productEntities) {
            products.add(modelMapper.map(p,Product.class));
        }
        return products;
    }

    @Override
    public Product createProduct(ProductRequestDTO product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProduct(product.getProduct());
        productEntity.setImage(product.getImage());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setStock(product.getStock());
        productEntity.setUnit(product.getUnit());
        productEntity.setIs_deleted(false);
        BrandEntity brandEntity = modelMapper.map(brandService.getBrandById(product.getBrand_id()), BrandEntity.class);
        productEntity.setBrand(brandEntity);
        ProductTypeEntity productTypeEntity = modelMapper.map(getProductTypeById(product.getProduct_type_id()),ProductTypeEntity.class);
        productEntity.setProduct_type(productTypeEntity);
        ProductEntity productEntitySaved = productsRepository.save(productEntity);

        return modelMapper.map(productEntitySaved,Product.class);
    }

    @Override
    public Product updateProduct(Long code,ProductRequestDTO product) {
        try{
            ProductEntity productEntity = modelMapper.map(getProductByCode(code),ProductEntity.class);
            BrandEntity brandEntity = modelMapper.map(brandService.getBrandById(product.getBrand_id()), BrandEntity.class);
            ProductTypeEntity productTypeEntity = modelMapper.map(getProductTypeById(product.getProduct_type_id()),ProductTypeEntity.class);

            productEntity.setProduct_type(productTypeEntity);
            productEntity.setBrand(brandEntity);
            productEntity.setUnit(product.getUnit());
            productEntity.setPrice(product.getPrice());
            productEntity.setStock(product.getStock());
            productEntity.setImage(product.getImage());
            productEntity.setQuantity(product.getQuantity());
            productEntity.setProduct(product.getProduct());
            ProductEntity productEntitySaved =productsRepository.save(productEntity);
            return modelMapper.map(productEntitySaved,Product.class);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public Boolean deleteProduct(Long id) {
        try{
            ProductEntity pe = modelMapper.map(getProductByCode(id),ProductEntity.class);
            pe.setIs_deleted(true);
            ProductEntity peDeleted = productsRepository.save(pe);
            return peDeleted.getIs_deleted();
        }
        catch (Exception ex){
            return false;
        }

    }

    @Override
    public List<ProductType> getProductTypes() {
        List<ProductTypeEntity> productTypeEntities = productTypesRepository.findAll();
        if(productTypeEntities.isEmpty()){
            throw new EntityNotFoundException("No existen tipos de productos registrados");
        }
        List<ProductType> productTypes = new ArrayList<>();
        for (ProductTypeEntity pt:productTypeEntities) {
            productTypes.add(modelMapper.map(pt, ProductType.class));
        }
        return productTypes;
    }

    @Override
    public ProductType getProductTypeById(Long id) {
        ProductTypeEntity productTypeEntity = productTypesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de producto con id "+ id +" no encontrado"));
        return modelMapper.map(productTypeEntity, ProductType.class);
    }

    @Override
    public ProductType createProductType(ProductType productType) {
        ProductTypeEntity pte = new ProductTypeEntity();
        pte.setProduct_type(productType.getProduct_type());
        ProductTypeEntity pteSaved = productTypesRepository.save(pte);
        return modelMapper.map(pteSaved, ProductType.class);
    }

    @Override
    public ProductType updateProductType(ProductType productType) {
        ProductType pt = getProductTypeById(productType.getProduct_type_id());
        pt.setProduct_type(productType.getProduct_type());

        ProductTypeEntity pteSaved = productTypesRepository.save(modelMapper.map(pt, ProductTypeEntity.class));
        return modelMapper.map(pteSaved, ProductType.class);
    }
    @Override
    public Boolean deleteProductType(Long id) {
        try{
            ProductTypeEntity pte = modelMapper.map(getProductTypeById(id),ProductTypeEntity.class);
            productTypesRepository.delete(pte);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

}
