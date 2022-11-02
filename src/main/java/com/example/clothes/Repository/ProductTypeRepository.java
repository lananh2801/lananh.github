package com.example.clothes.Repository;

import com.example.clothes.Entity.ProductType;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

        @Query("Select pt from ProductType pt where pt.productTypeNo = :id")
        ProductType getProductType(int id);
}
