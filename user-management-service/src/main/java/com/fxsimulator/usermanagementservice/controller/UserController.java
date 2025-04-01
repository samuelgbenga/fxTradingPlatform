package com.fxsimulator.usermanagementservice.controller;

import com.fxsimulator.usermanagementservice.dto.requests.UserDto;
import com.fxsimulator.usermanagementservice.dto.response.ApiResponse;
import com.fxsimulator.usermanagementservice.dto.response.UserResponseDto;
import com.fxsimulator.usermanagementservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @ModelAttribute UserDto dto) {
        UserResponseDto userResponseDto = userService.create(dto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                "success",
                "User created successfully",
                userResponseDto,
                null
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserByEmail(@PathVariable String email) {

        UserResponseDto userResponseDto = userService.getUserByEmail(email);

        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                "success",
                "User retrieved successfully",
                userResponseDto,
                null
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> getAllUsers() {

        List<UserResponseDto> userResponseDtos = userService.getAllUser();
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                "success",
                "Users retrieved successfully",
                userResponseDtos,
                null

        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{email}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@PathVariable String email, @RequestBody UserDto dto) {
        UserResponseDto userResponseDto = userService.updateUser(email, dto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                "success",
                "User updated successfully",
                userResponseDto,
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable String email) {

        String deleteResponse = userService.deleteUser(email);

        ApiResponse<String> response = new ApiResponse<>(
                "success",
                "User deleted successfully",
                deleteResponse,
                null
        );
        return ResponseEntity.ok(response);

    }
}
