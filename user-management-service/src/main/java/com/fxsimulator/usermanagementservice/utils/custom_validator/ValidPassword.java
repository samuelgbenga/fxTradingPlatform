package com.fxsimulator.usermanagementservice.utils.custom_validator;


import com.fxsimulator.usermanagementservice.utils.custom_validator.impl.PasswordValidator;
import com.fxsimulator.usermanagementservice.utils.custom_validator.impl.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented // useful for documentation
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a number, and a special character.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
