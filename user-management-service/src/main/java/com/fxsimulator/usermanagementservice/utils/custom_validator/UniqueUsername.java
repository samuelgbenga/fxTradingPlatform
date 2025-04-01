package com.fxsimulator.usermanagementservice.utils.custom_validator;


import com.fxsimulator.usermanagementservice.utils.custom_validator.impl.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.*;

@Documented // useful for documentation
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {

    String message() default "Username is already taken";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
