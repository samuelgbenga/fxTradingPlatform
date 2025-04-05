package com.fxsimulator.usermanagementservice.service.impl;

import com.fxsimulator.usermanagementservice.dto.requests.UserDto;
import com.fxsimulator.usermanagementservice.dto.response.ImageResponseDto;
import com.fxsimulator.usermanagementservice.dto.response.UserResponseDto;
import com.fxsimulator.usermanagementservice.entity.Image;
import com.fxsimulator.usermanagementservice.entity.Role;
import com.fxsimulator.usermanagementservice.entity.User;
import com.fxsimulator.usermanagementservice.exception.*;
import com.fxsimulator.usermanagementservice.repository.ImageRepository;
import com.fxsimulator.usermanagementservice.repository.RoleRepository;
import com.fxsimulator.usermanagementservice.repository.UserRepository;
import com.fxsimulator.usermanagementservice.service.CloudinaryService;
import com.fxsimulator.usermanagementservice.service.UserService;
import com.fxsimulator.usermanagementservice.utils.ModelMapperConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapperConfig modelMapperConfig;

    private final CloudinaryService cloudinaryService;

    private final ImageRepository imageRepository;

    @Override
    public UserResponseDto create(UserDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists!");
        }


        Role role = roleRepository.findByName(dto.getRoleType())
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));


        // upload image
       Image image = upLoadImage(dto.getFile());

        User user = modelMapperConfig.convertToEntity(dto);
        user.setImage(image);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setRoles(roles);
        UserResponseDto userResponseDto = modelMapperConfig.convertToDto(userRepository.save(user));

        return userResponseDto;
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return modelMapperConfig.convertToDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(modelMapperConfig::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(String email, UserDto dto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        modelMapperConfig.updateEntityFromDto(dto, user);

        UserResponseDto userResponseDto = modelMapperConfig.convertToDto(userRepository.save(user));
        return userResponseDto;
    }

    @Override
    public String deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        // make this process asynchronous
        //cloudinaryService.deleteFile(user.getImage().getPublicId());
        deleteUserAsync(user);
        userRepository.delete(user);
        return "User has been deleted";
    }


    private Image upLoadImage(MultipartFile file){
        try {
            ImageResponseDto imageResponseDto = cloudinaryService.uploadFile(file);
            return imageRepository.save(new Image(imageResponseDto.getPublicId(), imageResponseDto.getImageUrl()));
        } catch (Exception e) {
            throw new ImageUploadException("Failed to upload image");
        }
    }

    @Async
    private CompletableFuture<Void> deleteUserAsync(User user) {
        try {
            // Delete image from Cloudinary
            if (user.getImage() != null) {
                cloudinaryService.deleteFile(user.getImage().getPublicId());
            }
            // Delete user from database
            userRepository.delete(user);
        } catch (Exception e) {
            // Log error
            throw new ImageDeletionException("Error deleting user asynchronously: " + e.getMessage());
        }
        return CompletableFuture.completedFuture(null);
    }
}
