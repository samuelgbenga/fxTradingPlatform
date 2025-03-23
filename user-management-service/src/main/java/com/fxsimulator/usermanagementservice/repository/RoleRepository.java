package com.fxsimulator.usermanagementservice.repository;

import com.fxsimulator.usermanagementservice.entity.Role;
import com.fxsimulator.usermanagementservice.entity.User;
import com.fxsimulator.usermanagementservice.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType role);
}
