package com.fxsimulator.usermanagementservice.service;

import com.fxsimulator.usermanagementservice.dto.requests.UserDto;

import java.util.List;

public interface UserService {

    // for now will be returning string
    String create(UserDto dto);

   // String getUserById(Long id);

    UserDto getUserByEmail(String email);

    //String getUserByUserName(String userName);

    List<UserDto> getAllUser();

    String updateUser(String email, UserDto dto);

    String deleteUser(String email);
}
