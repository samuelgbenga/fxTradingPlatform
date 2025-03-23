package com.fxsimulator.usermanagementservice.utils;

import com.fxsimulator.usermanagementservice.dto.requests.UserDto;
import com.fxsimulator.usermanagementservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
    private final ModelMapper modelMapper;

    public ModelMapperConfig() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setSkipNullEnabled(true); // Prevents null values from overwriting existing values
    }

    @Bean
    public ModelMapper modelMapper() {
        return modelMapper;
    }

    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public void updateEntityFromDto(UserDto dto, User user) {
        modelMapper.map(dto, user);
    }
}
