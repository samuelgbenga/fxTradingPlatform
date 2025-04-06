package com.fxsimulator.usermanagementservice.utils.custom_validator.impl;

import com.fxsimulator.usermanagementservice.repository.UserRepository;
import com.fxsimulator.usermanagementservice.utils.custom_validator.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username != null && !userRepository.existsByUsername(username);
    }


}
