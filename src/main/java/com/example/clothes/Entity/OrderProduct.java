package com.example.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ODER_PRODUCT")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ODER_PRODUCT_NO")
    private Long orderProductNo;

//    @Column(name = "AMOUNT_OF_PRODUCT")
//    private int amountOfProduct;
//
//    @Column(name = "AMOUT_OF_MONEY")
//    private Long amountOfMoney;

    @ManyToOne()
    @JoinColumn(name = "ODER_NO", nullable = false)
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_NO", nullable = false)
    private Product product;
}
