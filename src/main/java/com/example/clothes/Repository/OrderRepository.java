package com.example.clothes.Repository;

import com.example.clothes.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.oderNo = :id")
    public Order getOrderBy(Long id);

    @Modifying
    @Query("delete from Order where oderNo = :id")
    public void deleteById(Long id);

    @Modifying
    @Query("delete from Order where user.userNo = :userNo")
    public void deleteUserByUserNo(Long userNo);
}
