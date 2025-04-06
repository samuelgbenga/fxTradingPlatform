package com.fxsimulator.usermanagementservice.utils.custom_validator.impl;

import com.fxsimulator.usermanagementservice.utils.custom_validator.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    // Define regex for password strength
    private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        // Check if password matches the regex pattern
        return password.matches(PASSWORD_PATTERN);
    }
}
