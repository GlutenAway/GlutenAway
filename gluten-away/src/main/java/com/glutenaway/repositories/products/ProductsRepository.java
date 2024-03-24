package com.glutenaway.repositories.products;

import com.glutenaway.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT p FROM ProductEntity p " +
            "WHERE (:code IS NULL OR p.code = :code) " +
            "AND (:product_type_id IS NULL OR p.product_type.product_type_id = :product_type_id) " +
            "AND (:brand_id IS NULL OR p.brand.brand_id = :brand_id) " +
            "AND (:product IS NULL OR p.product LIKE %:product%) " +
            "AND (:unit_id IS NULL OR p.unit = :unit_id) " +
            "AND (:price_from IS NULL OR p.price >= :price_from) " +
            "AND (:price_to IS NULL OR p.price <= :price_to) " +
            "AND (:stock IS NULL OR p.stock <= :stock)" +
            "AND (:is_deleted IS NULL OR p.is_deleted = :is_deleted)"
    )
    Optional<List<ProductEntity>> findProductsByFilters(
            @Param("code") Long code,
            @Param("product_type_id") Long productTypeId,
            @Param("brand_id") Long brandId,
            @Param("product") String product,
            @Param("unit_id") Long unitId,
            @Param("price_from") BigDecimal priceFrom,
            @Param("price_to") BigDecimal priceTo,
            @Param("stock") Integer stock,
            @Param("is_deleted") Boolean isDeleted
    );
}
