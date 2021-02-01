package com.edemko.warehousemanager.repository;

import com.edemko.warehousemanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
