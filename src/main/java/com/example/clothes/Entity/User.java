package com.example.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "USER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ADDRESS_SHIP")
    private String addressShip;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BillImport> billImportList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_NO", nullable = false)
    private Role role;
}
