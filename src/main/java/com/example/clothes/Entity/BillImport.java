package com.example.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BILL_IMPORT")
public class BillImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_NO")
    private Long billNo;

    @Column(name = "TOTAL_BILL")
    private BigDecimal totalBill;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER_NO", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "billImport",fetch = FetchType.LAZY)
    private List<BillImportProduct> billImportProductList;
}
