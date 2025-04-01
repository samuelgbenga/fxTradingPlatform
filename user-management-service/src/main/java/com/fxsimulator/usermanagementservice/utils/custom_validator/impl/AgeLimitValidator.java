package com.fxsimulator.usermanagementservice.utils.custom_validator.impl;

import com.fxsimulator.usermanagementservice.utils.custom_validator.AgeLimit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class AgeLimitValidator implements ConstraintValidator<AgeLimit, LocalDate> {
    int minimumAge;

    @Override
    public void initialize(AgeLimit constraintAnnotation) {
        this.minimumAge = constraintAnnotation.minimumAge();
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
        if(birthDate == null){
            return false;
        }
        LocalDate today = LocalDate.now();
        LocalDate minimumAgeYearsAgo = today.minusYears(this.minimumAge);
        return !minimumAgeYearsAgo.isBefore(birthDate);
    }
    }

