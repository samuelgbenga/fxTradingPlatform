package com.fxsimulator.usermanagementservice.service;

//import com.fxsimulator.usermanagementservice.dto.requests.ImageRequestDto;
import com.fxsimulator.usermanagementservice.dto.requests.UserDto;
import com.fxsimulator.usermanagementservice.dto.response.UserResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    // for now will be returning string
    UserResponseDto create(UserDto dto);

   // String getUserById(Long id);

    UserResponseDto getUserByEmail(String email);

    //String getUserByUserName(String userName);

    List<UserResponseDto> getAllUser();

    UserResponseDto updateUser(String email, UserDto dto);

    String deleteUser(String email);
}
