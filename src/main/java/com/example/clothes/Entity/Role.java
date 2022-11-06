package com.example.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_NO")
    private Long roleNo;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> userList;
}
