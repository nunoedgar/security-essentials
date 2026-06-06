package com.nunostudios.securityessentials.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table(name = "ROLE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "ROLE_NAME", nullable = false, length = 100)
    private String roleName;

    @ColumnDefault("0")
    @Column(name = "SALARY", nullable = false)
    private Integer salary;


    @Override
    public @Nullable String getAuthority() {
        return roleName;
    }
}