package com.example.clothes.Repository;

import com.example.clothes.Entity.BillImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillImportRepository extends JpaRepository<BillImport, Long> {
}
