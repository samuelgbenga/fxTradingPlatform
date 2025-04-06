package com.fxsimulator.usermanagementservice.dto.requests;

import com.fxsimulator.usermanagementservice.enums.RoleType;

import com.fxsimulator.usermanagementservice.utils.custom_validator.AgeLimit;
import com.fxsimulator.usermanagementservice.utils.custom_validator.UniqueUsername;
import com.fxsimulator.usermanagementservice.utils.custom_validator.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @UniqueUsername // Custom annotation
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String middleName; // Optional field, no validation needed

    private String imageUrl; // This will be set after uploading the file

    private RoleType roleType; // No validation required, should be an Enum

    @AgeLimit(minimumAge = 16, message = "You are too young to attend the meeting")
    private LocalDate birthDate;

    @ValidPassword
    private String password;

    private MultipartFile file; // No validation because it's optional


}
