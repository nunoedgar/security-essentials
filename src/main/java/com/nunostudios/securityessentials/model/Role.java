package com.nunostudios.securityessentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ROLE_NAME", nullable = false, length = 100)
    private String roleName;

    @ColumnDefault("0")
    @Column(name = "SALARY", nullable = false)
    private Integer salary;


}