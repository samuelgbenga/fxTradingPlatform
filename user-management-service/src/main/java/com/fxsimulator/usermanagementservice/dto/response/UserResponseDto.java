package com.fxsimulator.usermanagementservice.dto.response;

import com.fxsimulator.usermanagementservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String username;

    private String email;

    private String firstName ;

    private String lastName;

    private String middleName ;

    private String imageUrl;

    private Set<Role> roles;

}
