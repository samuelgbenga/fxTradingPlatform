package com.fxsimulator.usermanagementservice.utils.custom_validator;

import com.fxsimulator.usermanagementservice.utils.custom_validator.impl.AgeLimitValidator;
import com.fxsimulator.usermanagementservice.utils.custom_validator.impl.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented // useful for documentation
@Constraint(validatedBy = AgeLimitValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeLimit {

    int minimumAge() default 18;
    String message() default "User must be at least 18 years old";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
