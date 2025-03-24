package com.fxsimulator.usermanagementservice.service.impl;

import com.fxsimulator.usermanagementservice.dto.requests.UserDto;
import com.fxsimulator.usermanagementservice.dto.response.UserResponseDto;
import com.fxsimulator.usermanagementservice.entity.Role;
import com.fxsimulator.usermanagementservice.entity.User;
import com.fxsimulator.usermanagementservice.enums.RoleType;
import com.fxsimulator.usermanagementservice.repository.RoleRepository;
import com.fxsimulator.usermanagementservice.repository.UserRepository;
import com.fxsimulator.usermanagementservice.service.UserService;
import com.fxsimulator.usermanagementservice.utils.ModelMapperConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapperConfig modelMapperConfig;

    @Override
    public String create(UserDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }


        Role role = roleRepository.findByName(dto.getRoleType())
                .orElseThrow(() -> new RuntimeException("Role not found"));



        User user = modelMapperConfig.convertToEntity(dto);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setRoles(roles);
        userRepository.save(user);

        return "user as been created";
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapperConfig.convertToDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(modelMapperConfig::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String updateUser(String email, UserDto dto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        modelMapperConfig.updateEntityFromDto(dto, user);

        userRepository.save(user);
        return "User has been updated";
    }

    @Override
    public String deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return "User has been deleted";
    }
}
