package com.fxsimulator.usermanagementservice.utils;

import com.fxsimulator.usermanagementservice.entity.Role;
import com.fxsimulator.usermanagementservice.enums.RoleType;
import com.fxsimulator.usermanagementservice.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void initRoles() {
        Arrays.stream(RoleType.values()).forEach(roleType -> {
            if (roleRepository.findByName(roleType).isEmpty()) {
                Role role = new Role();
                role.setName(roleType);
                roleRepository.save(role);
            }
        });
    }
}