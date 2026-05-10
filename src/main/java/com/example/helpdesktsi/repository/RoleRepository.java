package com.example.helpdesktsi.repository;

import com.example.helpdesktsi.enums.UserRole;
import com.example.helpdesktsi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(UserRole roleName);
}
