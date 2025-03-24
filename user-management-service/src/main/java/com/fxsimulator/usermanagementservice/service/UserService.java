package com.fxsimulator.usermanagementservice.service;

import com.fxsimulator.usermanagementservice.dto.requests.UserDto;
import com.fxsimulator.usermanagementservice.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    // for now will be returning string
    String create(UserDto dto);

   // String getUserById(Long id);

    UserResponseDto getUserByEmail(String email);

    //String getUserByUserName(String userName);

    List<UserResponseDto> getAllUser();

    String updateUser(String email, UserDto dto);

    String deleteUser(String email);
}
