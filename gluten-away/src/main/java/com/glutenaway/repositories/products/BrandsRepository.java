package com.glutenaway.repositories.products;

import com.glutenaway.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepository extends JpaRepository<BrandEntity,Long> {
}
