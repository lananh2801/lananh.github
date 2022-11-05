package com.example.clothes.Repository;

import com.example.clothes.Entity.BillImportProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillImportProductRepository extends JpaRepository<BillImportProduct, Long> {
}
