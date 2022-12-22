package com.example.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCT_TYPE")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_TYPE_NO")
    private Long productTypeNo;

    @Column(name = "PRODUCT_TYPE_NAME")
    private String productTypeName;

    @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();
}
