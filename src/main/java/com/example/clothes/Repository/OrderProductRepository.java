package com.example.clothes.Repository;

import com.example.clothes.Entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    @Modifying
    @Query("delete from OrderProduct where order.oderNo = :id ")
    public void deleteOrderProductsById(Long id);
}
