package com.glutenaway.services;

import com.glutenaway.dtos.requests.ProductFilterRequest;
import com.glutenaway.dtos.requests.ProductRequestDTO;
import com.glutenaway.models.Product;
import com.glutenaway.models.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product getProductByCode(Long id);
    List<Product> getProducts(ProductFilterRequest request);
    Product createProduct(ProductRequestDTO product);
    Product updateProduct(Long id,ProductRequestDTO product);
    Boolean deleteProduct(Long id);
    List<ProductType> getProductTypes();
    ProductType getProductTypeById(Long id);
    ProductType createProductType(ProductType productType);
    ProductType updateProductType(ProductType productType);
    Boolean deleteProductType(Long id);
}
