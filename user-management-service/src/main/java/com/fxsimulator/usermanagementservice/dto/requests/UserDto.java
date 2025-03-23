package com.fxsimulator.usermanagementservice.dto.requests;

import com.fxsimulator.usermanagementservice.enums.RoleType;
import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String username;

    private String email;

    private String firstName ;

    private String lastName;

    private String middleName ;

    private String imageUrl;

    private RoleType roleType;

}
