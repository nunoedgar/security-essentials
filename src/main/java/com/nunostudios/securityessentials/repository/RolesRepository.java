package com.nunostudios.securityessentials.repository;

import com.nunostudios.securityessentials.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Integer> {
}
