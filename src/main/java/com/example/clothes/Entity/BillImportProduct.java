package com.example.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BILL_IMPORT_PRODUCT")
public class BillImportProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_PRODUCT_NO")
    private Long BillProductNo;

    @ManyToOne()
    @JoinColumn(name = "BILL_NO", nullable = false)
    private BillImport billImport;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_NO", nullable = false)
    private Product product;
}
